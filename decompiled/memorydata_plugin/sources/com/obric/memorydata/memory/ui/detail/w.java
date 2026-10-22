package com.obric.memorydata.memory.ui.detail;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.viewbinding.ViewBinding;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.memory.CollectContentMemoryEntity;
import com.obric.capabilitykit.entity.memory.CollectStoreMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.memory.databinding.ItemMemoryDetailBinding;
import com.obric.memorydata.memory.databinding.ItemMemoryDetailSourceBinding;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.memory.ui.BaseMemoryActivity;
import com.obric.memorydata.memory.ui.list.MemorySourceIconScene;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.App;
import com.obric.memorydata.middleware.api.settings.Extras;
import com.obric.memorydata.middleware.api.settings.SettingsManager;
import com.obric.memorydata.utils.GsonUtil;
import com.obric.memorydata.utils.ba;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rH\u0002J \u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u001e\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\rH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/MemoryDetailSourceViewHolder;", "Lcom/obric/memorydata/memory/ui/detail/MemoryDetailViewHolder;", "Lcom/obric/memorydata/memory/databinding/ItemMemoryDetailBinding;", "binding", "<init>", "(Lcom/obric/memorydata/memory/databinding/ItemMemoryDetailBinding;)V", "sourceMessageBinding", "Lcom/obric/memorydata/memory/databinding/ItemMemoryDetailSourceBinding;", "bind", "", "memoryItem", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "bindMemorySource", "", "memoryEntity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "sourceTextVisible", "screenshotVisible", "bindSourceText", "bindScreenshot", "bindSourceLink", "setExpandedClickArea", "view", "Landroid/view/View;", "expand", "viewSourceLink", "context", "Landroid/content/Context;", "sourcePackageName", "", "bindSourceApp", "sourceLinkVisible", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class w extends x<ItemMemoryDetailBinding> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ItemMemoryDetailSourceBinding f10882a;

    public w(ItemMemoryDetailBinding r3) {
        Intrinsics.checkNotNullParameter(r3, "binding");
        super((ViewBinding) ZeusTransformUtils.preCheckCast(r3, ViewBinding.class, "com.obric.memorydata.plugin"));
    }

    private final void a(Context r13, String r14, MemoryEntity r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
        Object r2 = null;
        if (r15.getProductType() != 6) goto L8;
        a((AppEntity) ZeusTransformUtils.preCheckCast(r15, AppEntity.class, "com.obric.memorydata.plugin"), MemoryEventTracker.ReactionType.ORIGIN_PAGE);
        LinearLayout r17 = ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).getRoot();
        Intrinsics.checkNotNullExpressionValue(r17, "getRoot(...)");
        LifecycleCoroutineScope r18 = y.a((View) ZeusTransformUtils.preCheckCast(r17, View.class, "com.obric.memorydata.plugin"));
        if (r18 == null) goto L70;
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(r18, al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryDetailSourceViewHolder$viewSourceLink$1(this, r15, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L70:
        return;
    L8:
        if (com.obric.memorydata.utils.c.f13193a.a(r14) == false) goto L63;
        String r0 = r15.getSourceLink();
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L12;
    L15:
        boolean r4 = true;
    L17:
        if (r4 == false) goto L21;
        ComponentName r19 = com.obric.memorydata.utils.c.f13193a.a(r16, r14);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryDetailItemViewHolder", "sourceLink is null launcherComponent is launcherComponent", false, 4, null);
        if (r19 == null) goto L72;
        Intent r1 = new Intent();
        r1.setComponent(r19);
        r1.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        a((AppEntity) ZeusTransformUtils.preCheckCast(r15, AppEntity.class, "com.obric.memorydata.plugin"), MemoryEventTracker.ReactionType.ORIGIN_APP);
        com.obric.memorydata.memory.utils.f.f11537a.a(r16, r1);
        return;
    L72:
        return;
    L21:
        a((AppEntity) ZeusTransformUtils.preCheckCast(r15, AppEntity.class, "com.obric.memorydata.plugin"), MemoryEventTracker.ReactionType.ORIGIN_PAGE);
        String r12 = r15.getSourceLinkType();
        if (Intrinsics.areEqual(r12, MemorySourceLinkType.DEEPLINK) == false) goto L24;
    L27:
        Intent r110 = new Intent("android.intent.action.VIEW", Uri.parse(r0));
    L28:
        r110.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        IRunLog r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r5 = new StringBuilder().append("goto link: ").append(r14).append(", ").append(r15.getSourceLinkType()).append(", ");
        if (Intrinsics.areEqual(r15.getSourceLinkType(), MemorySourceLinkType.INTENT) == true) goto L31;
        String r7 = r15.getSourceLink();
    L32:
        IRunLog.a.a(r6, "MemoryDetailItemViewHolder", r5.append(r7).toString(), false, 4, null);
        if (Intrinsics.areEqual(r15.getSourceLinkType(), "url") == false) goto L62;
        SettingsManager r111 = SettingsManager.INSTANCE;
        String r8 = r111.getSettingsStr(SettingsManager.KEY_PAGE_CONTEXT_SETTINGS);
        if (r8 != null) goto L65;
    L36:
        Object r112 = null;
    L41:
        com.obric.memorydata.middleware.impl.settings.g r113 = (com.obric.memorydata.middleware.impl.settings.g) ZeusTransformUtils.preCheckCast(r112, com.obric.memorydata.middleware.impl.settings.g.class, "com.obric.memorydata.plugin");
        if (r113 == null) goto L58;
        List<App> r114 = r113.c();
        if (r114 == null) goto L58;
        Iterator r115 = ((Iterable) ZeusTransformUtils.preCheckCast(r114, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L47:
        if (r115.hasNext() == false) goto L51;
        Object r9 = r115.next();
        if (Intrinsics.areEqual(((App) ZeusTransformUtils.preCheckCast(r9, App.class, "com.obric.memorydata.plugin")).getPackageName(), r14) == false) goto L47;
        r2 = r9;
    L51:
        App r116 = (App) ZeusTransformUtils.preCheckCast(r2, App.class, "com.obric.memorydata.plugin");
        if (r116 == null) goto L58;
        Extras r117 = r116.getExtras();
        if (r117 == null) goto L58;
        String r118 = r117.getUrlMode();
        if (r118 == null) goto L58;
    L60:
        if (Intrinsics.areEqual(r118, "self") == false) goto L62;
        ae.f10847a.a(r16, r110, r14);
    L58:
        r118 = "default";
        goto L60
    L65:
        r112 = r111.getGSON().fromJson(r8, com.obric.memorydata.middleware.impl.settings.g.class);     // Catch: Exception -> L39
    L39:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), GsonUtil.TAG, "json error ：" + e, null, 4, null);
    L62:
        com.obric.memorydata.memory.utils.f.f11537a.a(r16, r110);
        return;
    L31:
        r7 = "*";
        goto L32
    L24:
        if (Intrinsics.areEqual(r12, "url") == true) goto L27;
        r110 = com.obric.memorydata.memory.s.f10512a.a(r0);
        goto L28
    L12:
        if (r3.length() == 0) goto L15;
        r4 = false;
        goto L17
    L63:
        a((AppEntity) ZeusTransformUtils.preCheckCast(r15, AppEntity.class, "com.obric.memorydata.plugin"), MemoryEventTracker.ReactionType.MARKET);
        com.obric.memorydata.utils.d r119 = com.obric.memorydata.utils.d.f13204a;
        Context r120 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r120, "null cannot be cast to non-null type android.app.Activity");
        r119.b((Context) ZeusTransformUtils.preCheckCast((Activity) ZeusTransformUtils.preCheckCast(r120, Activity.class, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r14);
    }

    private final void a(final View r3, final boolean r4) {
        ViewParent r2 = r3.getParent();
        if (ZeusTransformUtils.instanceOf(r2, View.class) == false) goto L5;
        final View r5 = (View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin");
    L6:
        if (r5 != null) goto L8;
        return;
    L8:
        r5.post(new $$Lambda$w$Llf4XWkuM_cXrb2H7wdWhxh4DKs(r4, r3, r5));
        return;
    L5:
        r5 = null;
        goto L6
    }

    private static final void a(MemoryEntity r5, w r6, FileEntity r7, View r8) {
        MemoryEventTracker r9 = MemoryEventTracker.f10515a;
        AppEntity r10 = (AppEntity) ZeusTransformUtils.preCheckCast(r5, AppEntity.class, "com.obric.memorydata.plugin");
        int r0 = MemoryEventTracker.ReactionType.IMAGE.getValue();
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(r6.c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r2, "getContext(...)");
        Activity r3 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ba.b(r2), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, BaseMemoryActivity.class) == false) goto L5;
        BaseMemoryActivity r4 = (BaseMemoryActivity) ZeusTransformUtils.preCheckCast(r3, BaseMemoryActivity.class, "com.obric.memorydata.plugin");
    L6:
        if (r4 == null) goto L9;
        String r11 = r4.getEnterFrom();
        if (r11 == null) goto L9;
    L10:
        r9.a(r10, r0, r11);
        com.obric.memorydata.memory.utils.f r12 = com.obric.memorydata.memory.utils.f.f11537a;
        Context r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(r6.c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r13, "getContext(...)");
        r12.a(r13, r7);
        return;
    L9:
        r11 = "";
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    private static final void a(w r2, Ref.ObjectRef r3, MemoryEntity r4, View r5) {
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(r2.c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r6, "getContext(...)");
        r2.a(r6, (String) ZeusTransformUtils.preCheckCast(r3.element, String.class, "com.obric.memorydata.plugin"), r4);
    }

    private static final void a(boolean r4, View r5, View r6) {
        if (r4 == false) goto L4;
        Rect r7 = new Rect();
        r5.getHitRect(r7);
        float r1 = 4;
        r7.top -= MathKt.roundToInt(TypedValue.applyDimension(1, r1, Resources.getSystem().getDisplayMetrics()));
        r7.bottom += MathKt.roundToInt(TypedValue.applyDimension(1, r1, Resources.getSystem().getDisplayMetrics()));
        r6.setTouchDelegate(new TouchDelegate(r7, r5));
        return;
    L4:
        r6.setTouchDelegate(null);
    }

    private final boolean a(MemoryEntity r19, boolean r20) {
        String r0 = com.obric.memorydata.memory.ui.e.f10891a.a(r19.getLastModifiedTime());
        x.a r1 = x.f10883b;
        Pair<String, String> r2 = x.a(r19);
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.component1(), String.class, "com.obric.memorydata.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r2.component2(), String.class, "com.obric.memorydata.plugin");
        ItemMemoryDetailSourceBinding r4 = this.f10882a;
        if (r4 != null) goto L5;
    L32:
        return false;
    L5:
        if (r3 == null) goto L31;
        TextView r10 = r4.tvAppName;
        Intrinsics.checkNotNullExpressionValue(r10, "tvAppName");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin"), true);
        TextView r7 = r4.tvAppName;
        if (r20 == false) goto L9;
    L12:
        r4.tvUpdateTime.setText((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"));
        TextView r6 = r4.tvUpdateTime;
        Intrinsics.checkNotNullExpressionValue(r6, "tvUpdateTime");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"), false);
        Object r5 = ZeusTransformUtils.preCheckCast(r3 + " · " + r0, CharSequence.class, "com.obric.memorydata.plugin");
    L13:
        r7.setText((CharSequence) r5);
        if (r19.getProductType() != 11) goto L16;
    L29:
        ImageView r9 = r4.ivAppIcon;
        Intrinsics.checkNotNullExpressionValue(r9, "ivAppIcon");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin"), false);
        return true;
    L16:
        if (com.obric.memorydata.database.model.e.f9611a.a(r19.getProductType()) == true) goto L29;
        com.obric.memorydata.memory.ui.list.af r11 = com.obric.memorydata.memory.ui.list.ae.f11174a.a(r19.getProductType(), MemorySourceIconScene.DETAIL);
        com.obric.memorydata.utils.icon.b r12 = com.obric.memorydata.utils.icon.b.f13229a;
        Context r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r13, "getContext(...)");
        ImageView r14 = r4.ivAppIcon;
        Intrinsics.checkNotNullExpressionValue(r14, "ivAppIcon");
        if (r11 == null) goto L21;
        String r15 = r11.b();
    L22:
        if (r11 == null) goto L24;
        Integer r16 = Integer.valueOf(r11.a());
    L25:
        if (r11 == null) goto L27;
        boolean r17 = r11.c();
    L28:
        com.obric.memorydata.utils.icon.b.a(r12, r13, r14, r8, null, 0, null, null, r15, r16, r17, 120, null);
        ImageView r18 = r4.ivAppIcon;
        Intrinsics.checkNotNullExpressionValue(r18, "ivAppIcon");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r18, View.class, "com.obric.memorydata.plugin"), true);
        return true;
    L27:
        r17 = true;
        goto L28
    L24:
        r16 = null;
        goto L25
    L21:
        r15 = null;
        goto L22
    L9:
        if (r19.getProductType() == 20) goto L12;
        r4.tvUpdateTime.setText((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"));
        TextView r21 = r4.tvUpdateTime;
        Intrinsics.checkNotNullExpressionValue(r21, "tvUpdateTime");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r21, View.class, "com.obric.memorydata.plugin"), true);
        r5 = ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");
        goto L13
    L31:
        TextView r22 = r4.tvAppName;
        Intrinsics.checkNotNullExpressionValue(r22, "tvAppName");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r22, View.class, "com.obric.memorydata.plugin"), false);
        r4.tvAppName.setText((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"));
        ImageView r23 = r4.ivAppIcon;
        Intrinsics.checkNotNullExpressionValue(r23, "ivAppIcon");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r23, View.class, "com.obric.memorydata.plugin"), true);
        r4.ivAppIcon.setImageDrawable(null);
        goto L32
    }

    private final boolean a(MemoryEntity r6, boolean r7, boolean r8) {
        if (r6.getSourceLinkType() == null) goto L5;
        boolean r9 = true;
    L7:
        if (r6.getSourceAppName() == null) goto L9;
    L18:
        boolean r1 = true;
    L19:
        ConstraintLayout r3 = null;
        if (r9 == true) goto L28;
        if (r1 == true) goto L28;
        if (r6.getProductType() == 11) goto L28;
        if (com.obric.memorydata.database.model.e.f9611a.a(r6.getProductType()) == true) goto L28;
        this.f10882a = null;
        return false;
    L28:
        LinearLayout r10 = ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).llMemorySource;
        Intrinsics.checkNotNullExpressionValue(r10, "llMemorySource");
        ItemMemoryDetailSourceBinding r11 = this.f10882a;
        if (r11 != null) goto L31;
        this.f10882a = ItemMemoryDetailSourceBinding.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), (ViewGroup) ZeusTransformUtils.preCheckCast(r10, ViewGroup.class, "com.obric.memorydata.plugin"), true);
    L58:
        ItemMemoryDetailSourceBinding r12 = this.f10882a;
        if (r12 == null) goto L63;
        ConstraintLayout r13 = r12.getRoot();
        if (r13 == null) goto L63;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r14, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        float r2 = 8;
        r15.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, r2, Resources.getSystem().getDisplayMetrics()));
        r15.bottomMargin = MathKt.roundToInt(TypedValue.applyDimension(1, r2, Resources.getSystem().getDisplayMetrics()));
        r13.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r15, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
    L63:
        a(r6, d(r6));
        return true;
    L31:
        if (r11 == null) goto L35;
        ConstraintLayout r16 = r11.getRoot();
        if (r16 == null) goto L35;
        ViewParent r17 = r16.getParent();
    L37:
        if (Intrinsics.areEqual(r17, r10) == true) goto L58;
        ItemMemoryDetailSourceBinding r18 = this.f10882a;
        if (r18 == null) goto L43;
        ConstraintLayout r19 = r18.getRoot();
        if (r19 == null) goto L43;
        ViewParent r20 = r19.getParent();
    L45:
        if (ZeusTransformUtils.instanceOf(r20, ViewGroup.class) == false) goto L47;
        ViewGroup r21 = (ViewGroup) ZeusTransformUtils.preCheckCast(r20, ViewGroup.class, "com.obric.memorydata.plugin");
    L48:
        if (r21 == null) goto L54;
        ItemMemoryDetailSourceBinding r4 = this.f10882a;
        if (r4 == null) goto L52;
        ConstraintLayout r5 = r4.getRoot();
    L53:
        r21.removeView((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin"));
        goto L54
    L52:
        r5 = null;
    L54:
        ItemMemoryDetailSourceBinding r22 = this.f10882a;
        if (r22 == null) goto L57;
        r3 = r22.getRoot();
    L57:
        r10.addView((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"));
        goto L58
    L47:
        r21 = null;
    L43:
        r20 = null;
    L35:
        r17 = null;
        goto L37
    L9:
        if (ZeusTransformUtils.instanceOf(r6, CollectContentMemoryEntity.class) == false) goto L13;
        if (((CollectContentMemoryEntity) ZeusTransformUtils.preCheckCast(r6, CollectContentMemoryEntity.class, "com.obric.memorydata.plugin")).getAppName() != null) goto L18;
    L13:
        if (ZeusTransformUtils.instanceOf(r6, CollectStoreMemoryEntity.class) == true) goto L15;
    L17:
        r1 = false;
        goto L19
    L15:
        if (((CollectStoreMemoryEntity) ZeusTransformUtils.preCheckCast(r6, CollectStoreMemoryEntity.class, "com.obric.memorydata.plugin")).getAppName() == null) goto L17;
    L5:
        r9 = false;
        goto L7
    }

    private final boolean b(MemoryEntity r7) {
        String r8 = r7.getSourceText();
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        TextView r9 = ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).tvSourceContentTitle;
        Intrinsics.checkNotNullExpressionValue(r9, "tvSourceContentTitle");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin"), false);
        ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).tvSourceContent.setText((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"));
        TextView r6 = ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).tvSourceContent;
        Intrinsics.checkNotNullExpressionValue(r6, "tvSourceContent");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"), false);
        return false;
    L13:
        TextView r2 = ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).tvSourceContentTitle;
        Intrinsics.checkNotNullExpressionValue(r2, "tvSourceContentTitle");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"), true);
        TextView r3 = ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).tvSourceContent;
        Intrinsics.checkNotNullExpressionValue(r3, "tvSourceContent");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"), true);
        ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).tvSourceContent.setText((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"));
        return true;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L10
    }

    private final boolean c(final MemoryEntity r7) {
        final FileEntity r0 = r7.getScreenshot();
        if (r0 != null) goto L6;
        ImageView r6 = ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).imageSource;
        Intrinsics.checkNotNullExpressionValue(r6, "imageSource");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"), false);
        return false;
    L6:
        ImageView r4 = ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).imageSource;
        Intrinsics.checkNotNullExpressionValue(r4, "imageSource");
        y.a(r4, r0, null, 2, null);
        ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).imageSource.setOnClickListener(new $$Lambda$w$p6sLf4ElEMPYaMa9DHRIQFXccMY(r7, this, r0));
        ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).imageSource.setVisibility(0);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [T, java.lang.String] */
    private final boolean d(final MemoryEntity r9) {
        ItemMemoryDetailSourceBinding r0 = this.f10882a;
        boolean r1 = false;
        if (r0 != null) goto L5;
        return false;
    L5:
        T r4 = 0;
        if (r9.getSourceLinkType() == null) goto L8;
    L14:
        final Ref.ObjectRef r2 = new Ref.ObjectRef();
        r2.element = r9.getSourcePackageName();
        if (r2.element != 0) goto L24;
        if (ZeusTransformUtils.instanceOf(r9, CollectContentMemoryEntity.class) == false) goto L20;
        r4 = ((CollectContentMemoryEntity) ZeusTransformUtils.preCheckCast(r9, CollectContentMemoryEntity.class, "com.obric.memorydata.plugin")).getAppPkgName();
    L22:
        r2.element = r4;
        goto L24
    L20:
        if (ZeusTransformUtils.instanceOf(r9, CollectStoreMemoryEntity.class) == false) goto L22;
        r4 = ((CollectStoreMemoryEntity) ZeusTransformUtils.preCheckCast(r9, CollectStoreMemoryEntity.class, "com.obric.memorydata.plugin")).getAppPkgName();
    L24:
        if (r2.element == 0) goto L12;
        r0.getRoot().setOnClickListener(new $$Lambda$w$RBbgxd3DpCVC3vSiROWBd2hTqdI(this, r2, r9));
        ConstraintLayout r10 = r0.getRoot();
        Intrinsics.checkNotNullExpressionValue(r10, "getRoot(...)");
        View r11 = (View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin");
        r1 = true;
    L11:
        a(r11, r1);
    L12:
        TextView r8 = r0.tvViewSource;
        Intrinsics.checkNotNullExpressionValue(r8, "tvViewSource");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), r1);
        return r1;
    L8:
        if (r9.getProductType() == 6) goto L14;
        r0.getRoot().setOnClickListener(null);
        ConstraintLayout r12 = r0.getRoot();
        Intrinsics.checkNotNullExpressionValue(r12, "getRoot(...)");
        r11 = (View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.memorydata.plugin");
        goto L11
    }

    public static /* synthetic */ void lambda$Llf4XWkuM_cXrb2H7wdWhxh4DKs(boolean r0, View r1, View r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$RBbgxd3DpCVC3vSiROWBd2hTqdI(w r0, Ref.ObjectRef r1, MemoryEntity r2, View r3) {
        a(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$p6sLf4ElEMPYaMa9DHRIQFXccMY(MemoryEntity r0, w r1, FileEntity r2, View r3) {
        a(r0, r1, r2, r3);
    }

    @Override // com.obric.memorydata.memory.ui.data.c
    public void b(com.obric.memorydata.memory.ui.data.a r5) {
        Intrinsics.checkNotNullParameter(r5, "memoryItem");
        super.b(r5);
        RunLog.INSTANCE.debug("MemoryDetailItemViewHolder", "bind memory source");
        if (ZeusTransformUtils.instanceOf(r5, com.obric.memorydata.memory.ui.data.a.e.class) == false) goto L5;
        com.obric.memorydata.memory.ui.data.a.e r6 = (com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r5, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin");
    L6:
        if (r6 == null) goto L18;
        MemoryEntity r7 = r6.b();
        if (r7 == null) goto L19;
        boolean r0 = b(r7);
        boolean r2 = c(r7);
        boolean r8 = a(r7, r0, r2);
        LinearLayout r4 = ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).llMemorySource;
        Intrinsics.checkNotNullExpressionValue(r4, "llMemorySource");
        View r9 = (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin");
        if (r0 == true) goto L15;
        if (r2 == true) goto L15;
        if (r8 == true) goto L15;
        boolean r10 = false;
    L16:
        com.obric.oui.common.util.o.a(r9, r10);
        return;
    L15:
        r10 = true;
        goto L16
    L19:
        return;
    L18:
        return;
    L5:
        r6 = null;
        goto L6
    }
}
