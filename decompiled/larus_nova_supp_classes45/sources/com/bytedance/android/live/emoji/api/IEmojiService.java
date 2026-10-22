package com.bytedance.android.live.emoji.api;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.emoji.EmojiUriNode;
import com.bytedance.android.live.core.widget.GradientEditText;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.interactivity.api.expression.i;
import com.bytedance.android.livesdk.interactivity.api.expression.j;
import com.bytedance.android.livesdk.interactivity.api.expression.k;
import db2.a;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface IEmojiService extends IService {
    GradientEditText createEmojiEditText(Context r1, int r2);

    View createEmojiSelectPanel(Context r1, boolean r2, int r3, k r4);

    View createNewEmojiSelectPanel(Context r1, boolean r2, int r3, i r4, j r5);

    View createVSEmojiSelectPanel(Context r1, boolean r2, int r3, int r4, k r5);

    List<BaseEmoji> getRecommendEmojiList();

    String getStringForMaxLength(String r1, int r2);

    /* synthetic */ Spannable parseEmoji(Spannable r1, int r2);

    Spannable parseEmojiForMiniGame(Spannable r1, int r2);

    List<a> parseEmojiIndexList(CharSequence r1);

    List<EmojiUriNode> parseEmojiUriList(CharSequence r1);

    SpannableString parseEmojiV2(SpannableString r1, int r2);

    SpannableString parseEmojiWithFontSize(Context r1, CharSequence r2, float r3, boolean r4);

    Spannable parseOnlyEmoji(Spannable r1, int r2);
}
