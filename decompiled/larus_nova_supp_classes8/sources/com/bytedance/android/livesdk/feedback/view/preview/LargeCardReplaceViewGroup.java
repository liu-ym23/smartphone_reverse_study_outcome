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
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012B\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0013B\u001d\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0011\u0010\u0014J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R(\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/view/preview/LargeCardReplaceViewGroup;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/base/model/feedback/RoomCardStruct;", "getCurRoom", "Lcom/bytedance/android/livesdk/feedback/view/preview/b;", "value", "b", "Lcom/bytedance/android/livesdk/feedback/view/preview/b;", "setMFontPreviewView", "(Lcom/bytedance/android/livesdk/feedback/view/preview/b;)V", "mFontPreviewView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LargeCardReplaceViewGroup extends FrameLayout {
    public final FrameLayout a;
    public b b;
    public b c;
    public b d;
    public List<RoomCardStruct> e;
    public FeedbackContext f;
    public boolean g;

    public final j c() {
        if (this.g == false) goto L5;
        final List<RoomCardStruct> r0 = this.e;
        if (r0 == null) goto L9;
        final b r1 = this.c;
        if (r1 == null) goto L13;
        final b r2 = this.b;
        if (r2 == null) goto L17;
        final b r3 = this.d;
        this.g = false;
        if ((!r0.isEmpty()) == false) goto L21;
        LargeCardReplaceViewGroup r5 = this;
    L22:
        if (r5 == null) goto L24;
        RoomCardStruct r4 = (RoomCardStruct) ListProtector.remove(r0, 0);
    L24:
        r2.a(new LargeCardReplaceViewGroup$replaceFontPreviewView$3(this, r2));
        r1.b(new LargeCardReplaceViewGroup$replaceFontPreviewView$4(this, r1, r0, r3));
        return j.c.a;
    L21:
        r5 = null;
        goto L22
    L17:
        return j.a.a;
    L13:
        return j.a.a;
    L9:
        return j.a.a;
    L5:
        return j.b.a;
    }

    public final RoomCardStruct getCurRoom() {
        List<RoomCardStruct> r0 = this.e;
        if (r0 != null) goto L5;
        return null;
    L5:
        if ((!r0.isEmpty()) == true) goto L8;
        r0 = null;
    L8:
        if (r0 != null) goto L10;
        return null;
    L10:
        return (RoomCardStruct) ListProtector.get(r0, 0);
    }

    public LargeCardReplaceViewGroup(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 0);
    }

    private final void setMFontPreviewView(b r6) {
        this.b = r6;
        if (r6 == null) goto L7;
        RoomCardStruct r7 = r6.getRoomInfo();
        if (r7 == null) goto L7;
        Room r8 = r7.room;
    L8:
        if (r8 == null) goto L61;
        LinkedHashMap r0 = new LinkedHashMap();
        FeedbackContext r1 = this.f;
        String r2 = "";
        if (r1 == null) goto L14;
        String r3 = r1.getEnterFromMerge();
        if (r3 == null) goto L14;
    L15:
        r0.put("enter_from_merge", r3);
        FeedbackContext r4 = this.f;
        if (r4 == null) goto L19;
        String r5 = r4.getEnterMethod();
        if (r5 == null) goto L19;
    L20:
        r0.put("enter_method", r5);
        String r9 = String.valueOf(r8.id);
        if (r9 != null) goto L23;
        r9 = "";
    L23:
        r0.put("room_id", r9);
        User r10 = r8.getOwner();
        if (r10 == null) goto L27;
        String r11 = r10.getIdString();
        if (r11 == null) goto L27;
    L28:
        r0.put("anchor_id", r11);
        FeedbackContext r12 = this.f;
        if (r12 == null) goto L32;
        String r13 = r12.getReqId();
        if (r13 == null) goto L32;
    L33:
        r0.put("request_id", r13);
        FeedbackContext r14 = this.f;
        if (r14 == null) goto L41;
        FeedbackCard r15 = r14.getMFeedbackCard();
        if (r15 == null) goto L41;
        Long r16 = r15.feedbackId;
        if (r16 == null) goto L41;
        String r17 = String.valueOf(r16.longValue());
        if (r17 == null) goto L41;
    L42:
        r0.put("feedback_id", r17);
        FeedbackContext r18 = this.f;
        if (r18 == null) goto L50;
        FeedbackCard r19 = r18.getMFeedbackCard();
        if (r19 == null) goto L50;
        Integer r20 = r19.getIndex();
        if (r20 == null) goto L50;
        String r21 = String.valueOf(r20.intValue());
        if (r21 == null) goto L50;
    L51:
        r0.put("draw_order", r21);
        r0.put("flow_type", "internal_flow");
        FeedbackContext r22 = this.f;
        if (r22 == null) goto L59;
        FeedbackCard r23 = r22.getMFeedbackCard();
        if (r23 == null) goto L59;
        String r24 = r23.getLogInfo();
        if (r24 == null) goto L59;
        r2 = r24;
    L59:
        r0.put("question_text", r2);
        r0.put("card_type", "big_card");
        r0.put("question_type", "multiple");
        LiveMode r25 = r8.getStreamType();
        int r26 = h1.a;
        r0.put("live_type", i1.a(r25));
        u.l().sendLog("livesdk_live_feedback_card_live_room_show", r0, new Object[0]);
        return;
    L50:
        r21 = "";
    L41:
        r17 = "";
    L32:
        r13 = "";
    L27:
        r11 = "";
    L19:
        r5 = "";
    L14:
        r3 = "";
        goto L15
    L61:
        return;
    L7:
        r8 = null;
        goto L8
    }

    public LargeCardReplaceViewGroup(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public static final /* synthetic */ void a(LargeCardReplaceViewGroup r0, b r1) {
        r0.setMFontPreviewView(r1);
    }

    public final void b(List<RoomCardStruct> r6, FeedbackContext r7) {
        Intrinsics.checkNotNullParameter(r7, "feedbackContext");
        if (r6 != null) goto L5;
        return;
    L5:
        this.e = r6;
        this.f = r7;
        this.a.removeAllViews();
        if ((!r6.isEmpty()) == false) goto L13;
        LargeCardPreviewView r8 = new LargeCardPreviewView(getContext());
        r8.c((RoomCardStruct) ListProtector.get(r6, 0));
        Unit r3 = Unit.INSTANCE;
        setMFontPreviewView(r8);
        FrameLayout r9 = this.a;
        b r4 = this.b;
        if (r4 == null) goto L10;
        View r5 = r4.getView();
    L11:
        r9.addView(r5, new ViewGroup.LayoutParams(-1, -1));
        goto L13
    L10:
        r5 = null;
    L13:
        if (r6.size() <= 1) goto L20;
        LargeCardPreviewView r10 = new LargeCardPreviewView(getContext());
        r10.c((RoomCardStruct) ListProtector.get(r6, 1));
        Unit r11 = Unit.INSTANCE;
        this.c = r10;
        FrameLayout r12 = this.a;
        View r13 = r10.getView();
        if (r13 == null) goto L20;
        if (r12.getChildCount() < 1) goto L20;
        r12.addView(r13, 0, new ViewGroup.LayoutParams(-1, -1));
    L20:
        this.g = true;
    }

    public LargeCardReplaceViewGroup(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.g = true;
        FrameLayout.inflate(r2, 2131567667, this);
        this.a = (FrameLayout) findViewById(2131384302);
    }
}
