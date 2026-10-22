package com.larus.uaigc.instruction;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.bytedance.keva.Keva;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.network.http.HttpExtKt;
import com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarInfoManager;
import com.larus.uaigc.impl.databinding.LarusItemActionBarAvatarInstructionBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.z0;
import wa8.n0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0002=>B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010#\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\b\u0010'\u001a\u00020$H\u0016J\b\u0010(\u001a\u00020$H\u0002J\b\u0010)\u001a\u00020$H\u0002J\b\u0010*\u001a\u00020$H\u0002J\b\u0010+\u001a\u00020$H\u0002J\b\u0010,\u001a\u00020$H\u0002J\n\u0010-\u001a\u0004\u0018\u00010\u001aH\u0016J\u000f\u0010.\u001a\u0004\u0018\u00010/H\u0016¢\u0006\u0002\u00100J\b\u00101\u001a\u00020/H\u0016J\b\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u00020$H\u0002J\b\u00108\u001a\u000209H\u0002J\u0012\u0010:\u001a\u00020$2\b\b\u0002\u0010;\u001a\u000209H\u0002J\b\u0010<\u001a\u000209H\u0002R#\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R#\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\r\u001a\u0004\b \u0010!R\u0012\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0004\n\u0002\u00104¨\u0006?"}, d2 = {"Lcom/larus/uaigc/instruction/AvatarTemplateWidget;", "Lcom/larus/bmhome/instruction/base/AbsInstructionWidget;", "Lcom/larus/uaigc/creation/IReportInstructionWidget;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "cache", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getCache", "()Lcom/bytedance/keva/Keva;", "cache$delegate", "Lkotlin/Lazy;", "binding", "Lcom/larus/uaigc/impl/databinding/LarusItemActionBarAvatarInstructionBinding;", "controller", "Lcom/larus/uaigc/instruction/AvatarTemplateController;", "getController", "()Lcom/larus/uaigc/instruction/AvatarTemplateController;", "currentBindData", "Lcom/larus/bmhome/actionbar/model/ActionBarAvatarInstructionItem;", "getCurrentBindData", "()Lcom/larus/bmhome/actionbar/model/ActionBarAvatarInstructionItem;", "avatarUrl", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "getAvatarUrl", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "avatarUrl$delegate", "frescoCloseableHolder", "Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/FrescoCloseableHolder;", "getFrescoCloseableHolder", "()Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/FrescoCloseableHolder;", "frescoCloseableHolder$delegate", "init", "", "attrs", "Landroid/util/AttributeSet;", "onBindView", "initView", "mobButtonShow", "bindObserver", "observeReplicaInfoIfInitialNull", "createDigitalAvatar", "getButtonName", "getImageEditFunctionId", "", "()Ljava/lang/Integer;", "getMultiItemType", "memoryRedDotVersion", "", "Ljava/lang/Long;", "getRedDotFromLocalCache", "Lcom/larus/uaigc/instruction/AvatarTemplateWidget$AvatarTemplateRedDot;", "tryToShowRedDot", "shouldShowRedDotByCheckVersion", "", "updateRedDotVersion", "updateMemoryVersion", "shouldPropagateAICreationHostSource", "Companion", "AvatarTemplateRedDot", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class AvatarTemplateWidget extends AbsInstructionWidget implements com.larus.uaigc.creation.e {
    public static final int[] k = null;
    public final Lazy f;
    public LarusItemActionBarAvatarInstructionBinding g;
    public final Lazy h;
    public final Lazy i;
    public Long j;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/uaigc/instruction/AvatarTemplateWidget$AvatarTemplateRedDot;", "", "versionCode", "", "<init>", "(J)V", "getVersionCode", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class a {

        @SerializedName("version_code")
        private final long versionCode;

        public a() {
            this(0);
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.versionCode == ((a) r8).versionCode) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            long r0 = this.versionCode;
            return (int) (r0 ^ (r0 >>> 32));
        }

        public final String toString() {
            return "AvatarTemplateRedDot(versionCode=" + this.versionCode + ')';
        }

        public final long a() {
            return this.versionCode;
        }

        public /* synthetic */ a(int r3) {
            this(0);
        }

        public a(long r1) {
            this.versionCode = r1;
        }
    }

    public static final class b {
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/larus/uaigc/instruction/AvatarTemplateWidget$getRedDotFromLocalCache$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/larus/uaigc/instruction/AvatarTemplateWidget$AvatarTemplateRedDot;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class c extends TypeToken<a> {
        public c() {
        }
    }

    private final a getRedDotFromLocalCache() {
        int r0 = 0;
        a r1 = (a) HttpExtKt.f.fromJson(getCache().getString("red_dot_cache_key", "{}"), new c().getType());     // Catch: Exception -> L7
        if (r1 != null) goto L12;
        return new a(r0);
    L12:
        return r1;
    L7:
        e = move-exception;
        FLogger.a.e("AvatarTemplateWidget", "save cache error=" + e.getMessage());
        return new a(r0);
    }

    static {
        int[] r0 = new int[2];
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl(Integer.valueOf(Color.parseColor("#FFAC57")));     // Catch: Throwable -> L5
    L7:
        Object r3 = null;
        if (Result.isFailure-impl(r2) == false) goto L10;
        r2 = null;
    L10:
        Integer r4 = (Integer) r2;
        int r5 = -16777216;
        if (r4 == null) goto L13;
        int r6 = r4.intValue();
    L14:
        r0[0] = r6;
        Object r7 = Result.constructor-impl(Integer.valueOf(Color.parseColor("#F467C9")));     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r7) == true) goto L23;
        r3 = r7;
    L23:
        Integer r8 = (Integer) r3;
        if (r8 == null) goto L26;
        r5 = r8.intValue();
    L26:
        r0[1] = r5;
        k = r0;
        return;
    L17:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L13:
        r6 = -16777216;
    L5:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    private final z0<String> getAvatarUrl() {
        return (z0) this.h.getValue();
    }

    private final Keva getCache() {
        return (Keva) this.f.getValue();
    }

    private final com.larus.uaigc.createpage.component.mediaselector.imageselector.c getFrescoCloseableHolder() {
        return (com.larus.uaigc.createpage.component.mediaselector.imageselector.c) this.i.getValue();
    }

    @Override // com.larus.uaigc.creation.e
    public String getButtonName() {
        DigitalAvatarInfoManager.a.getClass();
        if (DigitalAvatarInfoManager.g() == true) goto L7;
        wa8.a r0 = getCurrentBindData();
        if (r0 != null) goto L12;
    L10:
        return null;
    L12:
        return r0.b;
    L7:
        wa8.a r1 = getCurrentBindData();
        if (r1 == null) goto L10;
        return r1.c;
    }

    private final com.larus.uaigc.instruction.a getController() {
        return (com.larus.uaigc.instruction.a) getController();
    }

    private final wa8.a getCurrentBindData() {
        com.larus.uaigc.instruction.a r0 = getController();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y5() {
        CoroutineScope r0 = getComponentScope();
        if (r0 == null) goto L5;
        BuildersKt.launch$default(r0, null, null, new AvatarTemplateWidget$initView$1(this, null), 3, null);
    L5:
        LarusItemActionBarAvatarInstructionBinding r1 = this.g;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L8:
        e1.d(r1.a, new com.larus.uaigc.instruction.b(this));
        getViewTreeObserver().addOnDrawListener(new o(this));
        CoroutineScope r7 = getComponentScope();
        if (r7 == null) goto L11;
        BuildersKt.launch$default(r7, null, null, new AvatarTemplateWidget$bindObserver$1(this, null), 3, null);
    L11:
        DigitalAvatarInfoManager.a.getClass();
        if (DigitalAvatarInfoManager.k.getValue() != null) goto L16;
        CoroutineScope r8 = getComponentScope();
        if (r8 == null) goto L16;
        BuildersKt.launch$default(r8, null, null, new AvatarTemplateWidget$observeReplicaInfoIfInitialNull$1(this, null), 3, null);
    L16:
        com.larus.bmhome.view.actionbar.edit.c r2 = getViewModel();
        if (r2 == null) goto L24;
        Integer r3 = r2.getInstructionType();
        if (r3 == null) goto L24;
        if (r3.intValue() != 28) goto L24;
        boolean r4 = true;
    L25:
        if (r4 == false) goto L30;
        com.larus.bmhome.view.actionbar.edit.c r5 = getViewModel();
        if (r5 == null) goto L31;
        r5.onComponentVisibilityChanged(this, true);
        return;
    L31:
        return;
    L30:
        return;
    L24:
        r4 = false;
        goto L25
    }

    @Override // com.larus.uaigc.creation.e
    public Integer getImageEditFunctionId() {
        wa8.a r0 = getCurrentBindData();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    @Override // com.larus.uaigc.creation.e
    public int getMultiItemType() {
        if (getController() == null) goto L5;
        return 8;
    L5:
        return 0;
    }

    public AvatarTemplateWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 6, 0);
        this.f = LazyKt.lazy(new com.larus.uaigc.instruction.c());
        this.h = LazyKt.lazy(new d());
        this.i = LazyKt.lazy(new e());
    }

    public static final /* synthetic */ z0 i6(AvatarTemplateWidget r0) {
        return r0.getAvatarUrl();
    }

    public static final /* synthetic */ wa8.a k6(AvatarTemplateWidget r0) {
        return r0.getCurrentBindData();
    }

    public static final /* synthetic */ com.larus.uaigc.createpage.component.mediaselector.imageselector.c n6(AvatarTemplateWidget r0) {
        return r0.getFrescoCloseableHolder();
    }

    public static final void o6(AvatarTemplateWidget r10) {
        com.larus.uaigc.instruction.a r0 = r10.getController();
        boolean r1 = true;
        if (r0 == null) goto L12;
        up8.b r2 = ((up8.b) r0).f;
        if (r2 == null) goto L12;
        Integer r3 = r2.g;
        if (r3 == null) goto L12;
        if (r3.intValue() != 18) goto L12;
        boolean r4 = true;
    L13:
        DigitalAvatarInfoManager.a.getClass();
        boolean r5 = DigitalAvatarInfoManager.j();
        LarusItemActionBarAvatarInstructionBinding r6 = null;
        if (r4 == false) goto L41;
        if (r5 == false) goto L41;
        Long r7 = r10.j;
        if (r7 == null) goto L19;
        long r8 = r7.longValue();
    L20:
        wa8.a r9 = r10.getCurrentBindData();
        if (r9 == null) goto L25;
        Long r11 = r9.d;
        if (r11 == null) goto L25;
        long r12 = r11.longValue();
    L27:
        if (r8 < r12) goto L30;
        r1 = false;
    L30:
        if (r1 == false) goto L41;
        if (o0.d(n0.a()) == false) goto L41;
        LarusItemActionBarAvatarInstructionBinding r13 = r10.g;
        if (r13 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L36:
        r13.d.setText(n0.a());
        LarusItemActionBarAvatarInstructionBinding r14 = r10.g;
        if (r14 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L40:
        e1.x(r6.d);
        r10.s6(false);
        return;
    L39:
        r6 = r14;
    L25:
        r12 = 0;
        goto L27
    L19:
        r8 = r10.getRedDotFromLocalCache().a();
        r10.j = Long.valueOf(r8);
    L41:
        LarusItemActionBarAvatarInstructionBinding r15 = r10.g;
        if (r15 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L45:
        e1.o(r6.d);
        return;
    L44:
        r6 = r15;
    L12:
        r4 = false;
        goto L13
    }

    public final void s6(boolean r6) {
        wa8.a r2 = getCurrentBindData();
        if (r2 == null) goto L7;
        Long r3 = r2.d;
        if (r3 == null) goto L7;
        long r4 = r3.longValue();
    L8:
        getRedDotFromLocalCache().getClass();
        a r5 = new a(r4);
        if (r6 == false) goto L16;
        this.j = Long.valueOf(r4);
    L16:
        String r7 = HttpExtKt.f.toJson(r5);     // Catch: Exception -> L13
        getCache().storeString("red_dot_cache_key", r7);     // Catch: Exception -> L13
        FLogger.a.i("AvatarTemplateWidget", "setItemHasClicked save cache newEntityString=" + r7);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        FLogger.a.e("AvatarTemplateWidget", "setItemHasClicked save cache error=" + e.getMessage());
        return;
    L7:
        r4 = 0;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V5(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        LayoutInflater.from(r4).inflate(2131562473, this);
        int r6 = 2131369157;
        TextView r0 = (TextView) ViewBindings.findChildViewById(this, 2131369157);
        if (r0 == null) goto L13;
        r6 = 2131374718;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(this, 2131374718);
        if (r1 == null) goto L13;
        r6 = 2131374739;
        if (ViewBindings.findChildViewById(this, 2131374739) == null) goto L13;
        r6 = 2131390835;
        TextView r2 = (TextView) ViewBindings.findChildViewById(this, 2131390835);
        if (r2 == null) goto L13;
        LarusItemActionBarAvatarInstructionBinding r7 = new LarusItemActionBarAvatarInstructionBinding(this, r0, r1, r2);
        setBackground(ContextCompat.getDrawable(r4, v19.c.b(2130970543, r4, 2131238559)));
        this.g = r7;
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r6)));
    }
}
