package es8;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public static boolean a;
    public static final MutableLiveData<Boolean> b = null;

    static {
        a = true;
        b = new MutableLiveData();
    }

    public static Fragment b() {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L5;
        r0.P();
        Fragment r1 = ChatServiceImpl.a.f();
    L6:
        if (r1 != null) goto L8;
    L24:
        boolean r2 = false;
    L25:
        if (r2 == true) goto L27;
        return null;
    L27:
        return r1;
    L8:
        if (r1.isDetached() == true) goto L24;
        if (r1.isAdded() == false) goto L24;
        if (r1.getActivity() == null) goto L24;
        LifecycleOwner r3 = (LifecycleOwner) r1.getViewLifecycleOwnerLiveData().getValue();
        if (r3 == null) goto L19;
        Lifecycle r4 = r3.getLifecycle();
        if (r4 == null) goto L19;
        Lifecycle.State r5 = r4.getCurrentState();
    L20:
        if (r5 != null) goto L22;
    L23:
        r2 = true;
        goto L25
    L22:
        if (r5 == Lifecycle.State.DESTROYED) goto L24;
    L19:
        r5 = null;
        goto L20
    L5:
        r1 = null;
        goto L6
    }

    public static boolean c() {
        y r0 = a(y.class);
        Boolean r1 = null;
        if (r0 == null) goto L5;
        e r2 = r0.h();
    L6:
        if (r2 == null) goto L9;
        r1 = Boolean.valueOf(r2.i);
    L9:
        if (a == false) goto L11;
    L14:
        if (r1 == null) goto L17;
        return r1.booleanValue();
    L17:
        return a;
    L11:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L14;
        FLogger.a.i("TtsInterceptorUtils", "[TTS] getTtsEnable override: cachedTtsEnable=false, convTtsEnable=true, return false");
        return false;
    L5:
        r2 = null;
        goto L6
    }

    public static t1a.a a(Class r4) {
        Intrinsics.checkNotNullParameter(r4, "clazz");
        Fragment r0 = b();
        if (r0 != null) goto L10;
        return null;
    L10:
        return s1a.a.g(r0).getAbility(r4);
    L7:
        e = move-exception;
        FLogger.a.e("TtsInterceptorUtils", "[TTS] get chat ability failed, ability=".concat(r4.getSimpleName()), e);
        return null;
    }
}
