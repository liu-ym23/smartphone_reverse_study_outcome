package com.bytedance.android.livesdk.feedback.view.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.base.model.feedback.RoomCardStruct;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.livesdk.feedback.FeedbackContext;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014B\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0015B\u001d\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0013\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R(\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/view/preview/SmallCardReplaceViewGroup;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/feedback/view/preview/h;", "listener", "", "setLikeClickListener", "Lcom/bytedance/android/livesdk/feedback/view/preview/d;", "value", "b", "Lcom/bytedance/android/livesdk/feedback/view/preview/d;", "setMFontSmallCardPreview", "(Lcom/bytedance/android/livesdk/feedback/view/preview/d;)V", "mFontSmallCardPreview", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SmallCardReplaceViewGroup extends FrameLayout {
    public final FrameLayout a;
    public d b;
    public d c;
    public d d;
    public List<RoomCardStruct> e;
    public boolean f;
    public List<RoomCardStruct> g;
    public h h;
    public FeedbackContext i;

    public final void c() {
        if (this.f == true) goto L6;
        j.b r0 = j.b.a;
        return;
    L6:
        final List<RoomCardStruct> r1 = this.e;
        if (r1 != null) goto L10;
        j.a r2 = j.a.a;
        return;
    L10:
        final d r3 = this.c;
        if (r3 != null) goto L14;
        j.a r4 = j.a.a;
        return;
    L14:
        final d r5 = this.b;
        if (r5 != null) goto L18;
        j.a r6 = j.a.a;
        return;
    L18:
        final d r7 = this.d;
        this.f = false;
        if ((!r1.isEmpty()) == false) goto L21;
        SmallCardReplaceViewGroup r8 = this;
    L22:
        if (r8 == null) goto L27;
        List<RoomCardStruct> r9 = this.g;
        if (r9 == null) goto L26;
        r1.removeAll(r9);
    L26:
        this.g = d(r1, 0, 4);
    L27:
        r5.a(new SmallCardReplaceViewGroup$replaceFontPreviewView$3(this, r5));
        r3.b(new SmallCardReplaceViewGroup$replaceFontPreviewView$4(this, r3, r1, r7));
        j.c r10 = j.c.a;
        return;
    L21:
        r8 = null;
        goto L22
    }

    public SmallCardReplaceViewGroup(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 0);
    }

    private final void setMFontSmallCardPreview(d r8) {
        this.b = r8;
        if (r8 == null) goto L65;
        List<RoomCardStruct> r9 = r8.getRoomInfo();
        if (r9 == null) goto L69;
        Iterator<T> r10 = r9.iterator();
    L8:
        if (r10.hasNext() == false) goto L70;
        RoomCardStruct r0 = (RoomCardStruct) r10.next();
        LinkedHashMap r1 = new LinkedHashMap();
        FeedbackContext r2 = this.i;
        String r3 = "";
        if (r2 == null) goto L13;
        String r4 = r2.getEnterFromMerge();
        if (r4 == null) goto L13;
    L14:
        r1.put("enter_from_merge", r4);
        FeedbackContext r5 = this.i;
        if (r5 == null) goto L18;
        String r6 = r5.getEnterMethod();
        if (r6 == null) goto L18;
    L19:
        r1.put("enter_method", r6);
        Room r7 = r0.room;
        LiveMode r11 = null;
        if (r7 == null) goto L22;
        Long r12 = Long.valueOf(r7.id);
    L23:
        r1.put("room_id", String.valueOf(r12));
        Room r13 = r0.room;
        if (r13 == null) goto L29;
        User r14 = r13.getOwner();
        if (r14 == null) goto L29;
        String r15 = r14.getIdString();
        if (r15 == null) goto L29;
    L30:
        r1.put("anchor_id", r15);
        FeedbackContext r16 = this.i;
        if (r16 == null) goto L34;
        String r17 = r16.getReqId();
        if (r17 == null) goto L34;
    L35:
        r1.put("request_id", r17);
        FeedbackContext r18 = this.i;
        if (r18 == null) goto L43;
        FeedbackCard r19 = r18.getMFeedbackCard();
        if (r19 == null) goto L43;
        Long r20 = r19.feedbackId;
        if (r20 == null) goto L43;
        String r21 = String.valueOf(r20.longValue());
        if (r21 == null) goto L43;
    L44:
        r1.put("feedback_id", r21);
        FeedbackContext r22 = this.i;
        if (r22 == null) goto L52;
        FeedbackCard r23 = r22.getMFeedbackCard();
        if (r23 == null) goto L52;
        Integer r24 = r23.getIndex();
        if (r24 == null) goto L52;
        String r25 = String.valueOf(r24.intValue());
        if (r25 == null) goto L52;
    L53:
        r1.put("draw_order", r25);
        r1.put("flow_type", "internal_flow");
        FeedbackContext r26 = this.i;
        if (r26 == null) goto L61;
        FeedbackCard r27 = r26.getMFeedbackCard();
        if (r27 == null) goto L61;
        String r28 = r27.getLogInfo();
        if (r28 == null) goto L61;
        r3 = r28;
    L61:
        r1.put("question_text", r3);
        r1.put("card_type", "small_card");
        r1.put("question_type", "multiple");
        Room r29 = r0.room;
        if (r29 == null) goto L64;
        r11 = r29.getStreamType();
    L64:
        int r30 = h1.a;
        r1.put("live_type", i1.a(r11));
        u.l().sendLog("livesdk_live_feedback_card_live_room_show", r1, new Object[0]);
    L52:
        r25 = "";
    L43:
        r21 = "";
    L34:
        r17 = "";
    L29:
        r15 = "";
        goto L30
    L22:
        r12 = null;
    L18:
        r6 = "";
    L13:
        r4 = "";
        goto L14
    L70:
        return;
    L69:
        return;
    }

    public final void setLikeClickListener(h r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.h = r2;
    }

    public SmallCardReplaceViewGroup(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public static final /* synthetic */ void a(SmallCardReplaceViewGroup r0, d r1) {
        r0.setMFontSmallCardPreview(r1);
    }

    public final void b(List<RoomCardStruct> r8, FeedbackContext r9) {
        Intrinsics.checkNotNullParameter(r9, "feedbackContext");
        if (r8 != null) goto L5;
        return;
    L5:
        this.e = r8;
        this.i = r9;
        this.a.removeAllViews();
        if ((!r8.isEmpty()) == false) goto L13;
        List<RoomCardStruct> r10 = d(r8, 0, 4);
        this.g = r10;
        k r4 = new k(getContext(), this.h);
        r4.c(r10);
        Unit r11 = Unit.INSTANCE;
        setMFontSmallCardPreview(r4);
        FrameLayout r12 = this.a;
        d r5 = this.b;
        if (r5 == null) goto L10;
        View r6 = r5.getView();
    L11:
        r12.addView(r6, new ViewGroup.LayoutParams(-1, -1));
        goto L13
    L10:
        r6 = null;
    L13:
        if (r8.size() <= 4) goto L20;
        k r13 = new k(getContext(), this.h);
        r13.c(d(r8, 4, 8));
        Unit r14 = Unit.INSTANCE;
        this.c = r13;
        FrameLayout r15 = this.a;
        View r16 = r13.getView();
        if (r16 == null) goto L20;
        if (r15.getChildCount() < 1) goto L20;
        r15.addView(r16, 0, new ViewGroup.LayoutParams(-1, -1));
    L20:
        this.f = true;
    }

    public SmallCardReplaceViewGroup(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.f = true;
        FrameLayout.inflate(r2, 2131567669, this);
        this.a = (FrameLayout) findViewById(2131384302);
    }

    public static List d(List r1, int r2, int r3) {
        int r0 = r1.size();
        if (r2 >= r0) goto L5;
        if (r3 < r0) goto L8;
        List r4 = r1.subList(r2, r0);
    L9:
        ArrayList r5 = new ArrayList();
        r5.addAll(r4);
        return r5;
    L8:
        r4 = r1.subList(r2, r3);
        goto L9
    L5:
        return new ArrayList();
    }
}
