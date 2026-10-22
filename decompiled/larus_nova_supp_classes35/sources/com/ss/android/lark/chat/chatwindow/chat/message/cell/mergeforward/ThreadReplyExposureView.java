package com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.api.n0;
import com.ss.android.lark.chat.utils.ReplyInThreadUtil;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0096\u00012\u00020\u0001:\u0006\u0096\u0001\u0097\u0001\u0098\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010t\u001a\u00020u2\b\b\u0001\u0010v\u001a\u00020\u00072\b\b\u0001\u0010w\u001a\u00020\u0007J&\u0010x\u001a\u00020u2\u000e\b\u0002\u0010B\u001a\b\u0012\u0002\b\u0003\u0018\u00010C2\u000e\u0010y\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010zJ\b\u0010{\u001a\u00020uH\u0002J\b\u0010|\u001a\u00020uH\u0002J\u0010\u0010}\u001a\u00020u2\u0006\u0010~\u001a\u00020VH\u0002J\b\u0010\u007f\u001a\u00020uH\u0002J\"\u0010\u0080\u0001\u001a\u00020\u00122\u0007\u0010\u0081\u0001\u001a\u00020\u000e2\u0007\u0010\u0082\u0001\u001a\u00020\u000eH\u0082@¢\u0006\u0003\u0010\u0083\u0001J\u0013\u0010\u0084\u0001\u001a\u00020$2\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0017J\t\u0010\u0087\u0001\u001a\u00020$H\u0016J\u001b\u0010\u0088\u0001\u001a\u00020u2\u0007\u0010\u0089\u0001\u001a\u00020\u00072\u0007\u0010\u008a\u0001\u001a\u00020\u0007H\u0014J\u001b\u0010\u008b\u0001\u001a\u00020u2\u0007\u0010\u008c\u0001\u001a\u00020\u00072\u0007\u0010\u008d\u0001\u001a\u00020\u0007H\u0002J%\u0010\u008e\u0001\u001a\u00020u2\u0007\u0010\u008c\u0001\u001a\u00020\u00072\b\u0010\u008f\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u008d\u0001\u001a\u00020\u0007H\u0002J\u0013\u0010\u0091\u0001\u001a\u00020u2\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0014J\t\u0010\u0094\u0001\u001a\u00020uH\u0014J\t\u0010\u0095\u0001\u001a\u00020uH\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00140\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR$\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020$@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\u001b\u0010-\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0019\u001a\u0004\b.\u0010/R\u001b\u00101\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0019\u001a\u0004\b2\u0010/R\u0014\u00104\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u0010/R\u0014\u00106\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u0010/R\u001b\u00108\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u0019\u001a\u0004\b9\u0010/R\u001b\u0010;\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u0019\u001a\u0004\b<\u0010\u001dR\u001e\u0010>\u001a\u0012\u0012\u0004\u0012\u00020@0?j\b\u0012\u0004\u0012\u00020@`AX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010B\u001a\b\u0012\u0002\b\u0003\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010D\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bE\u0010/R\u001a\u0010F\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010/\"\u0004\bH\u0010IR\u001a\u0010J\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010'\"\u0004\bL\u0010)R\u001a\u0010M\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010'\"\u0004\bO\u0010)R\u0014\u0010P\u001a\b\u0012\u0004\u0012\u00020@0QX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010T\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010V0U8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010\u0019\u001a\u0004\bW\u0010XR#\u0010Z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010[0U8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b^\u0010\u0019\u001a\u0004\b\\\u0010]R\u001f\u0010_\u001a\u00060`R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bc\u0010\u0019\u001a\u0004\ba\u0010bR\u001b\u0010d\u001a\u00020e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bh\u0010\u0019\u001a\u0004\bf\u0010gR\u000e\u0010i\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020kX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010l\u001a\u0004\u0018\u00010mX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u000e\u0010r\u001a\u00020sX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0099\u0001"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/message/cell/mergeforward/ThreadReplyExposureView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "avatarKeys", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "avatarKeyToEntityIdMap", BuildConfig.FLAVOR, "avatarKeyToBitmapMap", "Landroid/graphics/Bitmap;", "avatarKeyToBitmapLoadJobMap", "Lkotlinx/coroutines/Job;", "avatarPlaceholderBitmap", "getAvatarPlaceholderBitmap", "()Landroid/graphics/Bitmap;", "avatarPlaceholderBitmap$delegate", "Lkotlin/Lazy;", "avatarSizeDp", BuildConfig.FLAVOR, "getAvatarSizeDp", "()F", "setAvatarSizeDp", "(F)V", "textSizeDp", "getTextSizeDp", "setTextSizeDp", "value", BuildConfig.FLAVOR, "showAvatar", "getShowAvatar", "()Z", "setShowAvatar", "(Z)V", "tintLinkIconWithTextColor", "getTintLinkIconWithTextColor", "setTintLinkIconWithTextColor", "avatarSize", "getAvatarSize", "()I", "avatarSize$delegate", "replyMarginLeft", "getReplyMarginLeft", "replyMarginLeft$delegate", "contentStartMargin", "getContentStartMargin", "rowMinHeight", "getRowMinHeight", "spacingBetweenReplies", "getSpacingBetweenReplies", "spacingBetweenReplies$delegate", "lineSpacing", "getLineSpacing", "lineSpacing$delegate", "replyComparator", "Ljava/util/Comparator;", "Lcom/ss/android/lark/biz/im/api/ISimplifiedMessageInfo;", "Lkotlin/Comparator;", "rootMessage", "Lcom/ss/android/lark/chat/vo/ChatMessageVO;", "showingReplyCount", "getShowingReplyCount", "maxShowingReplyCount", "getMaxShowingReplyCount", "setMaxShowingReplyCount", "(I)V", "showTailEllipsis", "getShowTailEllipsis", "setShowTailEllipsis", "showLastedItems", "getShowLastedItems", "setShowLastedItems", "showingReplyList", BuildConfig.FLAVOR, "lastTotalWidth", "needReGenerateReplyLayout", "spannableStringArray", BuildConfig.FLAVOR, "Landroid/text/SpannableStringBuilder;", "getSpannableStringArray", "()[Landroid/text/SpannableStringBuilder;", "spannableStringArray$delegate", "replyLayoutArray", "Landroid/text/StaticLayout;", "getReplyLayoutArray", "()[Landroid/text/StaticLayout;", "replyLayoutArray$delegate", "replyNameSpan", "Lcom/ss/android/lark/chat/chatwindow/chat/message/cell/mergeforward/ThreadReplyExposureView$ReplyNameSpan;", "getReplyNameSpan", "()Lcom/ss/android/lark/chat/chatwindow/chat/message/cell/mergeforward/ThreadReplyExposureView$ReplyNameSpan;", "replyNameSpan$delegate", "replyPaint", "Landroid/text/TextPaint;", "getReplyPaint", "()Landroid/text/TextPaint;", "replyPaint$delegate", "requiredVersionCode", "touchDownTime", BuildConfig.FLAVOR, "onClickReplyListener", "Lcom/ss/android/lark/chat/chatwindow/chat/message/cell/mergeforward/ThreadReplyExposureView$OnClickReplyListener;", "getOnClickReplyListener", "()Lcom/ss/android/lark/chat/chatwindow/chat/message/cell/mergeforward/ThreadReplyExposureView$OnClickReplyListener;", "setOnClickReplyListener", "(Lcom/ss/android/lark/chat/chatwindow/chat/message/cell/mergeforward/ThreadReplyExposureView$OnClickReplyListener;)V", "longClickCheckRunnable", "Ljava/lang/Runnable;", "setTextColor", BuildConfig.FLAVOR, "usernameTextColor", "contentTextColor", "updateReplyList", "replyList", BuildConfig.FLAVOR, "updateAvatarData", "clearAvatarData", "tintLinkIcons", "spannable", "loadMissingAvatars", "loadAvatarBitmap", "avatarKey", "entityId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "performClick", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "checkSpannableString", "i", "textMaxWidth", "getStaticLayout", "nameAndContent", BuildConfig.FLAVOR, "onDraw", "canvas", "Landroid/graphics/Canvas;", "onAttachedToWindow", "onDetachedFromWindow", "Companion", "ReplyNameSpan", "OnClickReplyListener", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThreadReplyExposureView extends View {
    public final Lazy A;
    public final int B;
    public long C;
    public b D;
    public final d E;
    public CoroutineScope a;
    public final Set<String> b;
    public final Map<String, String> c;
    public final Map<String, Bitmap> d;
    public final Map<String, Job> e;
    public final Lazy f;
    public float g;
    public float h;
    public boolean i;
    public boolean j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final e o;
    public y6b.c<?> p;
    public int q;
    public int r;
    public boolean s;
    public boolean t;
    public final List<n0> u;
    public int v;
    public boolean w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
    }

    public interface b {
        void a();

        void b(y6b.c<?> r1, n0 r2);
    }

    public final class c extends ReplacementSpan {
        public final int a;
        public final Rect b;
        public int c;

        public c(ThreadReplyExposureView r2) {
            this.a = y9c.d.a(6);
            this.b = new Rect();
            this.c = UDColorUtils.getColor(r2.getContext(), 2131106622);
        }

        @Override // android.text.style.ReplacementSpan
        public final int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
            Intrinsics.checkNotNullParameter(r1, "paint");
            if (r2 != null) goto L7;
            return 0;
        L7:
            return MathKt.roundToInt(r1.measureText(r2, r3, r4) + this.a);
        }

        @Override // android.text.style.ReplacementSpan
        public final void draw(Canvas r13, CharSequence r14, int r15, int r16, float r17, int r18, int r19, int r20, Paint r21) {
            Intrinsics.checkNotNullParameter(r13, "canvas");
            Intrinsics.checkNotNullParameter(r21, "paint");
            if (r14 != null) goto L5;
            return;
        L5:
            this.b.set(MathKt.roundToInt(r17), r18, MathKt.roundToInt((r17 + r21.measureText(r14, r15, r16)) + this.a), r20);
            boolean r3 = r21 instanceof TextPaint;
            TextPaint r4 = null;
            if (r3 == false) goto L8;
            TextPaint r7 = (TextPaint) r21;
        L10:
            if (r7 == null) goto L12;
            boolean r10 = r7.isFakeBoldText();
        L13:
            int r11 = r21.getColor();
            r21.setColor(0);
            r13.drawRect(this.b, r21);
            r21.setColor(this.c);
            if (r3 == false) goto L16;
            r4 = (TextPaint) r21;
        L16:
            if (r4 == null) goto L18;
            r4.setFakeBoldText(true);
        L18:
            r13.drawText(r14, r15, r16, r17, r19, r21);
            TextPaint r1 = (TextPaint) r21;
            r1.setFakeBoldText(r10);
            r1.setColor(r11);
            return;
        L12:
            r10 = false;
            goto L13
        L8:
            r7 = null;
            goto L10
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ ThreadReplyExposureView a;

        public d(ThreadReplyExposureView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.cancelPendingInputEvents();     // Catch: Throwable -> L6
            b r0 = this.a.getOnClickReplyListener();     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.a();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class e<T> implements Comparator {
        public static final e<T> a = null;

        static {
            a = new e();
        }

        public e() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r1, Object r2) {
            return ((n0) r1).b() - ((n0) r2).b();
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ ThreadReplyExposureView a;

        public f(ThreadReplyExposureView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.requestLayout();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public ThreadReplyExposureView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ThreadReplyExposureView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final Bitmap getAvatarPlaceholderBitmap() {
        return (Bitmap) this.f.getValue();
    }

    private final int getAvatarSize() {
        return ((Number) this.k.getValue()).intValue();
    }

    private final int getContentStartMargin() {
        if (this.i == true) goto L7;
        return 0;
    L7:
        return getReplyMarginLeft();
    }

    private final float getLineSpacing() {
        return ((Number) this.n.getValue()).floatValue();
    }

    private final StaticLayout[] getReplyLayoutArray() {
        return (StaticLayout[]) this.y.getValue();
    }

    private final int getReplyMarginLeft() {
        return ((Number) this.l.getValue()).intValue();
    }

    private final c getReplyNameSpan() {
        return (c) this.z.getValue();
    }

    private final TextPaint getReplyPaint() {
        return (TextPaint) this.A.getValue();
    }

    private final int getRowMinHeight() {
        if (this.i == true) goto L7;
        return 0;
    L7:
        return getAvatarSize();
    }

    private final int getSpacingBetweenReplies() {
        return ((Number) this.m.getValue()).intValue();
    }

    private final SpannableStringBuilder[] getSpannableStringArray() {
        return (SpannableStringBuilder[]) this.x.getValue();
    }

    public final void c() {
        if (this.i == true) goto L6;
        return;
    L6:
        if (CoroutineScopeKt.isActive(this.a) == true) goto L8;
        this.a = CoroutineScopeKt.CoroutineScope(JobKt.Job$default(null, 1, null).plus(Dispatchers.getMain()));
    L8:
        Iterator<String> r0 = this.b.iterator();
    L10:
        if (r0.hasNext() == false) goto L27;
        String r3 = r0.next();
        if (this.d.containsKey(r3) == false) goto L21;
        Bitmap r4 = (Bitmap) ((LinkedHashMap) this.d).get(r3);
        boolean r5 = false;
        if (r4 != null) goto L16;
    L18:
        if (r5 == true) goto L21;
    L16:
        if (r4.isRecycled() != true) goto L18;
        r5 = true;
    L21:
        if (this.e.containsKey(r3) == true) goto L10;
        String r6 = (String) ((LinkedHashMap) this.c).get(r3);
        if (r6 == null) goto L10;
        this.e.put(r3, BuildersKt.launch$default(this.a, Dispatchers.getIO(), null, new ThreadReplyExposureView$loadMissingAvatars$1(this, r3, r6, null), 2, null));
        goto L10
    }

    public final void e() {
        if (this.i == true) goto L5;
    L25:
        this.b.clear();
        ((LinkedHashMap) this.c).clear();
        ((LinkedHashMap) this.d).clear();
        Iterator r0 = ((LinkedHashMap) this.e).values().iterator();
    L27:
        if (r0.hasNext() == false) goto L29;
        Job.DefaultImpls.cancel$default((Job) r0.next(), null, 1, null);
        goto L27
    L29:
        ((LinkedHashMap) this.e).clear();
        return;
    L5:
        if (((ArrayList) this.u).isEmpty() == true) goto L25;
        LinkedHashSet r1 = new LinkedHashSet();
        ((LinkedHashMap) this.c).clear();
        Iterator r3 = ((ArrayList) this.u).iterator();
    L9:
        if (r3.hasNext() == false) goto L17;
        n0 r4 = (n0) r3.next();
        if (r4.d().length() != 0) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == true) goto L15;
        r1.add(r4.d());
        this.c.put(r4.d(), r4.c());
        goto L9
    L15:
        Log.w("MessageThreadCellReplyView", "updateReplyList, reply message id is " + r4.getMessageId() + ", sender id is " + r4.c() + ", avatar key is empty");
        goto L9
    L13:
        r5 = false;
        goto L14
    L17:
        ((LinkedHashMap) this.d).keySet().retainAll(r1);
        Iterator r6 = ((LinkedHashMap) this.e).entrySet().iterator();
    L19:
        if (r6.hasNext() == false) goto L23;
        Map.Entry r7 = (Map.Entry) r6.next();
        if (r1.contains(r7.getKey()) == true) goto L19;
        Job.DefaultImpls.cancel$default((Job) r7.getValue(), null, 1, null);
        r6.remove();
        goto L19
    L23:
        Set<String> r2 = this.b;
        r2.clear();
        r2.addAll(r1);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CoroutineScopeKt.cancel$default(this.a, null, 1, null);
        ((LinkedHashMap) this.e).clear();
    }

    @Override // android.view.View
    public final boolean performClick() {
        return super.performClick();
    }

    public final float getAvatarSizeDp() {
        return this.g;
    }

    public final int getMaxShowingReplyCount() {
        return this.r;
    }

    public final b getOnClickReplyListener() {
        return this.D;
    }

    public final boolean getShowAvatar() {
        return this.i;
    }

    public final boolean getShowLastedItems() {
        return this.t;
    }

    public final boolean getShowTailEllipsis() {
        return this.s;
    }

    public final int getShowingReplyCount() {
        return this.q;
    }

    public final float getTextSizeDp() {
        return this.h;
    }

    public final boolean getTintLinkIconWithTextColor() {
        return this.j;
    }

    public static final /* synthetic */ int a(ThreadReplyExposureView r0) {
        return r0.getAvatarSize();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r11) {
        Intrinsics.checkNotNullParameter(r11, "canvas");
        int r0 = this.q;
        int r3 = 0;
        float r4 = 0.0f;
    L3:
        if (r3 >= r0) goto L21;
        r11.save();
        r11.translate(0.0f, r4);
        if (this.i == false) goto L13;
        String r5 = ((n0) ListProtector.get(this.u, r3)).d();
        Bitmap r6 = (Bitmap) ((LinkedHashMap) this.d).get(r5);
        if (r6 != null) goto L10;
        Log.w("MessageThreadCellReplyView", "avatar bitmap not found for key: " + r5);
        r11.drawBitmap(getAvatarPlaceholderBitmap(), 0.0f, 0.0f, null);
        goto L13
    L10:
        if (r6.isRecycled() == false) goto L12;
        Log.w("MessageThreadCellReplyView", "avatar bitmap is recycled for key: " + r5);
        r11.drawBitmap(getAvatarPlaceholderBitmap(), 0.0f, 0.0f, null);
        goto L13
    L12:
        r11.drawBitmap(r6, 0.0f, 0.0f, null);
    L13:
        r11.translate(getContentStartMargin(), 0.0f);
        StaticLayout r7 = getReplyLayoutArray()[r3];
        if (r7 == null) goto L16;
        r7.draw(r11);
    L16:
        r11.restore();
        if (r7 == null) goto L19;
        int r8 = r7.getHeight();
    L20:
        r4 = r4 + (Math.max(r8, getRowMinHeight()) + getSpacingBetweenReplies());
        r3 = r3 + 1;
        goto L3
    L19:
        r8 = 0;
        goto L20
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        if (this.D != null) goto L5;
        return false;
    L5:
        int r0 = r8.getAction();
        if (r0 == 0) goto L44;
        if (r0 != 1) goto L9;
        removeCallbacks(this.E);
        if ((System.currentTimeMillis() - this.C) >= ViewConfiguration.getLongPressTimeout()) goto L16;
        boolean r1 = true;
    L17:
        if (r1 == true) goto L19;
        return true;
    L19:
        int r2 = this.q;
        int r3 = 0;
        int r4 = 0;
    L20:
        if (r3 >= r2) goto L43;
        StaticLayout r5 = getReplyLayoutArray()[r3];
        if (r5 == null) goto L24;
        int r6 = r5.getHeight();
    L25:
        int r7 = r6 + r4;
        if (r3 != 0) goto L28;
    L31:
        int r9 = getSpacingBetweenReplies() / 2;
    L32:
        int r10 = r7 + r9;
        if (r4 > r8.getY()) goto L42;
        if (r10 < r8.getY()) goto L42;
        y6b.c<?> r11 = this.p;
        if (r11 == null) goto L41;
        b r12 = this.D;
        if (r12 == null) goto L41;
        r12.b(r11, (n0) ListProtector.get(this.u, r3));
    L41:
        return true;
    L42:
        r3 = r3 + 1;
        r4 = r10;
        goto L20
    L28:
        if (r3 == (this.q - 1)) goto L31;
        r9 = getSpacingBetweenReplies();
        goto L32
    L24:
        r6 = 0;
        goto L25
    L43:
        return false;
    L16:
        r1 = false;
        goto L17
    L9:
        if (r0 == 3) goto L11;
        return false;
    L11:
        removeCallbacks(this.E);
        return true;
    L44:
        this.C = System.currentTimeMillis();
        Log.e("MessageThreadCellReplyView", "touchDownTime: " + this.C);
        removeCallbacks(this.E);
        postDelayed(this.E, (long) ViewConfiguration.getLongPressTimeout());
        return true;
    }

    public final void setAvatarSizeDp(float r1) {
        this.g = r1;
    }

    public final void setMaxShowingReplyCount(int r1) {
        this.r = r1;
    }

    public final void setOnClickReplyListener(b r1) {
        this.D = r1;
    }

    public final void setShowAvatar(boolean r2) {
        if (this.i != r2) goto L5;
        return;
    L5:
        this.i = r2;
        this.w = true;
        e();
        c();
        requestLayout();
        invalidate();
    }

    public final void setShowLastedItems(boolean r1) {
        this.t = r1;
    }

    public final void setShowTailEllipsis(boolean r1) {
        this.s = r1;
    }

    public final void setTextSizeDp(float r1) {
        this.h = r1;
    }

    public final void setTintLinkIconWithTextColor(boolean r1) {
        this.j = r1;
    }

    public final void d(int r2, int r3) {
        getReplyNameSpan().c = r2;
        getReplyPaint().setColor(r3);
    }

    public final void f(y6b.c<?> r13, List<? extends n0> r14) {
        this.p = r13;
        ((ArrayList) this.u).clear();
        List<? extends n0> r15 = r14;
        if (r15 != null) goto L5;
    L8:
        boolean r16 = true;
    L9:
        if (r16 == false) goto L11;
        this.q = 0;
    L16:
        e();
        if (this.s == false) goto L24;
        if (r14 == null) goto L20;
        int r17 = r14.size();
    L22:
        if (r17 <= this.r) goto L24;
        boolean r18 = true;
    L25:
        int r19 = this.q;
        int r2 = 0;
    L26:
        if (r2 >= r19) goto L49;
        n0 r3 = (n0) ListProtector.get(this.u, r2);
        String r4 = r3.a();
        SpannableStringBuilder r5 = new SpannableStringBuilder().append(r4).append(r3.getMessageContent());
        if (r18 == true) goto L30;
    L32:
        r5.setSpan(getReplyNameSpan(), 0, r4.length(), 17);
        if (this.j == false) goto L48;
        Intrinsics.checkNotNull(r5);
        int r6 = getReplyPaint().getColor();
        Iterator r7 = ArrayIteratorKt.iterator((ncc.e[]) r5.getSpans(0, r5.length(), ncc.e.class));
    L36:
        if (r7.hasNext() == false) goto L48;
        ncc.e r8 = (ncc.e) r7.next();
        if (r8.e == false) goto L42;
        if (r8.f == 0) goto L36;
    L42:
        Drawable r9 = r8.c;
        if (r9 == null) goto L45;
        r9.mutate();
        r9.setTint(r6);
    L45:
        r8.a(new com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.d(this, r6));
        Bitmap r10 = r8.b;
        if (r10 == null) goto L36;
        Paint r11 = new Paint();
        r11.setColorFilter(new PorterDuffColorFilter(r6, PorterDuff.Mode.SRC_IN));
        Bitmap r12 = Bitmap.createBitmap(r10.getWidth(), r10.getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(r12).drawBitmap(r10, 0.0f, 0.0f, r11);
        r8.b = r12;
    L48:
        getSpannableStringArray()[r2] = r5;
        r2 = r2 + 1;
        goto L26
    L30:
        if (r2 != (this.q - 1)) goto L32;
        r5.append("...");
        goto L32
    L49:
        this.w = true;
        c();
        post(new f(this));
        return;
    L20:
        r17 = 0;
    L24:
        r18 = false;
        goto L25
    L11:
        this.q = Math.min(this.r, r14.size());
        List r110 = CollectionsKt.sortedWith(r14, this.o);
        if (this.t == false) goto L14;
        List r111 = r110.subList(r110.size() - this.q, r110.size());
    L15:
        ArrayList r20 = (ArrayList) this.u;
        r20.addAll(r111);
        goto L16
    L14:
        r111 = r110.subList(0, this.q);
        goto L15
    L5:
        if (r15.isEmpty() == true) goto L8;
        r16 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public final void onMeasure(int r27, int r28) {
        if (this.q >= 1) goto L6;
        setMeasuredDimension(0, 0);
        return;
    L6:
        int r0 = View.MeasureSpec.getMode(r27);
        if (r0 != Integer.MIN_VALUE) goto L9;
    L11:
        int r4 = View.MeasureSpec.getSize(r27);
    L12:
        if (r4 > 0) goto L16;
        setMeasuredDimension(0, 0);
        return;
    L16:
        if (this.v == r4) goto L19;
        this.w = true;
    L19:
        if (this.w == true) goto L21;
        int r1 = r4;
    L74:
        int r3 = getSpacingBetweenReplies();
        int r5 = this.q;
        int r6 = (r3 * (r5 - 1)) + 0;
        int r7 = 0;
    L75:
        if (r7 >= r5) goto L81;
        StaticLayout r8 = getReplyLayoutArray()[r7];
        if (r8 == null) goto L79;
        int r9 = r8.getHeight();
    L80:
        r6 = r6 + Math.max(r9, getRowMinHeight());
        r7 = r7 + 1;
        goto L75
    L79:
        r9 = 0;
        goto L80
    L81:
        int r2 = Math.max(getMinimumWidth(), Math.min(r1, r4));
        this.v = r2;
        setMeasuredDimension(r2, r6);
        return;
    L21:
        if ((r4 - getContentStartMargin()) >= 0) goto L23;
        int r10 = 0;
    L24:
        int r11 = this.q;
        int r12 = 0;
    L26:
        if (r12 >= r11) goto L52;
        String r13 = ((n0) ListProtector.get(this.u, r12)).a();
        float r14 = r10;
        if (getReplyPaint().measureText(r13) <= r14) goto L30;
        boolean r15 = getReplyPaint().isFakeBoldText();
        getReplyPaint().setFakeBoldText(true);
        CharSequence r16 = TextUtils.ellipsize(r13, getReplyPaint(), r14, TextUtils.TruncateAt.END);
        SpannableStringBuilder r17 = new SpannableStringBuilder().append(r16).append(((n0) ListProtector.get(this.u, r12)).getMessageContent());
        r17.setSpan(getReplyNameSpan(), 0, r16.length(), 17);
        getSpannableStringArray()[r12] = r17;
        getReplyPaint().setFakeBoldText(r15);
    L30:
        CharSequence r18 = getSpannableStringArray()[r12];
        if (r18 != null) goto L34;
        r18 = BuildConfig.FLAVOR;
    L34:
        int r19 = this.B;
        Boolean r110 = ReplyInThreadUtil.a;
        if (Build.VERSION.SDK_INT < r19) goto L37;
        boolean r111 = true;
    L39:
        if (r111 == false) goto L83;
        getReplyLayoutArray()[r12] = StaticLayout.Builder.obtain(r18, 0, r18.length(), getReplyPaint(), r10).setEllipsize(TextUtils.TruncateAt.END).setMaxLines(2).setLineSpacing(getLineSpacing(), 1.0f).setAlignment(Layout.Alignment.ALIGN_NORMAL).setTextDirection(TextDirectionHeuristics.LOCALE).setIncludePad(true).build();
    L51:
        r12 = r12 + 1;
        goto L26
    L83:
        Class r112 = Integer.TYPE;     // Catch: InvocationTargetException -> L43 InstantiationException -> L45 IllegalAccessException -> L47 NoSuchMethodException -> L49
        Class r113 = Float.TYPE;     // Catch: InvocationTargetException -> L43 InstantiationException -> L45 IllegalAccessException -> L47 NoSuchMethodException -> L49
        Constructor r114 = StaticLayout.class.getConstructor(new Class[]{CharSequence.class, r112, r112, TextPaint.class, r112, Layout.Alignment.class, TextDirectionHeuristic.class, r113, r113, Boolean.TYPE, TextUtils.TruncateAt.class, r112, r112});     // Catch: InvocationTargetException -> L43 InstantiationException -> L45 IllegalAccessException -> L47 NoSuchMethodException -> L49
        r114.setAccessible(true);     // Catch: InvocationTargetException -> L43 InstantiationException -> L45 IllegalAccessException -> L47 NoSuchMethodException -> L49
        getReplyLayoutArray()[r12] = r114.newInstance(new Object[]{r18, 0, Integer.valueOf(r18.length()), getReplyPaint(), Integer.valueOf(r10), Layout.Alignment.ALIGN_NORMAL, TextDirectionHeuristics.LOCALE, Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.TRUE, TextUtils.TruncateAt.END, Integer.valueOf(r10), 2});     // Catch: InvocationTargetException -> L43 InstantiationException -> L45 IllegalAccessException -> L47 NoSuchMethodException -> L49
    L47:
        e = move-exception;
        Log.e("MessageThreadCellReplyView", e.getMessage());
    L45:
        e = move-exception;
        Log.e("MessageThreadCellReplyView", e.getMessage());
    L49:
        e = move-exception;
        Log.e("MessageThreadCellReplyView", e.getMessage());
    L43:
        e = move-exception;
        Log.e("MessageThreadCellReplyView", e.getMessage());
        goto L51
    L37:
        r111 = false;
        goto L39
    L52:
        List r20 = ArraysKt.toList(getReplyLayoutArray()).subList(0, this.q);
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
        Iterator r22 = r20.iterator();
    L54:
        if (r22.hasNext() == false) goto L68;
        StaticLayout r23 = (StaticLayout) r22.next();
        if (r23 == null) goto L66;
        int r24 = r23.getLineCount();
        ArrayList r25 = new ArrayList();
        if (r24 < 0) goto L63;
        int r26 = 0;
    L60:
        r25.add(Float.valueOf(r23.getLineWidth(r26)));
        if (r26 == r24) goto L63;
        r26 = r26 + 1;
    L63:
        Float r29 = CollectionsKt.maxOrNull(r25);
        if (r29 == null) goto L66;
        float r30 = r29.floatValue();
    L67:
        r21.add(Float.valueOf(r30));
    L66:
        r30 = 0.0f;
        goto L67
    L68:
        Float r31 = CollectionsKt.maxOrNull(r21);
        if (r31 == null) goto L71;
        r1 = ((int) r31.floatValue()) + getContentStartMargin();
    L72:
        this.w = false;
        goto L74
    L71:
        r1 = r4;
        goto L72
    L23:
        r10 = r4 - getContentStartMargin();
        goto L24
    L9:
        if (r0 == 1073741824) goto L11;
        r4 = 0;
        goto L12
    }

    public ThreadReplyExposureView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.a = CoroutineScopeKt.CoroutineScope(JobKt.Job$default(null, 1, null).plus(Dispatchers.getMain()));
        this.b = new LinkedHashSet();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
        LazyThreadSafetyMode r5 = LazyThreadSafetyMode.NONE;
        this.f = LazyKt.lazy(r5, new ThreadReplyExposureView$avatarPlaceholderBitmap$2(r2, this));
        this.g = 20.0f;
        this.h = 14.0f;
        this.i = true;
        this.k = LazyKt.lazy(r5, new ThreadReplyExposureView$avatarSize$2(r2, this));
        this.l = LazyKt.lazy(r5, new ThreadReplyExposureView$replyMarginLeft$2(this));
        this.m = LazyKt.lazy(r5, ThreadReplyExposureView$spacingBetweenReplies$2.INSTANCE);
        this.n = LazyKt.lazy(r5, ThreadReplyExposureView$lineSpacing$2.INSTANCE);
        this.o = e.a;
        this.r = 5;
        this.t = true;
        this.u = new ArrayList();
        this.w = true;
        this.x = LazyKt.lazy(r5, new ThreadReplyExposureView$spannableStringArray$2(this));
        this.y = LazyKt.lazy(r5, new ThreadReplyExposureView$replyLayoutArray$2(this));
        this.z = LazyKt.lazy(r5, new ThreadReplyExposureView$replyNameSpan$2(this));
        this.A = LazyKt.lazy(r5, new ThreadReplyExposureView$replyPaint$2(r2, this));
        this.B = 23;
        this.E = new d(this);
    }

    public /* synthetic */ ThreadReplyExposureView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public static final Object b(ThreadReplyExposureView r5, String r6, String r7, Continuation r8) {
        r5.getClass();
        j r1 = new j(IntrinsicsKt.intercepted(r8), 1);
        r1.C();
        IRequestCreator r9 = ImageLoader.with(r5.getContext()).load(AvatarImage.Builder.obtain(r6, r7, r5.getAvatarSize(), r5.getAvatarSize()).build());
        Bitmap r10 = r9.asBitmap().fitCenter().transform(new RoundedCornersTransformation(r5.getAvatarSize() / 2, 0)).getBitmap(r5.getAvatarSize(), r5.getAvatarSize());     // Catch: Throwable -> L5
    L11:
        if (r1.isActive() == true) goto L13;
        Log.w("MessageThreadCellReplyView", "continuation is not active, just return");
    L16:
        Object r11 = r1.B();
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        DebugProbesKt.probeCoroutineSuspended(r8);
    L19:
        return r11;
    L13:
        if (r10 == null) goto L15;
        r1.resumeWith(Result.constructor-impl(r10));
        goto L16
    L15:
        Log.e("MessageThreadCellReplyView", "Avatar load successfully for key: " + r6 + " but bitmap is null, resume with exception");
        Result.Companion r12 = Result.Companion;
        r1.resumeWith(Result.constructor-impl(ResultKt.createFailure(new NullPointerException("Image load failed"))));
    L5:
        th = move-exception;
        Log.e("MessageThreadCellReplyView", "Avatar load failed for key " + r6 + ": " + th);
        if (r1.isActive() == false) goto L9;
        Result.Companion r13 = Result.Companion;
        r1.resumeWith(Result.constructor-impl(ResultKt.createFailure(th)));
    L9:
        r10 = null;
        goto L11
    }
}
