package com.bytedance.ai.applet.app;

import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.bytedance.ai.bridge.remote.model.AppMeta;
import com.bytedance.ai.model.objects.Icons;
import com.bytedance.ai.resource.AppletResourceTool;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.app.AppletApplication$addShortcut$1$1", f = "AppletApplication.kt", i = {}, l = {559, 565}, m = "invokeSuspend", n = {}, s = {})
final class AppletApplication$addShortcut$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppletAppActivity $activity;
    int label;
    final /* synthetic */ AppletApplication this$0;

    /* JADX INFO: renamed from: com.bytedance.ai.applet.app.AppletApplication$addShortcut$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.applet.app.AppletApplication$addShortcut$1$1$1", f = "AppletApplication.kt", i = {0}, l = {566}, m = "invokeSuspend", n = {"$this$withContext"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppletAppActivity $activity;
        final /* synthetic */ String $appletName;
        final /* synthetic */ String $iconUrl;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AppletApplication this$0;

        public AnonymousClass1(AppletApplication r1, String r10, AppletAppActivity r11, String r12, Continuation<? super AnonymousClass1> r13) {
            this.this$0 = r1;
            this.$iconUrl = r10;
            this.$activity = r11;
            this.$appletName = r12;
            super(2, r13);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            AnonymousClass1 r12 = new AnonymousClass1(this.this$0, this.$iconUrl, this.$activity, this.$appletName, r11);
            r12.L$0 = r10;
            return r12;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r11 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            CoroutineScope r12 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r10);
        L11:
            Bitmap r13 = (Bitmap) r10;
            if (r13 == null) goto L32;
            AppCompatActivity r14 = this.$activity;
            AppletApplication r15 = this.this$0;
            String r16 = this.$appletName;
            int r17 = com.bytedance.ai.utils.n.a;
            String r18 = r15.j().o();
            Intrinsics.checkNotNullParameter(r14, "context");
            Intrinsics.checkNotNullParameter(r18, "appletId");
            Intent r19 = new Intent(r14.getApplicationContext(), AppletFullScreenActivity.class);
            r19.putExtra("appletId", r18);
            r19.setData(UriProtector.parse(r18));
            r19.setAction("android.intent.action.VIEW");
            int r20 = Build.VERSION.SDK_INT;
            if (r20 < 25) goto L34;
            ShortcutManager r21 = (ShortcutManager) ContextCompat.getSystemService(r14, ShortcutManager.class);
            if (r21 == null) goto L34;
            if (r20 < 26) goto L34;
            if (r21.isRequestPinShortcutSupported() == false) goto L34;
            if (r16 != null) goto L23;
        L26:
            if (r11 == false) goto L29;
            r16 = "unknown";
        L29:
            Icon r22 = Icon.createWithBitmap(r13);
            if (r22 == null) goto L34;
            r21.requestPinShortcut(new ShortcutInfo.Builder(r14, "doubao_app." + r18).setShortLabel(r16).setIcon(r22).setIntent(r19).build(), null);
            goto L34
        L23:
            if (r16.length() == 0) goto L26;
            r11 = false;
        L34:
            return Unit.INSTANCE;
        L32:
            AppletApplication.a(this.this$0, this.$activity);
            goto L34
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            CoroutineScope r23 = (CoroutineScope) this.L$0;
            AppletResourceTool r24 = AppletResourceTool.a;
            String r25 = this.this$0.j().x;
            String r26 = this.$iconUrl;
            this.L$0 = r23;
            this.label = 1;
            r24.getClass();
            r10 = AppletResourceTool.r(r25, r26, this);
            if (r10 != r0) goto L11;
            return r0;
        }
    }

    public AppletApplication$addShortcut$1$1(AppletApplication r1, AppletAppActivity r10, Continuation<? super AppletApplication$addShortcut$1$1> r11) {
        this.this$0 = r1;
        this.$activity = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AppletApplication$addShortcut$1$1(this.this$0, this.$activity, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r10 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r11);
    L48:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r11);
    L13:
        AppMeta r12 = (AppMeta) r11;
        if (r12 == null) goto L17;
        String r13 = r12.getIconUrl();
        if (r13 == null) goto L17;
    L31:
        String r14 = r13;
    L32:
        if (r12 == null) goto L35;
        String r15 = r12.getAppName();
        if (r15 == null) goto L35;
    L36:
        String r16 = r15;
        if (r14 != null) goto L39;
    L42:
        if (r10 == true) goto L46;
        com.bytedance.ai.infra.thread_pool.a r17 = com.bytedance.ai.infra.thread_pool.b.a;
        AnonymousClass1 r18 = new AnonymousClass1(this.this$0, r14, this.$activity, r16, null);
        this.label = 2;
        if (BuildersKt.withContext(r17, r18, this) != r0) goto L48;
        return r0;
    L46:
        AppletApplication.a(this.this$0, this.$activity);
        goto L48
    L39:
        if (r14.length() == 0) goto L42;
        r10 = false;
    L35:
        r15 = this.this$0.j().a;
    L17:
        Icons r19 = this.this$0.j().g;
        if (r19 == null) goto L20;
        r13 = r19.get3x();
    L21:
        if (r13 != null) goto L31;
        Icons r20 = this.this$0.j().g;
        if (r20 == null) goto L25;
        r13 = r20.get2x();
    L26:
        if (r13 != null) goto L31;
        Icons r21 = this.this$0.j().g;
        if (r21 == null) goto L30;
        r13 = r21.get1x();
        goto L31
    L30:
        r14 = null;
        goto L32
    L25:
        r13 = null;
        goto L26
    L20:
        r13 = null;
        goto L21
    L10:
        ResultKt.throwOnFailure(r11);
        AppletApplication r110 = this.this$0;
        this.label = 1;
        r11 = r110.k(this);
        if (r11 != r0) goto L13;
        return r0;
    }
}
