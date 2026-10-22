package k89;

import com.larus.drive.sdk.api.file.select.ChatRecentFileSource;
import com.larus.drive.sdk.impl.view.chat.fileselect.data.ChatRecentFileLoadProcessor;
import com.larus.im.bean.message.MessageQueryResponse;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g implements IIMCallback<MessageQueryResponse> {
    public final /* synthetic */ ChatRecentFileLoadProcessor a;
    public final /* synthetic */ Continuation<x79.c> b;

    public final boolean mustInMain() {
        return !y0.a();
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("ChatRecentFileLoadProcessor", "loadMore failed, error: " + r4);
        this.b.resumeWith(Result.constructor-impl(new x79.c(null, false)));
    }

    public final void onSuccess(Object r9) {
        MessageQueryResponse r10 = (MessageQueryResponse) r9;
        Intrinsics.checkNotNullParameter(r10, "result");
        final ChatRecentFileLoadProcessor r0 = this.a;
        r0.i = r10.pageToken;
        r0.j = r10.domainPageToken;
        r0.k = r10.hasMore;
        List r1 = r10.historyMessages;
        ArrayList r2 = new ArrayList();
        if (r1 == null) goto L14;
        Sequence r3 = CollectionsKt.asSequence(r1);
        if (r3 == null) goto L14;
        Sequence r4 = SequencesKt.sortedWith(r3, new f());
        if (r4 == null) goto L14;
        Sequence r5 = SequencesKt.flatMap(r4, new c(r0));
        if (r5 == null) goto L14;
        Iterator r6 = r5.iterator();
    L12:
        if (r6.hasNext() == false) goto L14;
        r2.add((x79.b) r6.next());
    L14:
        boolean r7 = false;
        if (r2.isEmpty() == false) goto L17;
        int r8 = 0;
    L29:
        if (r2.isEmpty() == false) goto L31;
        int r11 = 0;
    L42:
        FLogger r12 = FLogger.a;
        StringBuilder r13 = new StringBuilder("loadMore success, useDomainPagination: ");
        r13.append(this.a.f);
        r13.append(", hasMore: ");
        r13.append(this.a.k);
        r13.append(", hasPageToken: ");
        String r14 = this.a.i;
        if (r14 != null) goto L45;
    L48:
        boolean r15 = true;
    L49:
        r13.append(!r15);
        r13.append(", hasDomainPageToken: ");
        String r16 = this.a.j;
        if (r16 != null) goto L52;
    L53:
        r7 = true;
    L54:
        r13.append(true ^ r7);
        r13.append(", fileCount: ");
        r13.append(r2.size());
        r13.append(", larkFileCount: ");
        r13.append(r8);
        r13.append(", doubaoFileCount: ");
        r13.append(r11);
        r12.i("ChatRecentFileLoadProcessor", r13.toString());
        Continuation<x79.c> r17 = this.b;
        Result.Companion r18 = Result.Companion;
        r17.resumeWith(Result.constructor-impl(new x79.c(r2, r10.hasMore)));
        return;
    L52:
        if (r16.length() != 0) goto L54;
    L45:
        if (r14.length() == 0) goto L48;
        r15 = false;
        goto L49
    L31:
        Iterator r20 = r2.iterator();
        r11 = 0;
    L33:
        if (r20.hasNext() == false) goto L42;
        if (((x79.b) r20.next()).i != ChatRecentFileSource.DOUBAO) goto L37;
        boolean r21 = true;
    L38:
        if (r21 == false) goto L33;
        r11 = r11 + 1;
        if (r11 >= 0) goto L33;
        CollectionsKt.throwCountOverflow();
        goto L33
    L37:
        r21 = false;
        goto L38
    L17:
        Iterator r22 = r2.iterator();
        r8 = 0;
    L19:
        if (r22.hasNext() == false) goto L29;
        if (((x79.b) r22.next()).i != ChatRecentFileSource.LARK) goto L23;
        boolean r23 = true;
    L24:
        if (r23 == false) goto L19;
        r8 = r8 + 1;
        if (r8 >= 0) goto L19;
        CollectionsKt.throwCountOverflow();
        goto L19
    L23:
        r23 = false;
        goto L24
    }

    public g(ChatRecentFileLoadProcessor r1, SafeContinuation r2) {
        this.a = r1;
        this.b = r2;
    }
}
