package ls0;

import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.portrait.PortraitShareAdapter;
import com.bytedance.android.live.portrait.PortraitShareFragment;
import com.bytedance.android.livesdk.vs.model.MatchShareParam;
import com.bytedance.android.livesdkapi.depend.model.match.CollectionItem;
import com.bytedance.android.livesdkapi.depend.model.match.CollectionResponseData;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ PortraitShareFragment a;

    public c(PortraitShareFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r8) {
        Response r9 = (Response) r8;
        ArrayList r0 = new ArrayList();
        if (r9 == null) goto L24;
        CollectionResponseData r10 = (CollectionResponseData) r9.data;
        if (r10 == null) goto L24;
        List r11 = r10.getCollectionItems();
        if (r11 == null) goto L24;
        Iterator<T> r12 = r11.iterator();
    L10:
        if (r12.hasNext() == false) goto L24;
        CollectionItem r1 = (CollectionItem) r12.next();
        MatchShareParam r2 = this.a.d;
        Object r3 = null;
        if (r2 == null) goto L22;
        List r4 = r2.d;
        if (r4 == null) goto L22;
        Iterator<T> r5 = r4.iterator();
    L17:
        if (r5.hasNext() == false) goto L21;
        T r6 = r5.next();
        if (Intrinsics.areEqual(((CollectionItem) r6).getCollectionId(), r1.getCollectionId()) == false) goto L17;
        r3 = r6;
    L21:
        r3 = (CollectionItem) r3;
    L22:
        if (r3 != null) goto L10;
        r0.add(r1);
    L24:
        MatchShareParam r13 = this.a.d;
        if (r13 == null) goto L29;
        List r14 = r13.d;
        if (r14 == null) goto L29;
        r14.addAll(r0);
    L29:
        PortraitShareAdapter r15 = this.a.h;
        if (r15 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("collectVideoAdapter");
    L32:
        r15.getClass();
        MainThreadPostUtils.e(new b(r15));
    }
}
