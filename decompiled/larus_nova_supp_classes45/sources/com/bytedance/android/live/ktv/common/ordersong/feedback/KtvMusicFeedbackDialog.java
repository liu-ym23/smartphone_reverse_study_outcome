package com.bytedance.android.live.ktv.common.ordersong.feedback;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.ktv.common.view.BaseKtvDialogFragment;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/ktv/common/ordersong/feedback/KtvMusicFeedbackDialog;", "Lcom/bytedance/android/live/ktv/common/view/BaseKtvDialogFragment;", "<init>", "()V", "a", "FeedbackType", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvMusicFeedbackDialog extends BaseKtvDialogFragment {
    public static final /* synthetic */ int o = 0;
    public Map<Integer, View> g;
    public int h;
    public String i;
    public boolean j;
    public p k;
    public FeedbackType l;
    public com.bytedance.android.live.ktv.common.ordersong.feedback.a m;
    public final b n;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/ktv/common/ordersong/feedback/KtvMusicFeedbackDialog$FeedbackType;", "", "", "thirdParty", "Ljava/lang/String;", "getThirdParty", "()Ljava/lang/String;", "", "scene", "I", "getScene", "()I", "KSONG_SONG_INFO", "PERSONAL_KARAOKE", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum FeedbackType extends Enum<FeedbackType> {
        public static final FeedbackType KSONG_SONG_INFO = null;
        public static final FeedbackType PERSONAL_KARAOKE = null;
        public static final /* synthetic */ FeedbackType[] a = null;
        private final int scene;
        private final String thirdParty;

        static {
            FeedbackType r1 = new FeedbackType("KSONG_SONG_INFO", 0, "ksong_song_info");
            KSONG_SONG_INFO = r1;
            FeedbackType r2 = new FeedbackType("PERSONAL_KARAOKE", 1, "personal_karaoke");
            PERSONAL_KARAOKE = r2;
            a = new FeedbackType[]{r1, r2};
        }

        public static FeedbackType valueOf(String r1) {
            return (FeedbackType) r27.a.a(FeedbackType.class, r1);
        }

        public static FeedbackType[] values() {
            return (FeedbackType[]) a.clone();
        }

        public final int getScene() {
            return this.scene;
        }

        public final String getThirdParty() {
            return this.thirdParty;
        }

        public FeedbackType(String r1, int r2, String r3) {
            super(r1, r2);
            this.thirdParty = r3;
            this.scene = 0;
        }
    }

    public static final class a {
        public a() {
        }

        public static /* synthetic */ KtvMusicFeedbackDialog b(FeedbackType r2, com.bytedance.android.live.ktv.common.ordersong.feedback.a r3, String r4) {
            return a(r2, r3, r4, s1.f(484.0f), Boolean.FALSE);
        }

        public static KtvMusicFeedbackDialog a(FeedbackType r1, com.bytedance.android.live.ktv.common.ordersong.feedback.a r2, String r3, int r4, Boolean r5) {
            Intrinsics.checkNotNullParameter(r1, "type");
            Intrinsics.checkNotNullParameter(r2, "predicateContent");
            Intrinsics.checkNotNullParameter(r3, "requestPage");
            KtvMusicFeedbackDialog r0 = new KtvMusicFeedbackDialog();
            r0.l = r1;
            r0.m = r2;
            r0.i = r3;
            r0.h = r4;
            if (r5 == null) goto L5;
            boolean r6 = r5.booleanValue();
        L6:
            r0.j = r6;
            return r0;
        L5:
            r6 = false;
            goto L6
        }
    }

    public static final class b implements TextWatcher {
        public final /* synthetic */ KtvMusicFeedbackDialog a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public b(KtvMusicFeedbackDialog r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r2) {
            KtvMusicFeedbackDialog r3 = this.a;
            int r0 = KtvMusicFeedbackDialog.o;
            r3.Y90();
        }
    }

    static {
        new a();
    }

    @Override // com.bytedance.android.live.ktv.common.view.BaseKtvDialogFragment
    public final String S90() {
        return "KtvMusicFeedbackDialog";
    }

    @Override // com.bytedance.android.live.ktv.common.view.BaseKtvDialogFragment
    public final int getLayoutId() {
        if (this.j == false) goto L6;
        return 2131565575;
    L6:
        return KtvOrderSongThemeManager.a(400);
    }

    public final void onDestroyView() {
        p r0 = this.k;
        if (r0 == null) goto L5;
        r0.a.clear();
    L5:
        super.onDestroyView();
        ((LinkedHashMap) this.g).clear();
    }

    public KtvMusicFeedbackDialog() {
        this.g = new LinkedHashMap();
        this.h = s1.f(484.0f);
        this.i = "";
        this.l = FeedbackType.KSONG_SONG_INFO;
        this.m = new com.bytedance.android.live.ktv.common.ordersong.feedback.a("", "");
        this.n = new b(this);
    }

    public final void Y90() {
        TextView r1 = (TextView) X90(2131376987);
        if (Z90() == true) goto L5;
    L7:
        float r2 = 0.5f;
    L8:
        r1.setAlpha(r2);
        ((TextView) X90(2131376987)).setOnClickListener(x0.a(new KtvMusicFeedbackDialog$checkSubmitEnable$1(this)));
        return;
    L5:
        if ((!((KtvFeedbackComponentView) X90(2131372271)).getSelectedSet().isEmpty()) == false) goto L7;
        r2 = 1.0f;
        goto L8
    }

    public final boolean Z90() {
        Editable r0 = ((EditText) X90(2131380500)).getText();
        if (r0 == null) goto L5;
        String r1 = r0.toString();
    L7:
        if (r1 != null) goto L9;
    L12:
        boolean r2 = true;
    L14:
        return !r2;
    L9:
        if (r1.length() == 0) goto L12;
        r2 = false;
        goto L14
    L5:
        r1 = null;
        goto L7
    }

    public final View X90(int r3) {
        if (this.g != null) goto L5;
        this.g = new LinkedHashMap();
    L5:
        View r0 = this.g.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.g.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    @Override // com.bytedance.android.live.ktv.common.view.BaseKtvDialogFragment
    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        if (this.h != (-1)) goto L10;
        Dialog r4 = getDialog();
        if (r4 == null) goto L11;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L12;
        WindowManager.LayoutParams r1 = r5.getAttributes();
        r1.height = -1;
        r5.setAttributes(r1);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final Dialog onCreateDialog(Bundle r3) {
        Dialog r4 = super.onCreateDialog(r3);
        Window r0 = r4.getWindow();
        if (r0 == null) goto L5;
        r0.setSoftInputMode(32);
    L5:
        return r4;
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        ((EditText) X90(2131380500)).setText(this.m.a);
        ((EditText) X90(2131380518)).setText(this.m.b);
        ((EditText) X90(2131380500)).addTextChangedListener(this.n);
        ((EditText) X90(2131380500)).setCursorVisible(false);
        ((EditText) X90(2131380518)).setCursorVisible(false);
        ((EditText) X90(2131380500)).setOnTouchListener(new j(this));
        ((EditText) X90(2131380518)).setOnTouchListener(new k(this));
        ((EditText) X90(2131380500)).setOnEditorActionListener(l.a);
        ((EditText) X90(2131380518)).setOnEditorActionListener(m.a);
        X90(2131376938).setOnClickListener(new n(this));
        ((KtvFeedbackComponentView) X90(2131372271)).setOnIssueSelectListener(new KtvMusicFeedbackDialog$initView$6(this));
        Y90();
        X90(2131367001).setOnClickListener(new o(this));
        View r5 = this.f;
        ScrollView r6 = null;
        if (r5 == null) goto L5;
        LinearLayout r7 = (LinearLayout) r5.findViewById(2131367836);
    L6:
        if (r7 == null) goto L8;
        a1.k(r7, this.h);
    L8:
        View r8 = this.f;
        if (r8 == null) goto L12;
        r6 = (ScrollView) r8.findViewById(2131379438);
    L12:
        if (this.h != (-1)) goto L15;
        if (r6 == null) goto L15;
        a1.k(r6, -2);
    L15:
        p r9 = new p();
        this.k = r9;
        NextLiveData<List<com.bytedance.android.livesdk.rank.model.b>> r11 = r9.b;
        if (r11 == null) goto L18;
        r11.observe(this, new h(this));
    L18:
        p r12 = this.k;
        if (r12 == null) goto L23;
        NextLiveData<Boolean> r13 = r12.c;
        if (r13 == null) goto L23;
        r13.observe(this, new i(this));
    L23:
        p r14 = this.k;
        if (r14 == null) goto L26;
        r14.b(this.l.getScene(), this.l.getThirdParty());
    L26:
        String r15 = this.i;
        pb0.a r16 = pb0.b.a;
        Intrinsics.checkNotNullParameter(r15, "requestPage");
        pb0.a r17 = pb0.b.a;
        if (r17 == null) goto L30;
        r17.u(r15);
        return;
    L30:
        return;
    L5:
        r7 = null;
        goto L6
    }
}
