package com.ss.android.lark.picker.base.utils;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.SearchResultView;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.y0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import y9c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0015\u0018\u0000 52\u00020\u0001:\u000256B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001bJ\u0018\u0010$\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001e\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\rJ#\u0010)\u001a\u00020\"2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010,J\u000e\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u001eJ\u000e\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u00020 J \u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\u000fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/ss/android/lark/picker/base/utils/EmptyViewManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "mSearchResultEmptyView", "Landroid/view/View;", "mSearchEmptyHintText", "Landroid/widget/TextView;", "mSearchEmptyHintImage", "Landroid/widget/ImageView;", "customEmptyIconResId", "", "Ljava/lang/Integer;", "customEmptyHintText", "", "emptyType", "getEmptyType", "()I", "setEmptyType", "(I)V", "mQueryWidth", "", "mOriginText", "", "mStartIndex", "mOnClickEmptyView", "Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnClickEmptyView;", "mColdAndHotClickListener", "Lcom/ss/android/lark/picker/base/utils/EmptyViewManager$IEmptyViewColdAndHotListener;", "updateSearchResultViewEmptyView", "", AppbrandHostConstants.Schema_RESERVED_FIELD.QUERY, "attachEmptyText", "setEmptyView", "emptyView", "emptyHintText", "emptyHintImage", "setCustomEmptyView", "iconResId", "hintText", "(Ljava/lang/Integer;Ljava/lang/CharSequence;)V", "setOnClickEmptyView", "onClickEmptyView", "setEmptyViewColdAndHotListener", "coldAndHotClickListener", "addClickableSpan", "text", "startIndex", "endIndex", "Companion", "IEmptyViewColdAndHotListener", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class EmptyViewManager {
    public static final Companion Companion = null;
    public static final String LOAD_EARLIER = "LoadEarlier";
    public static final String TAG = "EmptyViewManager";
    public static final String VIEW_EARLIER = "ViewEarlier";
    private final Context context;
    private CharSequence customEmptyHintText;
    private Integer customEmptyIconResId;
    private int emptyType;
    private IEmptyViewColdAndHotListener mColdAndHotClickListener;
    private SearchResultView.IOnClickEmptyView mOnClickEmptyView;
    private String mOriginText;
    private float mQueryWidth;
    private ImageView mSearchEmptyHintImage;
    private TextView mSearchEmptyHintText;
    private View mSearchResultEmptyView;
    private int mStartIndex;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/base/utils/EmptyViewManager$Companion;", "", "<init>", "()V", "VIEW_EARLIER", "", "LOAD_EARLIER", "TAG", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/picker/base/utils/EmptyViewManager$IEmptyViewColdAndHotListener;", "", "onLoadCold", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public interface IEmptyViewColdAndHotListener {
        void onLoadCold();
    }

    static {
        Companion = new Companion(null);
    }

    public final Context getContext() {
        return this.context;
    }

    public final int getEmptyType() {
        return this.emptyType;
    }

    public EmptyViewManager(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.context = r2;
        this.mOriginText = r2.getResources().getString(2131892028);
        this.mStartIndex = -1;
    }

    public static final /* synthetic */ IEmptyViewColdAndHotListener access$getMColdAndHotClickListener$p(EmptyViewManager r0) {
        return r0.mColdAndHotClickListener;
    }

    public static final /* synthetic */ SearchResultView.IOnClickEmptyView access$getMOnClickEmptyView$p(EmptyViewManager r0) {
        return r0.mOnClickEmptyView;
    }

    public static final /* synthetic */ String access$getMOriginText$p(EmptyViewManager r0) {
        return r0.mOriginText;
    }

    public static final /* synthetic */ TextView access$getMSearchEmptyHintText$p(EmptyViewManager r0) {
        return r0.mSearchEmptyHintText;
    }

    public static final /* synthetic */ int access$getMStartIndex$p(EmptyViewManager r0) {
        return r0.mStartIndex;
    }

    public final void setEmptyType(int r1) {
        this.emptyType = r1;
    }

    public final void setEmptyViewColdAndHotListener(IEmptyViewColdAndHotListener r2) {
        Intrinsics.checkNotNullParameter(r2, "coldAndHotClickListener");
        this.mColdAndHotClickListener = r2;
    }

    public final void setOnClickEmptyView(SearchResultView.IOnClickEmptyView r2) {
        Intrinsics.checkNotNullParameter(r2, "onClickEmptyView");
        this.mOnClickEmptyView = r2;
    }

    public final void updateSearchResultViewEmptyView(final String r14) {
        Intrinsics.checkNotNullParameter(r14, AppbrandHostConstants.Schema_RESERVED_FIELD.QUERY);
        CharSequence r0 = this.customEmptyHintText;
        View r6 = null;
        if (r0 == null) goto L17;
        TextView r15 = this.mSearchEmptyHintText;
        if (r15 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintText");
        r15 = null;
    L7:
        r15.setText(r0);
        ImageView r16 = this.mSearchEmptyHintImage;
        if (r16 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintImage");
        r16 = null;
    L10:
        r16.setVisibility(8);
        View r17 = this.mSearchResultEmptyView;
        if (r17 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultEmptyView");
    L14:
        d.l(r6, false);
        return;
    L13:
        r6 = r17;
        goto L14
    L17:
        if (this.emptyType != 4) goto L25;
        ImageView r18 = this.mSearchEmptyHintImage;
        if (r18 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintImage");
        r18 = null;
    L21:
        r18.setImageResource(2131238156);
        String r19 = this.context.getResources().getString(2131892623);
        String r1 = this.context.getResources().getString(2131892624);
        int r7 = StringsKt.indexOf$default(r19, "{", 0, false, 6, null);
        int r8 = r1.length() + r7;
        CharSequence r110 = y0.b(UIHelper.mustacheFormat(r19, VIEW_EARLIER, r1), r7, r8, r1, UIHelper.getColor(2131103404));
        Intrinsics.checkNotNull(r110);
        CharSequence r111 = addClickableSpan(r110, r7, r8);
        TextView r2 = this.mSearchEmptyHintText;
        if (r2 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintText");
        r2 = null;
    L24:
        r2.setText(r111);
    L50:
        Integer r112 = this.customEmptyIconResId;
        if (r112 == null) goto L74;
        int r113 = r112.intValue();
        if (r113 > 0) goto L61;
        ImageView r114 = this.mSearchEmptyHintImage;
        if (r114 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintImage");
        r114 = null;
    L57:
        r114.setImageResource(0);
        ImageView r115 = this.mSearchEmptyHintImage;
        if (r115 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintImage");
        r115 = null;
    L60:
        r115.setVisibility(8);
    L68:
        View r116 = this.mSearchResultEmptyView;
        if (r116 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultEmptyView");
    L72:
        d.l(r6, false);
        return;
    L71:
        r6 = r116;
        goto L72
    L61:
        ImageView r3 = this.mSearchEmptyHintImage;
        if (r3 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintImage");
        r3 = null;
    L64:
        r3.setImageResource(r113);
        ImageView r117 = this.mSearchEmptyHintImage;
        if (r117 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintImage");
        r117 = null;
    L67:
        r117.setVisibility(0);
        goto L68
    L74:
        View r118 = this.mSearchResultEmptyView;
        if (r118 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultEmptyView");
    L78:
        d.k(r6);
        return;
    L77:
        r6 = r118;
        goto L78
    L25:
        ImageView r4 = this.mSearchEmptyHintImage;
        if (r4 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintImage");
        r4 = null;
    L28:
        r4.setVisibility(0);
        ImageView r5 = this.mSearchEmptyHintImage;
        if (r5 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintImage");
        r5 = null;
    L31:
        r5.setImageResource(2131238205);
        if (StringsKt.isBlank(r14) == false) goto L38;
        TextView r119 = this.mSearchEmptyHintText;
        if (r119 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintText");
        r119 = null;
    L36:
        r119.setText(this.context.getResources().getText(2131892162));
        goto L50
    L38:
        if (this.mQueryWidth != 0.0f) goto L40;
        boolean r9 = true;
    L41:
        if (r9 == false) goto L46;
        TextView r10 = this.mSearchEmptyHintText;
        if (r10 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintText");
        r10 = null;
    L45:
        r10.post(new AnonymousClass2(this, r14));
        goto L50
    L46:
        TextView r11 = this.mSearchEmptyHintText;
        if (r11 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintText");
        r11 = null;
    L49:
        attachEmptyText(r14, r11);
        goto L50
    L40:
        r9 = false;
        goto L41
    }

    public static final /* synthetic */ void access$setMQueryWidth$p(EmptyViewManager r0, float r1) {
        r0.mQueryWidth = r1;
    }

    public static final /* synthetic */ void access$setMStartIndex$p(EmptyViewManager r0, int r1) {
        r0.mStartIndex = r1;
    }

    private final void attachEmptyText(String r5, TextView r6) {
        String r7 = TextUtils.ellipsize(r5, r6.getPaint(), this.mQueryWidth, TextUtils.TruncateAt.MIDDLE).toString();
        String r0 = UIHelper.mustacheFormat(this.mOriginText, "search_key", r7);
        int r1 = this.mStartIndex;
        if (r1 == (-1)) goto L5;
        int r2 = r1 + r7.length();
        CharSequence r8 = y0.b(r0, this.mStartIndex, r2, r7, UIHelper.getColor(2131103404));
        Intrinsics.checkNotNull(r8);
        r6.setText(addClickableSpan(r8, this.mStartIndex, r2));
        return;
    L5:
        r6.setText(r0);
    }

    public final void setCustomEmptyView(Integer r4, CharSequence r5) {
        this.customEmptyIconResId = r4;
        this.customEmptyHintText = r5;
        TextView r0 = null;
    L13:
        th = move-exception;
        Log.e(TAG, "setCustomEmptyView iconResId error", th);
    L15:
        TextView r6 = this.mSearchEmptyHintText;
        if (r6 == null) goto L25;
        if (r5 == null) goto L26;
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintText");
    L21:
        r0.setText(r5);
        return;
    L20:
        r0 = r6;
        goto L21
    L26:
        return;
    L25:
        return;
    L4:
        if (this.mSearchEmptyHintImage == null) goto L15;
        if (r4 == null) goto L15;
        if (r4.intValue() < 0) goto L15;
        ImageView r1 = this.mSearchEmptyHintImage;     // Catch: Throwable -> L13
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintImage");     // Catch: Throwable -> L13
        r1 = null;
    L11:
        r1.setImageResource(r4.intValue());     // Catch: Throwable -> L13
        goto L15
    }

    public static final /* synthetic */ void access$attachEmptyText(EmptyViewManager r0, String r1, TextView r2) {
        r0.attachEmptyText(r1, r2);
    }

    private final CharSequence addClickableSpan(CharSequence r3, int r4, int r5) {
        SpannableStringBuilder r0 = new SpannableStringBuilder(r3);
        r0.setSpan(new AnonymousClass1(this), r4, r5, 33);
        TextView r6 = this.mSearchEmptyHintText;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintText");
        r6 = null;
    L5:
        r6.setMovementMethod(LinkMovementMethod.getInstance());
        return r0;
    }

    public final void setEmptyView(View r2, TextView r3, ImageView r4) {
        Intrinsics.checkNotNullParameter(r2, "emptyView");
        Intrinsics.checkNotNullParameter(r3, "emptyHintText");
        Intrinsics.checkNotNullParameter(r4, "emptyHintImage");
        this.mSearchResultEmptyView = r2;
        this.mSearchEmptyHintText = r3;
        this.mSearchEmptyHintImage = r4;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultEmptyView");
        r2 = null;
    L5:
        r2.setOnClickListener(new ViewOnClickListenerC03251(this));
    }

    public static /* synthetic */ void setCustomEmptyView$default(EmptyViewManager r1, Integer r2, CharSequence r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        r1.setCustomEmptyView(r2, r3);
    }
}
