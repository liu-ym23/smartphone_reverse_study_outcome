package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.content.Context;
import android.os.Handler;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.pk.ui.PkItemExposeRecyclerView;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.f2;
import com.bytedance.android.livesdk.link.model.g2;
import com.bytedance.android.livesdk.link.model.k0;
import com.bytedance.android.livesdk.link.model.m0;
import com.bytedance.android.livesdk.link.model.x0;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import me.drakeet.multitype.MultiTypeAdapter;
import org.json.JSONObject;
import y31.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\b\u0010\fB#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\b\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/InteractPkRecordView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Ly31/b;", "getView", "()Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/InteractPkRecordView;", "view", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractPkRecordView extends ConstraintLayout implements y31.b {
    public static final /* synthetic */ int o = 0;
    public MultiTypeAdapter a;
    public MultiTypeAdapter b;
    public View c;
    public LinkedList<Object> d;
    public final com.bytedance.android.live.revlink.impl.pk.utils.m e;
    public boolean f;
    public boolean g;
    public int h;
    public String i;
    public m0 j;
    public boolean k;
    public Function1<? super Boolean, Unit> l;
    public x31.p m;
    public x31.o n;

    private final InteractPkRecordView getView() {
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InteractPkRecordView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.e = new com.bytedance.android.live.revlink.impl.pk.utils.m();
        this.f = true;
        new Handler();
        this.i = "";
        LayoutInflater.from(getContext()).inflate(2131566060, this, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(boolean r9) {
        KmpEnv r0 = KmpEnv.a;
        if (KmpEnv.a() == false) goto L5;
        int r1 = 2131382879;
    L6:
        View r2 = findViewById(r1);
        this.c = r2;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mPreloadProgressIcon");
    L9:
        r2.setVisibility(0);
        this.d = new LinkedList();
        MultiTypeAdapter r3 = new MultiTypeAdapter();
        this.a = r3;
        r3.z2(v.a.class, new v());
        MultiTypeAdapter r4 = this.a;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L12:
        com.bytedance.android.live.revlink.impl.pk.utils.m r5 = this.e;
        x31.o r6 = this.n;
        if (r6 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("inviteListener");
    L15:
        r4.z2(y31.d.a.class, new y31.d(r5, r6, this.m));
        PkItemExposeRecyclerView r7 = (PkItemExposeRecyclerView) findViewById(2131384076);
        if (r7 == null) goto L21;
        MultiTypeAdapter r8 = this.a;
        if (r8 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L20:
        r7.setAdapter(r8);
        r7.setLayoutManager(new SSLinearLayoutManager(getContext(), 1));
        r7.setItemAnimator(null);
        r7.addOnScrollListener(new InteractPkRecordView$onIntoDefaultAction$$inlined$let$lambda$1(this));
    L21:
        MultiTypeAdapter r10 = new MultiTypeAdapter();
        this.b = r10;
        r10.z2(y31.a.C0348a.class, new y31.a());
        ArrayList r12 = new ArrayList();
        y31.a.C0348a r13 = new y31.a.C0348a();
        r13.a = s1.B(2131921446);
        r13.b = 0;
        r13.c = this;
        Unit r14 = Unit.INSTANCE;
        r12.add(r13);
        b51.b r15 = b51.b.c0;
        r15.getClass();
        if (((Boolean) b51.b.s.getValue(r15, b51.b.a[17])).booleanValue() == false) goto L28;
        y31.a.C0348a r16 = new y31.a.C0348a();
        if (r2.a(r15.a()) == false) goto L26;
        String r17 = r15.a();
    L27:
        r16.a = r17;
        r16.b = 5;
        r16.c = this;
        r12.add(r16);
        goto L28
    L26:
        r17 = s1.B(2131921445);
    L28:
        y31.a.C0348a r18 = new y31.a.C0348a();
        r18.a = s1.B(2131917928);
        r18.b = 1;
        r18.c = this;
        r12.add(r18);
        y31.a.C0348a r19 = new y31.a.C0348a();
        r19.a = s1.B(2131917929);
        r19.b = 3;
        r19.c = this;
        r12.add(r19);
        y31.a.C0348a r20 = new y31.a.C0348a();
        r20.a = s1.B(2131914806);
        r20.b = 4;
        r20.c = this;
        r12.add(r20);
        y31.a.C0348a r22 = new y31.a.C0348a();
        r22.a = s1.B(2131917927);
        r22.b = 2;
        r22.c = this;
        r12.add(r22);
        MultiTypeAdapter r23 = this.b;
        if (r23 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mTabAdapter");
    L31:
        r23.a = r12;
        ConstraintLayout r24 = getView();
        if (r24 == null) goto L36;
        PkItemExposeRecyclerView r25 = (PkItemExposeRecyclerView) r24.findViewById(2131384080);
        if (r25 == null) goto L36;
        r25.setLayoutManager(new SSLinearLayoutManager(getContext(), 0));
    L36:
        ConstraintLayout r26 = getView();
        if (r26 == null) goto L44;
        PkItemExposeRecyclerView r27 = (PkItemExposeRecyclerView) r26.findViewById(2131384080);
        if (r27 == null) goto L44;
        MultiTypeAdapter r28 = this.b;
        if (r28 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("mTabAdapter");
    L43:
        r27.setAdapter(r28);
    L44:
        ConstraintLayout r29 = getView();
        if (r29 == null) goto L49;
        RecyclerView r30 = (PkItemExposeRecyclerView) r29.findViewById(2131384080);
        if (r30 == null) goto L49;
        r30.setVisibility(0);
    L49:
        MultiTypeAdapter r32 = this.b;
        if (r32 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("mTabAdapter");
    L52:
        r32.notifyDataSetChanged();
        if (r9 == false) goto L62;
        this.e.c();
        if (this.f == false) goto L60;
        x31.p r33 = this.m;
        if (r33 == null) goto L59;
        r33.k(0, true);
    L59:
        this.f = false;
    L60:
        setVisibility(0);
        return;
    L62:
        return;
    L5:
        r1 = 2131382880;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InteractPkRecordView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.e = new com.bytedance.android.live.revlink.impl.pk.utils.m();
        this.f = true;
        new Handler();
        this.i = "";
        LayoutInflater.from(getContext()).inflate(2131566060, this, true);
    }

    @Override // y31.b
    public final void K(int r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "title");
        x31.p r0 = this.m;
        if (r0 != null) goto L5;
    L7:
        x31.p r1 = this.m;
        if (r1 == null) goto L10;
        r1.n(r6);
    L10:
        MultiTypeAdapter r2 = this.a;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L13:
        if (r2 == null) goto L17;
        List r3 = r2.a;
        if (r3 == null) goto L17;
        r3.clear();
    L17:
        MultiTypeAdapter r4 = this.a;
        if (r4 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L20:
        if (r4 == null) goto L22;
        r4.notifyDataSetChanged();
    L22:
        View r5 = this.c;
        if (r5 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mPreloadProgressIcon");
    L25:
        int r8 = 0;
        r5.setVisibility(0);
        MultiTypeAdapter r9 = this.a;
        if (r9 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L28:
        r9.a.clear();
        ConstraintLayout r10 = getView();
        if (r10 == null) goto L33;
        ViewGroup r12 = (ViewGroup) r10.findViewById(2131384080);
        if (r12 == null) goto L33;
        int r13 = r12.getChildCount();
    L34:
        if (r13 < 0) goto L45;
    L35:
        ConstraintLayout r14 = getView();
        if (r14 == null) goto L43;
        ViewGroup r15 = (ViewGroup) r14.findViewById(2131384080);
        if (r15 == null) goto L43;
        View r16 = r15.getChildAt(r8);
        if (r16 == null) goto L43;
        r16.setBackground(null);
        ((TextView) r16).setTextColor(ColorProtector.parseColor("#80161823"));
    L43:
        if (r8 == r13) goto L45;
        r8 = r8 + 1;
    L45:
        HashMap r17 = new HashMap();
        r17.put("options_click", String.valueOf(r6 + 1));
        r17.put("tab_name", r7);
        mz0.n r18 = new mz0.n();
        Map<String, String> r19 = r18.a;
        Intrinsics.checkNotNullParameter(r19, "map");
        Intrinsics.checkNotNullParameter(r17, "map");
        r19.putAll(r17);
        mz0.m r20 = new mz0.m();
        r20.b(LogCommon.ROOM);
        List<Object> r22 = r18.b;
        ArrayList r23 = (ArrayList) r22;
        r23.addAll(r20.a);
        cy0.e.a.getClass();
        cy0.j r24 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r25 = com.bytedance.android.scope.m.b(r24).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r25);
        ((mz0.i) ((f80.a) r25)).w3("livesdk_all_pk_records_choice_panel_click", r18.a, r18.b);
        return;
    L33:
        r13 = 0;
        goto L34
    L5:
        if (r0.g() != r6) goto L7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(g2 r17, int r18) {
        boolean r5 = true;
        if (r17 == null) goto L14;
        List r7 = r17.getBattleRecordList();
        if (r7 != null) goto L7;
    L10:
        boolean r8 = true;
    L11:
        if (r8 == true) goto L14;
        findViewById(2131384076).setVisibility(0);
        findViewById(2131390556).setVisibility(8);
    L38:
        if (r17 == null) goto L208;
        MultiTypeAdapter r2 = this.a;
        if (r2 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L42:
        LinkedList<Object> r9 = this.d;
        if (r9 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L46:
        if (r9.isEmpty() == true) goto L59;
        LinkedList<Object> r10 = this.d;
        if (r10 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L50:
        LinkedList<Object> r12 = this.d;
        if (r12 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L54:
        if ((ListProtector.get(r10, r12.size() - 1) instanceof v.a) == false) goto L59;
        LinkedList<Object> r13 = this.d;
        if (r13 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L58:
        r13.removeLast();
    L59:
        List r14 = r17.getBattleRecordList();
        if (r14 != null) goto L62;
        r14 = CollectionsKt.emptyList();
    L62:
        Iterator r15 = r14.iterator();
    L64:
        if (r15.hasNext() == false) goto L136;
        f2 r16 = (f2) r15.next();
        y31.d.a r19 = new y31.d.a();
        r19.a = 8;
        r19.b = r16;
        r19.c = this.h;
        if (this.k == true) goto L85;
        x0 r110 = r17.getBattleConsecutiveRecordInfo();
        if (r110 == null) goto L70;
        long r111 = r110.getConsecutiveCount();
    L72:
        if (r111 < 2) goto L85;
        x0 r112 = r17.getBattleConsecutiveRecordInfo();
        if (r112 == null) goto L85;
        if (r112.getBattleResultType() != 1) goto L85;
        if (r16 == null) goto L85;
        if (r16.getBattleResultType() != 1) goto L85;
        x0 r113 = r17.getBattleConsecutiveRecordInfo();
        if (r113 == null) goto L83;
        Integer r114 = Integer.valueOf((int) r113.getConsecutiveCount());
    L84:
        r19.d = r114;
        this.k = true;
    L86:
        String r115 = this.i;
        Intrinsics.checkNotNullParameter(r115, "<set-?>");
        r19.e = r115;
        r19.l = r18;
        r19.g = "";
        x31.p r116 = this.m;
        if (r116 == null) goto L89;
        int r117 = r116.i();
    L90:
        r19.i = r117;
        r19.h = r16.getFeedbackInfo();
        JSONObject r118 = new JSONObject();
        r118.put("channel_id", r16.getChannelId());
        IBattleUserInfo r119 = r16.getBattleUserInfo();
        if (r119 == null) goto L95;
        k0 r120 = r119.getUserInfo();
        if (r120 == null) goto L95;
        String r121 = r120.getNickName();
    L96:
        r118.put("user_name", r121);
        IBattleUserInfo r122 = r16.getBattleUserInfo();
        if (r122 == null) goto L105;
        k0 r123 = r122.getUserInfo();
        if (r123 == null) goto L105;
        py.k r124 = r123.getAvatarThumb();
        if (r124 == null) goto L105;
        List r125 = r124.getUrls();
        if (r125 == null) goto L105;
        String r126 = (String) ListProtector.get(r125, 0);
    L106:
        r118.put("user_avatar", r126);
        r118.put("follow_status", r16.getFollowType());
        IBattleUserInfo r127 = r16.getBattleUserInfo();
        if (r127 == null) goto L111;
        k0 r128 = r127.getUserInfo();
        if (r128 == null) goto L111;
        String r129 = r128.getUserId();
    L112:
        r118.put("user_id", r129);
        r118.put("sec_user_id", r16.getRivalSecUserId());
        yz0.k r130 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r130 == null) goto L117;
        IRoom r131 = r130.getRoom();
        if (r131 == null) goto L117;
        Long r132 = Long.valueOf(r131.getRoomId());
    L118:
        r118.put("room_id", r132);
        r118.put("battle_id", r16.getBattleId());
        if (r16.getInviteRejectPermanent() == false) goto L122;
        int r133 = 2;
    L125:
        r118.put("ban_type", r133);
        if (r16.getBattleResultType() != 1) goto L129;
        String r20 = "win";
    L132:
        r118.put("pk_result", r20);
        r19.j = r118;
        r19.k = this.l;
        LinkedList<Object> r22 = this.d;
        if (r22 != null) goto L135;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L135:
        r22.add(r19);
        goto L64
    L129:
        if (r16.getBattleResultType() != 2) goto L131;
        r20 = "loss";
        goto L132
    L131:
        r20 = "draw";
        goto L132
    L122:
        if (Intrinsics.areEqual(r16.getInviteRejectTemporary(), Boolean.TRUE) == false) goto L124;
        r133 = 1;
        goto L125
    L124:
        r133 = -1;
    L117:
        r132 = null;
    L111:
        r129 = null;
    L105:
        r126 = null;
    L95:
        r121 = null;
        goto L96
    L89:
        r117 = 0;
        goto L90
    L83:
        r114 = null;
        goto L84
    L70:
        r111 = 0;
    L85:
        r19.d = 0;
        goto L86
    L136:
        LinkedList<Object> r1 = this.d;
        if (r1 != null) goto L139;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L139:
        ArrayList r4 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L141:
        if (r3.hasNext() == false) goto L145;
        Object r6 = r3.next();
        if ((r6 instanceof y31.d.a) == false) goto L141;
        r4.add(r6);
        goto L141
    L145:
        Iterator r23 = r4.iterator();
        int r24 = 0;
    L147:
        if (r23.hasNext() == false) goto L152;
        Object r25 = r23.next();
        int r26 = r24 + 1;
        if (r24 >= 0) goto L151;
        CollectionsKt.throwIndexOverflow();
    L151:
        ((y31.d.a) r25).f = r24;
        r24 = r26;
        goto L147
    L152:
        v.a r27 = new v.a();
        String r28 = r17.getNoRecordTip();
        if (r28 != null) goto L155;
    L158:
        boolean r29 = true;
    L160:
        if (r29 == false) goto L169;
        LinkedList<Object> r30 = this.d;
        if (r30 != null) goto L165;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L165:
        if (r30.size() > 6) goto L169;
        x31.p r32 = this.m;
        if (r32 == null) goto L189;
        r32.e();
    L189:
        LinkedList<Object> r33 = this.d;
        if (r33 != null) goto L192;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L192:
        r2.a = r33;
        MultiTypeAdapter r34 = this.a;
        if (r34 != null) goto L195;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L195:
        r34.notifyDataSetChanged();
        return;
    L169:
        String r35 = r17.getNoRecordTip();
        if (r35 != null) goto L172;
    L175:
        if (r5 == false) goto L185;
        LinkedList<Object> r36 = this.d;
        if (r36 != null) goto L180;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L180:
        if (r36.size() <= 6) goto L185;
        r27.a = s1.B(2131917932);
        LinkedList<Object> r37 = this.d;
        if (r37 != null) goto L184;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L184:
        r37.add(r27);
    L185:
        r27.a = r17.getNoRecordTip();
        LinkedList<Object> r38 = this.d;
        if (r38 != null) goto L188;
        Intrinsics.throwUninitializedPropertyAccessException("recordList");
    L188:
        r38.add(r27);
        goto L189
    L172:
        if (r35.length() == 0) goto L175;
        r5 = false;
        goto L175
    L155:
        if (r28.length() == 0) goto L158;
        r29 = false;
        goto L160
    L208:
        return;
    L7:
        if (r7.isEmpty() == true) goto L10;
        r8 = false;
    L14:
        x31.p r39 = this.m;
        if (r39 != null) goto L17;
    L19:
        View r40 = findViewById(2131384076);
        if (r40 == null) goto L22;
        r40.setVisibility(8);
    L22:
        findViewById(2131390556).setVisibility(0);
        ((TextView) findViewById(2131371603)).setText(s1.B(2131917865));
        if (this.i.length() <= 0) goto L25;
        boolean r42 = true;
    L26:
        if (r42 == false) goto L38;
        m0 r43 = this.j;
        if (r43 == null) goto L38;
        if (r43 == null) goto L31;
        a5 r44 = r43.getDisplayTabText();
    L32:
        if (r44 == null) goto L38;
        m0 r45 = this.j;
        if (r45 == null) goto L38;
        a5 r46 = r45.getDisplayTabText();
        if (r46 == null) goto L38;
        Spannable r47 = vh6.c.b(ur2.a.class).Lf(r46, "");
        ((TextView) findViewById(2131371603)).setText(s1.C(2131917866, new Object[]{r47.toString()}));
        goto L38
    L31:
        r44 = null;
        goto L32
    L25:
        r42 = false;
        goto L26
    L17:
        if (r39.h() != true) goto L19;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InteractPkRecordView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.e = new com.bytedance.android.live.revlink.impl.pk.utils.m();
        this.f = true;
        new Handler();
        this.i = "";
        LayoutInflater.from(getContext()).inflate(2131566060, this, true);
    }
}
