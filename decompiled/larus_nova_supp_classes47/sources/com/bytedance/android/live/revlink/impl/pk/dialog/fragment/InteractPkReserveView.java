package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.control.dialog.r;
import com.bytedance.android.livesdk.link.model.o8;
import com.bytedance.android.livesdk.link.model.p8;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import me.drakeet.multitype.MultiTypeAdapter;
import y31.t;
import y31.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB\u001b\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\t\u0010\rB#\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\t\u0010\u0010J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/InteractPkReserveView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Ly31/b;", "", "isVisibleToUser", "", "setUserVisibleHint", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractPkReserveView extends ConstraintLayout implements y31.b {
    public static final /* synthetic */ int j = 0;
    public MultiTypeAdapter a;
    public MultiTypeAdapter b;
    public n c;
    public View d;
    public LinkedList<Object> e;
    public Function1<? super Boolean, Unit> f;
    public r g;
    public final long h;
    public boolean i;

    /* JADX WARN: Multi-variable type inference failed */
    public InteractPkReserveView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        LayoutInflater.from(getContext()).inflate(2131566060, this, true);
        com.bytedance.android.livesdk.revenue.service.room.c r4 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r4 == null) goto L11;
        com.bytedance.android.livesdk.revenue.room.a r5 = r4.getRoomContext();
        if (r5 == null) goto L11;
        com.bytedance.live.datacontext.m r6 = r5.getRoom();
        if (r6 == null) goto L11;
        IRoom r7 = (IRoom) r6.getValue();
        if (r7 == null) goto L11;
        long r0 = r7.getRoomId();
    L12:
        this.h = r0;
        return;
    L11:
        r0 = 0;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(p8 r12) {
        boolean r3 = false;
        if (r12 == null) goto L95;
        List r4 = r12.getRecordList();
        if (r4 != null) goto L7;
    L10:
        boolean r5 = true;
    L12:
        if (r5 == false) goto L19;
        LinkedList<Object> r6 = this.e;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L17:
        if (r6.isEmpty() == true) goto L95;
    L19:
        findViewById(2131384076).setVisibility(0);
        findViewById(2131390556).setVisibility(8);
        this.i = r12.isEnd();
        MultiTypeAdapter r0 = this.a;
        if (r0 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L22:
        List r2 = r12.getRecordList();
        boolean r13 = r12.isEnd();
        if (r2.isEmpty() == false) goto L42;
        LinkedList<Object> r14 = this.e;
        if (r14 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L27:
        LinkedList<Object> r7 = this.e;
        if (r7 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L31:
        if ((ListProtector.get(r14, r7.size() - 1) instanceof v.a) == false) goto L36;
        LinkedList<Object> r15 = this.e;
        if (r15 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L35:
        r15.removeLast();
    L36:
        v.a r16 = new v.a();
        r16.a = "仅展示最近7日的PK邀约记录";
        LinkedList<Object> r8 = this.e;
        if (r8 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L39:
        r8.add(r16);
        LinkedList<Object> r17 = this.e;
        if (r17 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L90:
        r0.a = r17;
        MultiTypeAdapter r18 = this.a;
        if (r18 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L93:
        r18.notifyDataSetChanged();
        return;
    L42:
        LinkedList<Object> r9 = this.e;
        if (r9 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L45:
        if (r9 != null) goto L47;
    L48:
        r3 = true;
    L49:
        if (r3 == true) goto L62;
        LinkedList<Object> r10 = this.e;
        if (r10 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L53:
        LinkedList<Object> r19 = this.e;
        if (r19 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L57:
        if ((ListProtector.get(r10, r19.size() - 1) instanceof v.a) == false) goto L62;
        LinkedList<Object> r20 = this.e;
        if (r20 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L61:
        r20.removeLast();
    L62:
        Iterator r22 = r2.iterator();
    L64:
        if (r22.hasNext() == false) goto L78;
        o8 r23 = (o8) r22.next();
        t.a r24 = new t.a();
        r24.a = r23.getUser();
        r24.f = r23.getDescText();
        r24.b = r23.getRoom();
        r24.c = r23.getTags();
        r24.d = r23.getReplyBtn();
        r24.e = r23.getInviteBtn();
        n r25 = this.c;
        if (r25 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L68:
        r24.h = r25.c;
        r24.g = r23.getBattleAttachedInfo();
        r24.i = new InteractPkReserveView$updateAdapterItemList$1(this);
        r24.k = r23;
        n r26 = this.c;
        if (r26 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L72:
        if (r26.c != 1) goto L74;
        r24.j = new InteractPkReserveView$updateAdapterItemList$2(this);
    L74:
        LinkedList<Object> r27 = this.e;
        if (r27 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L77:
        r27.add(r24);
        goto L64
    L78:
        if (r13 == true) goto L83;
        v.a r110 = new v.a();
        r110.a = s1.B(2131917932);
        LinkedList<Object> r28 = this.e;
        if (r28 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L82:
        r28.add(r110);
    L87:
        r17 = this.e;
        if (r17 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
        goto L90
    L83:
        v.a r111 = new v.a();
        r111.a = "仅展示最近7日的PK邀约记录";
        LinkedList<Object> r29 = this.e;
        if (r29 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L86:
        r29.add(r111);
        goto L87
    L47:
        if (r9.isEmpty() == false) goto L49;
    L7:
        if (r4.isEmpty() == true) goto L10;
        r5 = false;
    L95:
        findViewById(2131384076).setVisibility(8);
        findViewById(2131390556).setVisibility(0);
        TextView r112 = (TextView) findViewById(2131371603);
        com.bytedance.live.kmp.util.c r1 = com.bytedance.live.kmp.util.c.a;
        int r30 = w11.a.a;
        r112.setText(com.bytedance.live.kmp.util.c.a(2131917816, new Object[0]));
    }

    public final void setUserVisibleHint(boolean r2) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InteractPkReserveView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        LayoutInflater.from(getContext()).inflate(2131566060, this, true);
        com.bytedance.android.livesdk.revenue.service.room.c r4 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r4 == null) goto L11;
        com.bytedance.android.livesdk.revenue.room.a r5 = r4.getRoomContext();
        if (r5 == null) goto L11;
        com.bytedance.live.datacontext.m r6 = r5.getRoom();
        if (r6 == null) goto L11;
        IRoom r7 = (IRoom) r6.getValue();
        if (r7 == null) goto L11;
        long r8 = r7.getRoomId();
    L12:
        this.h = r8;
        return;
    L11:
        r8 = 0;
        goto L12
    }

    public static void S5(int r2, boolean r3) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r2 != 0) goto L5;
        String r4 = "invite";
    L6:
        r0.put("tab", r4);
        if (r3 == false) goto L9;
        r0.put("source", "pk_invited_popup");
    L10:
        mz0.n r5 = new mz0.n();
        Map<String, String> r6 = r5.a;
        Intrinsics.checkNotNullParameter(r6, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r6.putAll(r0);
        mz0.m r7 = new mz0.m();
        r7.b(LogCommon.ROOM);
        List<Object> r1 = r5.b;
        ArrayList r8 = (ArrayList) r1;
        r8.addAll(r7.a);
        cy0.e.a.getClass();
        cy0.j r9 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r10 = com.bytedance.android.scope.m.b(r9).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r10);
        ((mz0.i) ((f80.a) r10)).w3("livesdk_pk_invite_record_page_show", r5.a, r5.b);
        return;
    L9:
        r0.put("source", "pk_record");
        goto L10
    L5:
        r4 = "invited";
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // y31.b
    public final void K(int r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "title");
        LinkedList<Object> r7 = this.e;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L5:
        r7.clear();
        MultiTypeAdapter r8 = this.a;
        if (r8 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L8:
        r8.a.clear();
        MultiTypeAdapter r9 = this.a;
        if (r9 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L11:
        r9.notifyDataSetChanged();
        n r10 = this.c;
        if (r10 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L14:
        Disposable r1 = r10.a;
        if (r1 == null) goto L17;
        r1.dispose();
    L17:
        r10.c = r5;
        r10.d = "";
        int r12 = 0;
        r10.b = false;
        View r13 = this.d;
        if (r13 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mPreloadProgressIcon");
    L20:
        r13.setVisibility(0);
        ViewGroup r2 = (ViewGroup) findViewById(2131384080);
        if (r2 == null) goto L23;
        int r3 = r2.getChildCount();
    L24:
        if (r3 < 0) goto L33;
    L25:
        ViewGroup r4 = (ViewGroup) findViewById(2131384080);
        if (r4 == null) goto L31;
        View r14 = r4.getChildAt(r12);
        if (r14 == null) goto L31;
        r14.setBackground(null);
        ((TextView) r14).setTextColor(ColorProtector.parseColor("#80161823"));
    L31:
        if (r12 == r3) goto L33;
        r12 = r12 + 1;
    L33:
        n r15 = this.c;
        if (r15 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L36:
        r15.a();
        return;
    L23:
        r3 = 0;
        goto L24
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InteractPkReserveView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(getContext()).inflate(2131566060, this, true);
        com.bytedance.android.livesdk.revenue.service.room.c r5 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r5 == null) goto L11;
        com.bytedance.android.livesdk.revenue.room.a r6 = r5.getRoomContext();
        if (r6 == null) goto L11;
        com.bytedance.live.datacontext.m r7 = r6.getRoom();
        if (r7 == null) goto L11;
        IRoom r8 = (IRoom) r7.getValue();
        if (r8 == null) goto L11;
        long r9 = r8.getRoomId();
    L12:
        this.h = r9;
        return;
    L11:
        r9 = 0;
        goto L12
    }
}
