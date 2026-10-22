package com.obric.memorydata.memory.ui.detail;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.GravityCompat;
import com.larus.business.markdown.impl.markwon.MarkdownTextView;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.spans.CustomLinkSpan;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 I2\u00020\u0001:\u0001IB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u00107\u001a\u0002082\f\u00109\u001a\b\u0012\u0004\u0012\u00020;0:J\u0016\u0010<\u001a\u0002082\u0006\u0010=\u001a\u0002022\u0006\u0010>\u001a\u00020?J\u0006\u0010@\u001a\u000208J \u0010A\u001a\u00020\u00012\u0006\u0010=\u001a\u0002022\u0006\u0010>\u001a\u00020?2\u0006\u0010B\u001a\u000202H\u0002J\u000e\u0010C\u001a\u000208*\u0004\u0018\u00010DH\u0002J\u0012\u0010E\u001a\u0002022\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u0012\u0010H\u001a\u0002022\b\u0010F\u001a\u0004\u0018\u00010GH\u0016R\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001a\u0010\"\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR\u001a\u0010%\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR\u001a\u0010(\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000fR\u001a\u0010+\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010\u000fR\u001a\u0010.\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\r\"\u0004\b0\u0010\u000fR\u001a\u00101\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006J"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/ChatListView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "messageContainer", "myBubbleColor", "getMyBubbleColor", "()I", "setMyBubbleColor", "(I)V", "otherBubbleColor", "getOtherBubbleColor", "setOtherBubbleColor", "myTextColor", "getMyTextColor", "setMyTextColor", "otherTextColor", "getOtherTextColor", "setOtherTextColor", "bubbleRadius", "", "getBubbleRadius", "()F", "setBubbleRadius", "(F)V", "textSize", "getTextSize", "setTextSize", "textLineHeight", "getTextLineHeight", "setTextLineHeight", "maxBubbleWidth", "getMaxBubbleWidth", "setMaxBubbleWidth", "messageSpacing", "getMessageSpacing", "setMessageSpacing", "paddingHorizontal", "getPaddingHorizontal", "setPaddingHorizontal", "paddingVertical", "getPaddingVertical", "setPaddingVertical", "enableSelect", "", "getEnableSelect", "()Z", "setEnableSelect", "(Z)V", "setMessages", "", "messages", "", "Lcom/obric/memorydata/memory/ui/detail/ChatListView$Companion$ChatMessage;", "addMessage", "isMine", Params.CONTENT, "", "clearMessages", "createMessageView", "isLast", "addLinkUnderlines", "Lcom/larus/business/markdown/api/model/MarkdownContent;", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ChatListView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f10797a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinearLayout f10798b;
    private int c;
    private int d;
    private int e;
    private int f;
    private float g;
    private float h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private boolean n;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/ChatListView$Companion;", "", "<init>", "()V", "TAG", "", "parseChatMessages", "", "Lcom/obric/memorydata/memory/ui/detail/ChatListView$Companion$ChatMessage;", "jsonString", "ChatMessage", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {

        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/ChatListView$Companion$ChatMessage;", "Landroid/os/Parcelable;", "isSelf", "", Params.CONTENT, "", "<init>", "(ZLjava/lang/String;)V", "()Z", "getContent", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class ChatMessage implements Parcelable {
            public static final Parcelable.Creator<ChatMessage> CREATOR = null;
            private final String content;
            private final boolean isSelf;

            @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
            public static final class a implements Parcelable.Creator<ChatMessage> {
                public a() {
                }

                public final ChatMessage a(Parcel r2) {
                    Intrinsics.checkNotNullParameter(r2, "parcel");
                    if (r2.readInt() == 0) goto L5;
                    boolean r0 = true;
                L7:
                    return new ChatMessage(r0, r2.readString());
                L5:
                    r0 = false;
                    goto L7
                }

                public final ChatMessage[] a(int r1) {
                    return new ChatMessage[r1];
                }

                @Override // android.os.Parcelable.Creator
                public /* synthetic */ ChatMessage createFromParcel(Parcel r1) {
                    return a(r1);
                }

                @Override // android.os.Parcelable.Creator
                public /* synthetic */ ChatMessage[] newArray(int r1) {
                    return a(r1);
                }
            }

            static {
                CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new a(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
            }

            public ChatMessage(boolean r2, String r3) {
                Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
                this.isSelf = r2;
                this.content = r3;
            }

            public static /* synthetic */ ChatMessage copy$default(ChatMessage r0, boolean r1, String r2, int r3, Object r4) {
                if ((r3 & 1) == 0) goto L6;
                r1 = r0.isSelf;
            L6:
                if ((r3 & 2) == 0) goto L9;
                r2 = r0.content;
            L9:
                return r0.copy(r1, r2);
            }

            public final boolean component1() {
                return this.isSelf;
            }

            public final String component2() {
                return this.content;
            }

            public final ChatMessage copy(boolean r1, String r2) {
                Intrinsics.checkNotNullParameter(r2, Params.CONTENT);
                return new ChatMessage(r1, r2);
            }

            @Override // android.os.Parcelable
            public final int describeContents() {
                return 0;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, ChatMessage.class) == true) goto L8;
                return false;
            L8:
                ChatMessage r6 = (ChatMessage) ZeusTransformUtils.preCheckCast(r5, ChatMessage.class, "com.obric.memorydata.plugin");
                if (this.isSelf == r6.isSelf) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.content, r6.content) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final String getContent() {
                return this.content;
            }

            public int hashCode() {
                return (Boolean.hashCode(this.isSelf) * 31) + this.content.hashCode();
            }

            public final boolean isSelf() {
                return this.isSelf;
            }

            public String toString() {
                return "ChatMessage(isSelf=" + this.isSelf + ", content=" + this.content + ')';
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel r1, int r2) {
                Intrinsics.checkNotNullParameter(r1, "dest");
                r1.writeInt(this.isSelf ? 1 : 0);
                r1.writeString(this.content);
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final List<ChatMessage> a(String r10) {
            Intrinsics.checkNotNullParameter(r10, "jsonString");
            JSONArray r1 = new JSONArray(r10);     // Catch: Exception -> L21
            List<ChatMessage> r11 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L21
            int r2 = r1.length();     // Catch: Exception -> L21
            int r4 = 0;
        L5:
            if (r4 >= r2) goto L17;
            JSONObject r6 = r1.getJSONObject(r4);     // Catch: Exception -> L21
            String r7 = r6.optString("RoleType", "");     // Catch: Exception -> L21
            String r8 = r6.optString("Content", "");     // Catch: Exception -> L21
            if (Intrinsics.areEqual(r7, "user") == false) goto L10;
            boolean r9 = true;
        L12:
            Intrinsics.checkNotNull(r8);     // Catch: Exception -> L21
            if ((true ^ StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L15;
            r11.add(new ChatMessage(r9, r8));     // Catch: Exception -> L21
        L15:
            r4 = r4 + 1;     // Catch: Exception -> L21
            goto L5
        L10:
            if (Intrinsics.areEqual(r7, "assistant") == false) goto L15;
            r9 = false;
            goto L12
        L17:
            if (r11.size() > 1) goto L30;
            return CollectionsKt.emptyList();
        L30:
            return r11;
        L21:
            e = move-exception;
            RunLog.INSTANCE.error("ChatListView", "parseChatMessages failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            return CollectionsKt.emptyList();
        }
    }

    static {
        f10797a = new Companion(null);
    }

    public ChatListView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public ChatListView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public ChatListView(Context r6, AttributeSet r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r8);
        LinearLayout r11 = new LinearLayout(r9);
        r11.setOrientation(1);
        r11.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        this.f10798b = r11;
        this.c = Color.parseColor("#0066FF");
        this.d = r9.getColor(ZeusTransformUtils.mapRes(R.color.oui_advanced_fill_list_item_card, TypedValues.Custom.S_COLOR, "oui_advanced_fill_list_item_card"));
        this.e = -1;
        this.f = r9.getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, TypedValues.Custom.S_COLOR, "oui_basic_text_1"));
        float r12 = 16;
        this.g = TypedValue.applyDimension(1, r12, Resources.getSystem().getDisplayMetrics());
        this.h = 16.0f;
        this.i = MathKt.roundToInt(TypedValue.applyDimension(1, 24, Resources.getSystem().getDisplayMetrics()));
        this.j = MathKt.roundToInt(TypedValue.applyDimension(1, 282, Resources.getSystem().getDisplayMetrics()));
        this.k = MathKt.roundToInt(TypedValue.applyDimension(1, 20, Resources.getSystem().getDisplayMetrics()));
        this.l = MathKt.roundToInt(TypedValue.applyDimension(1, r12, Resources.getSystem().getDisplayMetrics()));
        this.m = MathKt.roundToInt(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics()));
        this.n = true;
        setOrientation(1);
        addView((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.memorydata.plugin"));
    }

    public /* synthetic */ ChatListView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private final LinearLayout a(final boolean r15, final String r16, boolean r17) {
        final LinearLayout r6 = new LinearLayout((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        if (r15 == false) goto L5;
        int r0 = GravityCompat.END;
    L6:
        r6.setGravity(r0);
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-1, -2);
        if (r17 == false) goto L9;
        int r3 = 0;
    L10:
        r1.bottomMargin = r3;
        r6.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        FrameLayout r2 = new FrameLayout((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        GradientDrawable r4 = new GradientDrawable();
        if (r15 == false) goto L13;
        int r5 = this.c;
    L14:
        r4.setColor(r5);
        r4.setCornerRadius(this.g);
        r2.setBackground((Drawable) ZeusTransformUtils.preCheckCast(r4, Drawable.class, "com.obric.memorydata.plugin"));
        int r7 = this.l;
        int r8 = this.m;
        r2.setPadding(r7, r8, r7, r8);
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r9, "getContext(...)");
        final MarkdownTextView r10 = new MarkdownTextView(r9, null, 0, 6, null);
        r10.setText((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.memorydata.plugin"));
        r10.setTextSize(this.h);
        r10.setLineHeight(this.i);
        if (r15 == false) goto L17;
        int r11 = this.e;
    L18:
        r10.setTextColor(r11);
        if (r15 == false) goto L21;
        r10.setMaxWidth(this.j);
    L21:
        r2.addView((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin"));
        r6.addView((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"));
        com.obric.memorydata.memory.ui.p.a((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin"), false, new $$Lambda$ChatListView$kxiee1_WZsWCYSHfIsYMMhxzB4(this, r10, r6, r16, r15), 2, null);
        return r6;
    L17:
        r11 = this.f;
        goto L18
    L13:
        r5 = this.d;
        goto L14
    L9:
        r3 = this.k;
        goto L10
    L5:
        r0 = GravityCompat.START;
        goto L6
    }

    private static final Unit a(ChatListView r46, MarkdownTextView r47, LinearLayout r48, String r49, boolean r50, int r51) {
        com.larus.business.markdown.api.model.h r5 = null;
        Integer r6 = null;
        if (r46.n == false) goto L5;
        com.obric.memorydata.memory.ui.m.a((TextView) ZeusTransformUtils.preCheckCast(r47, TextView.class, "com.obric.memorydata.plugin"), null, 1, null);
    L5:
        com.larus.business.markdown.api.a r7 = com.obric.memorydata.markdown.a.f9973a.b();
        if (r7 == null) goto L11;
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r48.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r8, "getContext(...)");
        if (r50 == false) goto L10;
        r6 = Integer.valueOf(r46.e);
    L10:
        r5 = com.larus.business.markdown.api.a.b.a(r7, r8, r51, r49, true, new com.larus.business.markdown.api.model.c(0, null, null, null, false, false, r6, 0, 0, null, 0.0f, null, 0, 0, null, Integer.valueOf(MathKt.roundToInt(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics()))), Integer.valueOf(MathKt.roundToInt(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics()))), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -98369, null), null, null, null, 224, null);
    L11:
        r47.setMarkdownWidth(r51);
        if (r50 == false) goto L14;
        r46.a(r5);
    L14:
        r47.setMarkdown(r5);
        return Unit.INSTANCE;
    }

    private final void a(com.larus.business.markdown.api.model.h r8) {
        com.larus.business.markdown.api.model.h r7 = (com.larus.business.markdown.api.model.h) ZeusTransformUtils.wrapperContextForParams(r8, com.larus.business.markdown.api.model.h.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L14;
        SpannableStringBuilder r9 = r7.a();
        if (r9 == null) goto L19;
        int r2 = 0;
        Object[] r10 = r9.getSpans(0, r9.length(), CustomLinkSpan.class);
        Intrinsics.checkNotNullExpressionValue(r10, "getSpans(...)");
        int r1 = r10.length;
    L8:
        if (r2 >= r1) goto L20;
        CustomLinkSpan r3 = (CustomLinkSpan) ZeusTransformUtils.preCheckCast(r10[r2], CustomLinkSpan.class, "com.obric.memorydata.plugin");
        int r4 = r9.getSpanStart(r3);
        int r5 = r9.getSpanEnd(r3);
        if (r4 < 0) goto L13;
        if (r5 <= r4) goto L13;
        r9.setSpan(new UnderlineSpan(), r4, r5, 33);
    L13:
        r2 = r2 + 1;
        goto L8
    L20:
        return;
    L19:
        return;
    }

    /* JADX INFO: renamed from: lambda$kxiee1_WZsWCYSHf-IsYMMhxzB4, reason: not valid java name */
    public static /* synthetic */ Unit m836lambda$kxiee1_WZsWCYSHfIsYMMhxzB4(ChatListView r0, MarkdownTextView r1, LinearLayout r2, String r3, boolean r4, int r5) {
        return a(r0, r1, r2, r3, r4, r5);
    }

    public final float getBubbleRadius() {
        return this.g;
    }

    public final boolean getEnableSelect() {
        return this.n;
    }

    public final int getMaxBubbleWidth() {
        return this.j;
    }

    public final int getMessageSpacing() {
        return this.k;
    }

    public final int getMyBubbleColor() {
        return this.c;
    }

    public final int getMyTextColor() {
        return this.e;
    }

    public final int getOtherBubbleColor() {
        return this.d;
    }

    public final int getOtherTextColor() {
        return this.f;
    }

    public final int getPaddingHorizontal() {
        return this.l;
    }

    public final int getPaddingVertical() {
        return this.m;
    }

    public final int getTextLineHeight() {
        return this.i;
    }

    public final float getTextSize() {
        return this.h;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.n == true) goto L7;
        return false;
    L7:
        return super.onInterceptTouchEvent(r2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r2) {
        if (this.n == true) goto L7;
        return false;
    L7:
        return super.onTouchEvent(r2);
    }

    public final void setBubbleRadius(float r1) {
        this.g = r1;
    }

    public final void setEnableSelect(boolean r1) {
        this.n = r1;
    }

    public final void setMaxBubbleWidth(int r1) {
        this.j = r1;
    }

    public final void setMessageSpacing(int r1) {
        this.k = r1;
    }

    public final void setMessages(List<Companion.ChatMessage> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "messages");
        this.f10798b.removeAllViews();
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r3 = 0;
    L4:
        if (r0.hasNext() == false) goto L13;
        Object r4 = r0.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        Companion.ChatMessage r6 = (Companion.ChatMessage) ZeusTransformUtils.preCheckCast(r4, Companion.ChatMessage.class, "com.obric.memorydata.plugin");
        boolean r7 = r6.component1();
        String r8 = r6.component2();
        if (r3 != CollectionsKt.getLastIndex(r10)) goto L11;
        boolean r11 = true;
    L12:
        this.f10798b.addView((View) ZeusTransformUtils.preCheckCast(a(r7, r8, r11), View.class, "com.obric.memorydata.plugin"));
        r3 = r5;
        goto L4
    L11:
        r11 = false;
        goto L12
    }

    public final void setMyBubbleColor(int r1) {
        this.c = r1;
    }

    public final void setMyTextColor(int r1) {
        this.e = r1;
    }

    public final void setOtherBubbleColor(int r1) {
        this.d = r1;
    }

    public final void setOtherTextColor(int r1) {
        this.f = r1;
    }

    public final void setPaddingHorizontal(int r1) {
        this.l = r1;
    }

    public final void setPaddingVertical(int r1) {
        this.m = r1;
    }

    public final void setTextLineHeight(int r1) {
        this.i = r1;
    }

    public final void setTextSize(float r1) {
        this.h = r1;
    }
}
