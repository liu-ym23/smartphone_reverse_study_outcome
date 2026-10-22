package be0;

import com.bytedance.android.livesdk.model.k;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements a {
    public final NextLiveData<IVoiceLiveTheme> a;
    public final NextLiveData<IVoiceLiveTheme> b;
    public final NextLiveData<ArrayList<IVoiceLiveTheme>> c;
    public final NextLiveData<Integer> d;

    @Override // be0.a
    public final IVoiceLiveTheme d() {
        ArrayList r0 = (ArrayList) this.c.getValue();
        if (r0 == null) goto L14;
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        Object r2 = r1.next();
        String r3 = ((IVoiceLiveTheme) r2).getImageUri();
        oj0.a r4 = oj0.a.c;
        r4.getClass();
        if (Intrinsics.areEqual(r3, ((oj0.b) oj0.a.b.getValue(r4, oj0.a.a[0])).a) == false) goto L6;
    L11:
        IVoiceLiveTheme r5 = (IVoiceLiveTheme) r2;
        if (r5 == null) goto L14;
        return r5;
    L10:
        r2 = null;
    L14:
        return k.a();
    }

    public e() {
        this.a = new NextLiveData();
        this.b = new NextLiveData();
        NextLiveData<ArrayList<IVoiceLiveTheme>> r0 = new NextLiveData();
        this.c = r0;
        this.d = new NextLiveData();
        r0.setValue(new ArrayList());
    }

    @Override // be0.a
    public final NextLiveData<IVoiceLiveTheme> a() {
        return this.b;
    }

    @Override // be0.a
    public final NextLiveData<ArrayList<IVoiceLiveTheme>> b() {
        return this.c;
    }

    @Override // be0.a
    public final NextLiveData<Integer> c() {
        return this.d;
    }

    @Override // be0.a
    public final NextLiveData<IVoiceLiveTheme> getCurrentTheme() {
        return this.a;
    }
}
