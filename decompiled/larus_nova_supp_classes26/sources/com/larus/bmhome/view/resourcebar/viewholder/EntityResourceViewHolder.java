package com.larus.bmhome.view.resourcebar.viewholder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.view.resourcebar.bean.ItemStatus;
import com.larus.bmhome.view.resourcebar.bean.Mode;
import com.larus.bmhome.view.resourcebar.bean.ResourceBarConfig;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.chat.common.databinding.LarusFileResourceInspectFailedLayoutBinding;
import com.larus.chat.common.databinding.LarusFileResourceItemViewBinding;
import com.larus.chat.common.databinding.LarusFileResourceParseFailedLayoutBinding;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.view.b0;
import com.larus.platform.model.chat.UploadFilePolicy;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b&\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016J\u001a\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020'2\u0006\u0010 \u001a\u00020!H\u0004J\u0010\u0010(\u001a\u00020'2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010)\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0016J\u001a\u0010+\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR&\u0010\u000e\u001a\r\u0012\t\u0012\u00070\u0010¢\u0006\u0002\b\u00110\u000f8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R&\u0010\u0016\u001a\r\u0012\t\u0012\u00070\u0017¢\u0006\u0002\b\u00110\u000f8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u0018\u0010\u0013¨\u0006-"}, d2 = {"Lcom/larus/bmhome/view/resourcebar/viewholder/EntityResourceViewHolder;", "Lcom/larus/bmhome/view/resourcebar/viewholder/PayloadResourceViewHolder;", "config", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;", "viewBinding", "Lcom/larus/chat/common/databinding/LarusFileResourceItemViewBinding;", "<init>", "(Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;Lcom/larus/chat/common/databinding/LarusFileResourceItemViewBinding;)V", "getViewBinding", "()Lcom/larus/chat/common/databinding/LarusFileResourceItemViewBinding;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "parseFailedStub", "Lcom/larus/common_ui/view/ViewStubManager;", "Lcom/larus/chat/common/databinding/LarusFileResourceParseFailedLayoutBinding;", "Lkotlin/jvm/internal/EnhancedNullability;", "getParseFailedStub", "()Lcom/larus/common_ui/view/ViewStubManager;", "parseFailedStub$delegate", "Lkotlin/Lazy;", "inspectFailedStub", "Lcom/larus/chat/common/databinding/LarusFileResourceInspectFailedLayoutBinding;", "getInspectFailedStub", "inspectFailedStub$delegate", "bindPayloads", "", "payloads", "", "", "bind", "data", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;", "callback", "Lcom/larus/bmhome/view/resourcebar/viewholder/BaseResourceViewHolder$Callback;", "setElementsVisibility", "setContentBackground", "shouldShowParseFailedUI", "", "isErrorStatus", "setContentInfo", "onClickOpen", "setListeners", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class EntityResourceViewHolder extends PayloadResourceViewHolder {
    public static final /* synthetic */ int f = 0;
    public final LarusFileResourceItemViewBinding b;
    public final Context c;
    public final Lazy d;
    public final Lazy e;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ItemStatus.values().length];
            r0[ItemStatus.UPLINKING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ItemStatus.UPLINK_FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ItemStatus.PARSE_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public void Y3(ResourceItemBean r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    public final b0<LarusFileResourceInspectFailedLayoutBinding> V3() {
        return (b0) this.e.getValue();
    }

    public final b0<LarusFileResourceParseFailedLayoutBinding> W3() {
        return (b0) this.d.getValue();
    }

    public final Context getContext() {
        return this.c;
    }

    public static boolean X3(ResourceItemBean r5) {
        ItemStatus r6 = r5.getStatus();
        if (r6 != ItemStatus.UPLINK_FAILED) goto L5;
        boolean r0 = true;
    L7:
        if (r6 != ItemStatus.INSPECT_FAILED) goto L9;
        boolean r3 = true;
    L11:
        if (r6 != ItemStatus.PARSE_FAILED) goto L13;
        boolean r7 = true;
    L14:
        if (r0 == true) goto L19;
        if (r3 == true) goto L20;
        if (r7 == true) goto L21;
        return true;
    L21:
        return false;
    L20:
        return false;
    L19:
        return false;
    L13:
        r7 = false;
        goto L14
    L9:
        r3 = false;
        goto L11
    L5:
        r0 = false;
        goto L7
    }

    public static boolean b4(ResourceItemBean r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        if (r2.getStatus() != ItemStatus.PARSE_FAILED) goto L9;
        boolean r0 = UploadFilePolicy.a;
        if (UploadFilePolicy.a == true) goto L7;
    L8:
        return true;
    L7:
        if (r2.getResourceType() != ResourceType.FILE) goto L8;
    L9:
        return false;
    }

    @Override // com.larus.bmhome.view.resourcebar.viewholder.PayloadResourceViewHolder
    public final void U3(List<Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "payloads");
        Object r6 = CollectionsKt.firstOrNull(r5);
        if ((r6 instanceof Integer) == false) goto L5;
        Integer r7 = (Integer) r6;
    L6:
        if (r7 == null) goto L8;
        long r0 = r7.intValue();
    L9:
        this.b.o.setProgress(r0);
        FLogger.a.i("EntityResourceViewHolder", "bindPayloads, linkProgress:" + r0);
        return;
    L8:
        r0 = 0;
        goto L9
    L5:
        r7 = null;
        goto L6
    }

    public void Z3(ResourceItemBean r6) {
        Intrinsics.checkNotNullParameter(r6, "data");
        if (X3(r6) == true) goto L5;
    L9:
        ItemStatus r0 = r6.getStatus();
        View r3 = this.b.d;
        int r1 = b.a[r0.ordinal()];
        if (r1 == 1) goto L22;
        if (r1 != 2) goto L14;
        int r7 = 2131239530;
    L25:
        r3.setBackgroundResource(r7);
        return;
    L14:
        if (r1 == 3) goto L17;
        r7 = v19.c.b(2130970786, this.c, 2131239525);
        goto L25
    L17:
        if (b4(r6) == false) goto L19;
        r7 = 2131239509;
        goto L25
    L19:
        r7 = v19.c.b(2130970786, this.c, 2131239525);
        goto L25
    L22:
        if (Intrinsics.areEqual(r6.getExt().get("ext_silent_upload"), Boolean.TRUE) == false) goto L24;
        r7 = v19.c.b(2130970786, this.c, 2131239525);
        goto L25
    L24:
        r7 = v19.c.b(2130970787, this.c, 2131239531);
        goto L25
    L5:
        if (Intrinsics.areEqual(r6.getExt().get("ext_show_re_select_layout"), Boolean.TRUE) == false) goto L9;
        View r8 = this.b.d;
        if (r8 == null) goto L27;
        r8.setBackgroundResource(v19.c.b(2130970786, r8.getContext(), 2131239525));
        return;
    }

    public void a4(ResourceItemBean r11) {
        Intrinsics.checkNotNullParameter(r11, "data");
        ConstraintLayout r0 = this.b.a;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L43;
        r1.width = r11.getItemWidth();
        r1.height = r11.getItemHeight();
        r0.setLayoutParams(r1);
        int r4 = 0;
        this.b.a.setPadding(0, r11.getPaddingTop(), i5.r0(), r11.getPaddingBottom());
        if (r11.getStatus() != ItemStatus.UPLINKING) goto L11;
        if (Intrinsics.areEqual(r11.getExt().get("ext_spring_review_mode"), Boolean.TRUE) == false) goto L9;
        this.b.k.a(12.0f, 2.5f);
        this.b.k.setProgress(25);
        return;
    L9:
        this.b.o.a(12.0f, 2.5f);
        this.b.o.setProgress(r11.getUpLinkProgress());
        return;
    L11:
        if (b4(r11) == false) goto L37;
        W3().b();
        LarusFileResourceParseFailedLayoutBinding r12 = (LarusFileResourceParseFailedLayoutBinding) W3().c;
        if (r12 == null) goto L48;
        AppCompatTextView r13 = r12.d;
        if (r13 == null) goto L49;
        int r2 = nt8.a.a;
        CharSequence r3 = r13.getText();
        int r5 = ((Number) i5.R0.getValue()).intValue();
        float[] r6 = {12.0f, 11.0f, 10.0f};
        Intrinsics.checkNotNullParameter(r3, ShareType.TEXT);
        Intrinsics.checkNotNullParameter(r6, "spSizes");
        ArraysKt.sortDescending(r6);
    L17:
        if (r4 >= 3) goto L22;
        float r7 = r6[r4];
        Paint r8 = new Paint();
        float r9 = Float.valueOf(r7).floatValue();
        Resources r10 = AppHost.a.getApplication().getResources();
        r8.setTextSize(TypedValue.applyDimension(2, r9, WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics())));
        if (r8.measureText(r3.toString()) <= r5) goto L20;
        r4 = r4 + 1;
        goto L17
    L20:
        Float r14 = Float.valueOf(r7);
    L23:
        if (r14 == null) goto L30;
        LarusFileResourceParseFailedLayoutBinding r15 = (LarusFileResourceParseFailedLayoutBinding) W3().c;
        if (r15 == null) goto L29;
        AppCompatImageView r16 = r15.c;
        if (r16 == null) goto L29;
        e1.x(r16);
    L29:
        r13.setTextSize(r14.floatValue());
        return;
    L30:
        LarusFileResourceParseFailedLayoutBinding r17 = (LarusFileResourceParseFailedLayoutBinding) W3().c;
        if (r17 == null) goto L35;
        AppCompatImageView r18 = r17.c;
        if (r18 == null) goto L35;
        e1.o(r18);
    L35:
        r13.setTextSize(10.0f);
        return;
    L22:
        r14 = null;
        goto L23
    L49:
        return;
    L48:
        return;
    L37:
        if (r11.getStatus() == ItemStatus.UPLINK_SUCCESS) goto L39;
        return;
    L39:
        if (Intrinsics.areEqual(r11.getExt().get("ext_spring_review_mode"), Boolean.TRUE) == false) goto L53;
        this.b.k.a(12.0f, 2.5f);
        this.b.k.setProgress(25);
        return;
    L53:
        return;
    L43:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public EntityResourceViewHolder(ResourceBarConfig r2, LarusFileResourceItemViewBinding r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "viewBinding");
        super(r2, r3.a);
        this.b = r3;
        this.c = r3.a.getContext();
        this.d = LazyKt.lazy(new g(this));
        this.e = LazyKt.lazy(new h(this));
    }

    @Override // com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder
    public final void T3(final ResourceItemBean r11, final lt8.a r12) {
        Intrinsics.checkNotNullParameter(r11, "data");
        FLogger r0 = FLogger.a;
        r0.i("EntityResourceViewHolder", "bind, type=" + r11.getResourceType() + ", status=" + r11.getStatus() + ", progress=" + r11.getUpLinkProgress());
        ItemStatus r1 = r11.getStatus();
        boolean r3 = b4(r11);
        ItemStatus r4 = ItemStatus.UPLINKING;
        if (r1 != r4) goto L5;
        r0.i("EntityResourceViewHolder", "[setElementsVisibility] status" + r1);
    L5:
        AppCompatImageView r2 = this.b.j;
        Mode r5 = this.a.getMode();
        Mode r6 = Mode.SHOW;
        if (r5 != r6) goto L8;
        int r7 = 8;
    L9:
        r2.setVisibility(r7);
        Object r8 = r11.getExt().get("ext_silent_upload");
        Boolean r9 = Boolean.TRUE;
        boolean r10 = Intrinsics.areEqual(r8, r9);
        FrameLayout r13 = this.b.p;
        if (r10 == true) goto L13;
        if (r1 != r4) goto L13;
        int r14 = 0;
    L14:
        r13.setVisibility(r14);
        FrameLayout r15 = this.b.i;
        if (r1 != ItemStatus.UPLINK_FAILED) goto L17;
        int r16 = 0;
    L18:
        r15.setVisibility(r16);
        boolean r17 = Intrinsics.areEqual(r11.getExt().get("local_item_attachment"), "1");
        ConstraintLayout r18 = this.b.e;
        if (r17 == false) goto L21;
        float r19 = 0.5f;
    L22:
        r18.setAlpha(r19);
        if (r1 != ItemStatus.INSPECT_FAILED) goto L25;
        V3().b();
    L25:
        if (r3 == false) goto L27;
        W3().b();
    L28:
        AppCompatImageView r20 = this.b.m;
        if (r3 == false) goto L31;
        int r21 = 8;
    L32:
        r20.setVisibility(r21);
        AppCompatTextView r22 = this.b.n;
        if (r3 == false) goto L35;
        int r23 = 8;
    L36:
        r22.setVisibility(r23);
        if (X3(r11) == true) goto L39;
    L41:
        e1.o(this.b.h);
        this.b.r.setContentDescription(this.c.getString(2131898849));
    L43:
        if (r1 == r4) goto L45;
    L50:
        ItemStatus r24 = ItemStatus.UPLINK_SUCCESS;
        if (r1 == r24) goto L53;
    L55:
        if (r1 == r24) goto L59;
        if (r1 == ItemStatus.SUCCESS) goto L59;
    L61:
        this.b.b.setBackgroundColor(0);
        this.b.b.setBackgroundColor(0);
    L62:
        Z3(r11);
        a4(r11);
        e1.d(this.b.j, new com.larus.bmhome.view.resourcebar.viewholder.b(r12, r11));
        e1.d(this.b.i, new c(r12, r11));
        e1.d(this.b.e, new d(r11, this, r12));
        if (this.a.getMode() != r6) goto L65;
        this.b.e.setOnLongClickListener(new e(r12, r11));
    L66:
        LarusFileResourceInspectFailedLayoutBinding r25 = (LarusFileResourceInspectFailedLayoutBinding) V3().c;
        if (r25 == null) goto L71;
        FrameLayout r26 = r25.a;
        if (r26 == null) goto L71;
        e1.d(r26, new f(r12, r11));
    L71:
        this.b.s.setActionListener(new i(r12, r11, this));
        return;
    L65:
        this.b.e.setOnLongClickListener(null);
    L59:
        if (Intrinsics.areEqual(r11.getExt().get("ext_spring_review_mode"), r9) == true) goto L61;
        this.b.b.setBackgroundResource(2131239534);
        this.b.t.setBackgroundResource(2131239534);
        goto L62
    L53:
        if (Intrinsics.areEqual(r11.getExt().get("ext_spring_review_mode"), r9) == false) goto L55;
        this.b.p.setVisibility(8);
        this.b.q.setVisibility(0);
        goto L55
    L45:
        if (Intrinsics.areEqual(r11.getExt().get("ext_spring_review_mode"), r9) == false) goto L47;
        this.b.p.setVisibility(8);
        this.b.q.setVisibility(0);
        goto L50
    L47:
        if (r10 == false) goto L49;
        this.b.p.setVisibility(8);
        goto L50
    L49:
        this.b.p.setVisibility(0);
        goto L50
    L39:
        if (Intrinsics.areEqual(r11.getExt().get("ext_show_re_select_layout"), r9) == false) goto L41;
        e1.x(this.b.h);
        e1.o(this.b.p);
        this.b.r.setContentDescription(this.c.getString(2131898870));
        goto L43
    L35:
        r23 = 0;
        goto L36
    L31:
        r21 = 0;
        goto L32
    L27:
        W3().a();
        goto L28
    L21:
        r19 = 1.0f;
        goto L22
    L17:
        r16 = 8;
    L13:
        r14 = 8;
        goto L14
    L8:
        r7 = 0;
        goto L9
    }
}
