package com.bytedance.android.live.liveinteract.enlarge.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.enlarge.dialog.diff.MultiEnlargeGuestSelectedItemDecoration;
import com.bytedance.android.live.liveinteract.enlarge.dialog.viewbinder.MultiEnlargeGuestSelectViewBinder;
import com.bytedance.android.live.liveinteract.plantform.datamerge.LinkUserDataMergeContext;
import com.bytedance.android.live.liveinteract.videotalk.cposition.CPositionContext;
import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/enlarge/dialog/MultiLinkEnlargeSelectGuestDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "a", "b", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkEnlargeSelectGuestDialog extends CommonStandardBottomDialog {
    public static final /* synthetic */ int F = 0;
    public b B;
    public MultiTypeAdapter C;
    public List<MultiEnlargeGuestSelectViewBinder.b> D;
    public DataCenter E;

    public static final class a {
    }

    public interface b {
        void a(List<String> r1, List<String> r2);
    }

    static {
    }

    public final int getLayoutId() {
        return 2131565655;
    }

    public static int W0() {
        CPositionContext r0 = CPositionContext.Companion.getContext();
        if (r0 == null) goto L9;
        m<EnlargeGuestInfo> r1 = r0.getEnlargeGuestInfo();
        if (r1 == null) goto L9;
        EnlargeGuestInfo r2 = (EnlargeGuestInfo) r1.getValue();
        if (r2 == null) goto L9;
        int r3 = (int) r2.getSourceUILayoutMaxMembers();
    L10:
        if (r3 > 0) goto L12;
        return r3;
    L12:
        return r3 - 1;
    L9:
        r3 = 0;
        goto L10
    }

    public MultiLinkEnlargeSelectGuestDialog(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, false);
        this.D = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r10) {
        super.onCreate(r10);
        ((TextView) findViewById(2131387558)).setText(s1.C(2131916174, new Object[]{String.valueOf(W0())}));
        ((TextView) findViewById(2131387762)).setOnClickListener(x0.a(new MultiLinkEnlargeSelectGuestDialog$initView$1(this)));
        int r11 = W0();
        MultiTypeAdapter r0 = new MultiTypeAdapter(this.D);
        this.C = r0;
        r0.z2(MultiEnlargeGuestSelectViewBinder.b.class, new MultiEnlargeGuestSelectViewBinder(new e(this, r11)));
        SSGridLayoutManager r12 = new SSGridLayoutManager(getContext(), 4, 1);
        RecyclerView r2 = findViewById(2131374077);
        MultiTypeAdapter r4 = this.C;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("selectedAdapter");
    L5:
        r2.setAdapter(r4);
        findViewById(2131374077).setLayoutManager(r12);
        findViewById(2131374077).addItemDecoration(new MultiEnlargeGuestSelectedItemDecoration());
        int r13 = W0();
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r1 = LinkUserDataMergeContext.a.b(LinkUserDataMergeContext.Companion, this.E);
        if (r1 == null) goto L52;
        BehaviorSubject<List<ch0.e>> r3 = r1.f();
        ArrayList r5 = null;
        if (r3 == null) goto L34;
        List r6 = (List) r3.getValue();
        if (r6 == null) goto L34;
        ArrayList r7 = new ArrayList();
        Iterator r8 = r6.iterator();
    L13:
        if (r8.hasNext() == false) goto L21;
        Object r9 = r8.next();
        IBaseUser r14 = ((ch0.e) r9).a.getUser();
        if (r14 == null) goto L17;
        String r15 = r14.getIdString();
    L19:
        if (Intrinsics.areEqual(r15, je0.d.a()) == true) goto L13;
        r7.add(r9);
        goto L13
    L17:
        r15 = null;
        goto L19
    L21:
        List r16 = CollectionsKt.sortedWith(r7, new d());
        if (r16 == null) goto L34;
        List r17 = r16;
        r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r18 = r17.iterator();
        int r19 = 0;
    L25:
        if (r18.hasNext() == false) goto L34;
        Object r20 = r18.next();
        int r21 = r19 + 1;
        if (r19 >= 0) goto L29;
        CollectionsKt.throwIndexOverflow();
    L29:
        ch0.e r22 = (ch0.e) r20;
        if (r19 >= r13) goto L32;
        MultiEnlargeGuestSelectViewBinder.b r23 = new MultiEnlargeGuestSelectViewBinder.b(true, r22.a);
    L33:
        r5.add(r23);
        r19 = r21;
        goto L25
    L32:
        r23 = new MultiEnlargeGuestSelectViewBinder.b(false, r22.a);
    L34:
        if (r5 == null) goto L36;
        this.D = r5;
    L36:
        MultiTypeAdapter r110 = this.C;
        if (r110 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("selectedAdapter");
    L39:
        r110.a = this.D;
        MultiTypeAdapter r111 = this.C;
        if (r111 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("selectedAdapter");
    L42:
        r111.notifyDataSetChanged();
        return;
    }
}
