package cfa;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.obric.assistant.activity_stack.IObricActivityStackService;
import com.obric.assistant.chat.p;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public static final ICoreInputAbility a() {
        IObricActivityStackService r0 = (IObricActivityStackService) ServiceManager.get().getService(IObricActivityStackService.class);
        if (r0 == null) goto L5;
        Activity r1 = r0.c();
    L7:
        if ((r1 instanceof FragmentActivity) == false) goto L9;
        FragmentActivity r2 = (FragmentActivity) r1;
    L10:
        if (r2 != null) goto L12;
        return null;
    L12:
        if (p.e(r2) == false) goto L14;
        t1a.b r3 = p.a(r2);
    L31:
        if (r3 != null) goto L33;
        return null;
    L33:
        return r3.getAbility(ICoreInputAbility.class);
    L14:
        t1a.b r4 = p.a(r2);
        if (r4 == null) goto L17;
    L16:
        r3 = r4;
        goto L31
    L17:
        Iterator r5 = r2.getSupportFragmentManager().getFragments().iterator();
    L19:
        if (r5.hasNext() == false) goto L30;
        Fragment r6 = (Fragment) r5.next();
        Intrinsics.checkNotNull(r6);
        if (r6.isAdded() == true) goto L23;
    L27:
        r4 = null;
    L28:
        if (r4 == null) goto L19;
    L23:
        if (r6.isVisible() == false) goto L27;
        r4 = s1a.a.g(r6);
        if (r4.getAbility(ICoreInputAbility.class) != null) goto L28;
    L30:
        r3 = null;
        goto L31
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L7
    }
}
