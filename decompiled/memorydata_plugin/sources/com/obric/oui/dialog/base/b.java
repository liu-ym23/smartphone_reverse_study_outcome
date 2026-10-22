package com.obric.oui.dialog.base;

import android.content.Context;
import android.view.View;
import android.view.Window;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.anim.DialogAnimStyle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\b'\u0018\u0000 \u00142\u00020\u0001:\u0002\u0013\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0004J\b\u0010\u0012\u001a\u00020\u000eH\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/dialog/base/OBaseDialog;", "Lcom/obric/oui/dialog/base/AbstractDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isDismissing", "", "()Z", "setDismissing", "(Z)V", "useNewDialogAnim", "getUseNewDialogAnim", "setUseNewDialogAnim", "dismiss", "", "onStart", "originDismiss", "performEnterAnimation", "performExitAnimation", "ButtonConfig", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class b extends AbstractDialog {
    public static final C0747b d = null;
    private boolean e;
    private boolean f;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0002\u0010\nR\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/dialog/base/OBaseDialog$ButtonConfig;", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "onClick", "Lkotlin/Function0;", "", "customizer", "Lkotlin/Function1;", "Lcom/obric/oui/button/OButton;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getCustomizer", "()Lkotlin/jvm/functions/Function1;", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "getText", "()Ljava/lang/String;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f13816a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Function0<Unit> f13817b;
        private final Function1<OButton, Unit> c;

        public a(String r3, Function0<Unit> r4, Function1<? super OButton, Unit> r5) {
            Function0<Unit> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
            Function1<OButton, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            this.f13816a = r3;
            this.f13817b = r6;
            this.c = r7;
        }

        public /* synthetic */ a(String r2, Function0 r3, Function1 r4, int r5, DefaultConstructorMarker r6) {
            Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
            Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
            if ((r5 & 4) == 0) goto L5;
            r8 = null;
        L5:
            this(r2, r7, r8);
        }

        public final String a() {
            return this.f13816a;
        }

        public final Function0<Unit> b() {
            return this.f13817b;
        }

        public final Function1<OButton, Unit> c() {
            return this.c;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.dialog.base.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/dialog/base/OBaseDialog$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0747b {
        private C0747b() {
        }

        public /* synthetic */ C0747b(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        d = new C0747b(null);
    }

    public b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, false, false);
        this.e = true;
    }

    private static final void a(final b r8) {
        Intrinsics.checkNotNullParameter(r8, "this$0");
        DialogAnimStyle r1 = DialogAnimStyle.f13797a;
        View r2 = r8.j();
        Window r3 = r8.getWindow();
        boolean r4 = !r8.l();
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        com.obric.oui.animation.easy.b.a(r1.a(r2, r3, r4, r8.a(r0), r8.e).b(), null, (Function1) ZeusTransformUtils.preCheckCast(new OBaseDialog$performEnterAnimation$1$1(r8), Function1.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(new OBaseDialog$performEnterAnimation$1$2(r8), Function1.class, "com.obric.memorydata.plugin"), 1, null);
    }

    public static /* synthetic */ void lambda$QZQ2OmKAkcU7wpk8yBaqIpv4ah4(b r0) {
        a(r0);
    }

    public final void b(boolean r1) {
        this.f = r1;
    }

    public final boolean b() {
        return this.f;
    }

    public final void c() {
        com.obric.oui.animation.easy.b<View> r0 = DialogAnimStyle.f13797a.a(j(), getWindow(), !l(), this.e);
        com.obric.oui.animation.easy.b.a(r0, null, (Function1) ZeusTransformUtils.preCheckCast(new OBaseDialog$performExitAnimation$1$1(this), Function1.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(new OBaseDialog$performExitAnimation$1$2(this), Function1.class, "com.obric.memorydata.plugin"), 1, null);
        r0.b();
    }

    public final void d() {
        j().post(new $$Lambda$b$QZQ2OmKAkcU7wpk8yBaqIpv4ah4(this));
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.f == false) goto L6;
        com.obric.oui.c.a.b.b("BaseDialog", "dismiss() called but dialog is already dismissing, ignore.");
        return;
    L6:
        this.f = true;
        c();
    }

    public void e() {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.obric.oui.c.a.b.a("BaseDialog", "origin Dismiss exception!", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        this.f = false;
        d();
    }
}
