package com.bytedance.android.live.search.impl.search;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.search.impl.search.model.LiveSearchResultParam;
import com.bytedance.android.live.search.impl.search.viewmodel.LiveSearchIntermediateViewModel;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p implements TextView.OnEditorActionListener {
    public final /* synthetic */ LiveSearchResultFragment a;

    public p(LiveSearchResultFragment r1) {
        this.a = r1;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r5, int r6, KeyEvent r7) {
        if (r6 != 3) goto L47;
        EditText r8 = this.a.g;
        String r9 = null;
        if (r8 == null) goto L9;
        Editable r10 = r8.getText();
        if (r10 == null) goto L9;
        String r12 = r10.toString();
    L10:
        boolean r1 = false;
        if (TextUtils.isEmpty(r12) == true) goto L13;
    L43:
        String r13 = "normal_search";
    L44:
        LiveSearchResultParam r0 = new LiveSearchResultParam();
        r0.setKeyword(r12);
        r0.setEnterMethod(r13);
        r0.setHintSearch(r1);
        LiveSearchIntermediateViewModel r14 = this.a.p;
        if (r14 == null) goto L47;
        r14.openSearch(r0);
        goto L47
    L13:
        if (LiveSearchResultFragment.x <= 0) goto L43;
        EditText r2 = this.a.g;
        if (r2 == null) goto L17;
        CharSequence r3 = r2.getHint();
    L19:
        if (TextUtils.isEmpty(r3) == true) goto L43;
        EditText r15 = this.a.g;
        if (r15 == null) goto L23;
        r15.setText(r15.getHint());
    L23:
        EditText r16 = this.a.g;
        if (r16 == null) goto L30;
        CharSequence r4 = r16.getHint();
        if (r4 == null) goto L28;
        int r17 = r4.length();
    L29:
        r16.setSelection(r17);
        goto L30
    L28:
        r17 = 0;
    L30:
        EditText r18 = this.a.g;
        if (r18 == null) goto L36;
        CharSequence r19 = r18.getHint();
        if (r19 == null) goto L36;
        r12 = r19.toString();
        if (r12 == null) goto L36;
    L37:
        int r20 = g.a;
        EditText r22 = this.a.g;
        if (r22 == null) goto L42;
        CharSequence r23 = r22.getHint();
        if (r23 == null) goto L42;
        r9 = r23.toString();
    L42:
        Intrinsics.checkNotNull(r9);
        Intrinsics.checkNotNullParameter(r9, "keyword");
        HashMap r24 = new HashMap();
        r24.put("words_content", r9);
        r24.put("word_position", DataType.FALSE);
        r24.put("search_position", "live_square");
        r24.put("word_source", "search_bar_inner");
        r24.put("group_id", "");
        r24.put("impr_id", "");
        com.bytedance.android.livesdk.log.u.l().e("trending_words_click", r24, new Object[0]);
        r13 = "default_search_keyword";
        r1 = true;
    L36:
        r12 = "";
        goto L37
    L17:
        r3 = null;
    L9:
        r12 = null;
    L47:
        return true;
    }
}
