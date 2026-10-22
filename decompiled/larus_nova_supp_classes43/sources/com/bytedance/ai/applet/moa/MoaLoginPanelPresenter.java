package com.bytedance.ai.applet.moa;

import com.bytedance.ai.api.model.view.WidgetEvent;
import com.bytedance.mt.protector.impl.UriProtector;
import k2.u;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class MoaLoginPanelPresenter {
    public static final /* synthetic */ int b = 0;
    public com.bytedance.ai.applet.login.f a;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MoaLoginPanelType.values().length];
            r0[MoaLoginPanelType.PRIVACY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MoaLoginPanelType.LOGIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements u {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // k2.u
        public final void a() {
        }

        @Override // k2.u
        public final void b() {
        }

        @Override // k2.u
        public final void c() {
        }

        @Override // k2.u
        public final void onDestroy() {
        }

        @Override // k2.u
        public void onEvent(WidgetEvent r10) {
            Intrinsics.checkNotNullParameter(r10, "event");
        }

        @Override // k2.u
        public final void onStart() {
        }
    }

    static {
    }

    public MoaLoginPanelPresenter() {
    }

    public final void b() {
        com.bytedance.ai.applet.login.f r0 = this.a;
        if (r0 == null) goto L5;
        r0.e();
    L5:
        this.a = null;
    }

    public static String a(String r10) {
        if (r10 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L12;
        return "";
    L12:
        return UriProtector.parse("sslocal://webview").buildUpon().appendQueryParameter(com.bytedance.android.ec.core.event.a.KEY_URL, r10).build().toString();
    L4:
        if (StringsKt.isBlank(r10) == true) goto L7;
        r0 = false;
        goto L8
    }

    public final Object c(o r14, u2.j r15, MoaLoginPanelType r16, Function0<Unit> r17, Continuation<? super Result<Unit>> r18) {
        if ((r18 instanceof MoaLoginPanelPresenter$show$1) == false) goto L7;
        MoaLoginPanelPresenter$show$1 r1 = (MoaLoginPanelPresenter$show$1) r18;
        int r10 = r1.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r10 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = r1.label;
        if (r12 == 0) goto L14;
        if (r12 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
    L18:
        return ((Result) r0).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        MainCoroutineDispatcher r13 = Dispatchers.getMain().getImmediate();
        MoaLoginPanelPresenter$show$2 r19 = new MoaLoginPanelPresenter$show$2(this, r14, r15, r16, r17, null);
        r1.label = 1;
        r0 = BuildersKt.withContext(r13, r19, r1);
        if (r0 != r11) goto L18;
        return r11;
    L7:
        r1 = new MoaLoginPanelPresenter$show$1(this, r18);
        goto L8
    }
}
