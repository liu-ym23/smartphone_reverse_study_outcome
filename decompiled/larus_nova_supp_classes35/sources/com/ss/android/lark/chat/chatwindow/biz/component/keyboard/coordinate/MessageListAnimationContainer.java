package com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0016\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboard/coordinate/MessageListAnimationContainer;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "isInAnimation", BuildConfig.FLAVOR, "()Z", "setInAnimation", "(Z)V", "animType", "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboard/coordinate/MessageListAnimationContainer$AnimType;", "getAnimType", "()Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboard/coordinate/MessageListAnimationContainer$AnimType;", "setAnimType", "(Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboard/coordinate/MessageListAnimationContainer$AnimType;)V", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "AnimType", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageListAnimationContainer extends LinearLayout {
    public AnimType a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboard/coordinate/MessageListAnimationContainer$AnimType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Enter", "Exit", "None", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AnimType extends Enum<AnimType> {
        public static final AnimType Enter = null;
        public static final AnimType Exit = null;
        public static final AnimType None = null;
        public static final /* synthetic */ AnimType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<AnimType> getEntries() {
            return b;
        }

        static {
            AnimType r0 = new AnimType("Enter", 0);
            Enter = r0;
            AnimType r1 = new AnimType("Exit", 1);
            Exit = r1;
            AnimType r3 = new AnimType("None", 2);
            None = r3;
            AnimType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static AnimType[] values() {
            return (AnimType[]) a.clone();
        }

        public static AnimType valueOf(String r1) {
            return (AnimType) a.a(AnimType.class, r1);
        }

        public AnimType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public MessageListAnimationContainer(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 0, 14);
    }

    public MessageListAnimationContainer(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 12);
    }

    public MessageListAnimationContainer(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 8);
    }

    public final void setInAnimation(boolean r1) {
    }

    public final AnimType getAnimType() {
        return this.a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        AnimType r0 = this.a;
        if (r0 != AnimType.Enter) goto L22;
        boolean r1 = true;
        if (r5 != null) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == true) goto L19;
        if (r5 != null) goto L13;
    L15:
        r1 = false;
    L16:
        if (r1 == true) goto L19;
        return false;
    L13:
        if (r5.getActionMasked() != 1) goto L15;
    L19:
        MotionEvent r6 = MotionEvent.obtain(r5);
        r6.setAction(3);
        return super.dispatchTouchEvent(r6);
    L7:
        if (r5.getActionMasked() != 2) goto L9;
        r2 = true;
        goto L10
    L22:
        if (r0 != AnimType.Exit) goto L28;
        if (Math.abs(getTranslationY()) <= 0.0f) goto L28;
        if (r5 == null) goto L28;
        r5.offsetLocation(0.0f, getTranslationY());
    L28:
        return super.dispatchTouchEvent(r5);
    }

    public final void setAnimType(AnimType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public MessageListAnimationContainer(Context r2, AttributeSet r3, int r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4, 0);
        this.a = AnimType.None;
    }
}
