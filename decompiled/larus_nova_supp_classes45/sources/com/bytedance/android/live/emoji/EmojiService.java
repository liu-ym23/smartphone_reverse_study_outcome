package com.bytedance.android.live.emoji;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import com.bytedance.android.live.base.model.emoji.EmojiUriModel;
import com.bytedance.android.live.base.model.emoji.EmojiUriNode;
import com.bytedance.android.live.core.widget.GradientEditText;
import com.bytedance.android.live.emoji.adapter.EmojiPanelAdapter;
import com.bytedance.android.live.emoji.adapter.EmojiPanelWaterfallAdapter;
import com.bytedance.android.live.emoji.api.IAwemeEmojiProxy;
import com.bytedance.android.live.emoji.api.IEmojiService;
import com.bytedance.android.live.emoji.utils.b;
import com.bytedance.android.live.emoji.widget.EmojiEditView;
import com.bytedance.android.live.emoji.widget.EmojiSelectPanel;
import com.bytedance.android.live.emoji.widget.VSEmojiSelectPanel;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.chatroom.ui.RtlViewPagerShower;
import com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager;
import com.bytedance.android.livesdk.interactivity.api.expression.i;
import com.bytedance.android.livesdk.interactivity.api.expression.j;
import com.bytedance.android.livesdk.widget.board.e;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import db2.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import jc1.k;
import kotlin.collections.CollectionsKt;
import tb1.c;
import x90.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class EmojiService implements IEmojiService {
    @Override // com.bytedance.android.live.emoji.api.IEmojiService
    public List<BaseEmoji> getRecommendEmojiList() {
        b r0 = new b();
        int r3 = 0;
        List<BaseEmoji> r4 = null;
        if (c.a == true) goto L5;
    L15:
        if (r4 != null) goto L17;
        r4 = r0.a();
    L17:
        Iterator<T> r1 = r4.iterator();
    L19:
        if (r1.hasNext() == false) goto L24;
        Object r2 = r1.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L23;
        CollectionsKt.throwIndexOverflow();
    L23:
        BaseEmoji r6 = (BaseEmoji) r2;
        r6.isRecommendEmoji = true;
        r6.position = r3;
        r3 = r5;
        goto L19
    L24:
        return r4;
    L5:
        if (c.c == true) goto L15;
        IAwemeEmojiProxy r7 = (IAwemeEmojiProxy) k.f(IAwemeEmojiProxy.class);
        if (r7 == null) goto L9;
        r4 = r7.getRecommendEmojiList();
    L9:
        if (r4 == null) goto L15;
        if ((!r4.isEmpty()) != true) goto L15;
        if (r4.size() <= 8) goto L15;
        r4 = r4.subList(0, 8);
        goto L15
    }

    public EmojiService() {
        k.l(IEmojiService.class, this);
    }

    @Override // com.bytedance.android.live.emoji.api.IEmojiService
    public List<a> parseEmojiIndexList(CharSequence r2) {
        return r90.a.a().b.b(r2);
    }

    @Override // com.bytedance.android.live.emoji.api.IEmojiService
    public List<EmojiUriNode> parseEmojiUriList(CharSequence r2) {
        return r90.a.a().b.c(r2);
    }

    @Override // com.bytedance.android.live.emoji.api.IEmojiService
    public GradientEditText createEmojiEditText(Context r2, int r3) {
        EmojiEditView r0 = new EmojiEditView(r2);
        r0.setTextEmojiSize(r3);
        return r0;
    }

    @Override // com.bytedance.android.live.emoji.api.IEmojiService
    public String getStringForMaxLength(String r4, int r5) {
        Iterator<a> r0 = parseEmojiIndexList(r4).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        a r1 = r0.next();
        if (r1.c <= r5) goto L4;
        int r2 = r1.b;
        if (r5 < r2) goto L4;
        r5 = r2;
    L11:
        return r4.substring(0, Math.min(r5, r4.length()));
    }

    @Override // com.bytedance.android.live.emoji.api.IEmojiService
    public Spannable parseEmoji(Spannable r11, int r12) {
        Iterator r0 = ((ArrayList) r90.a.a().b.b(r11)).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        a r1 = (a) r0.next();
        Drawable r3 = r1.a;
        if (r3 == null) goto L4;
        s90.a.a(r11, r3, r1.b, r1.c, r12, r12, null);
        goto L4
    L9:
        return r11;
    }

    @Override // com.bytedance.android.live.emoji.api.IEmojiService
    public Spannable parseEmojiForMiniGame(Spannable r8, int r9) {
        Iterator r11 = ((ArrayList) r90.a.a().b.c(r8)).iterator();
    L4:
        if (r11.hasNext() == false) goto L31;
        EmojiUriNode r0 = (EmojiUriNode) r11.next();
        EmojiUriModel r1 = r0.getEmojiUri();
        if (r1 == null) goto L4;
        int r2 = r0.getStartIndex();
        int r3 = r0.getEndIndex();
        if (r8 == null) goto L4;
        if (r8.length() == 0) goto L4;
        if (r2 < 0) goto L4;
        if (r2 > r8.length()) goto L4;
        if (r2 > r3) goto L4;
        if (r3 > r8.length()) goto L4;
        if (r1.getLocalFilePath() == null) goto L25;
        if (r1.getLocalFilePath().startsWith("file://") == false) goto L25;
        String r4 = r1.getLocalFilePath();
    L28:
        if (r4 == null) goto L4;
        r8.setSpan(new ImageSpan(new ColorDrawable(), r4), r2, r3, 33);
    L25:
        if (r1.getIconId() <= 0) goto L27;
        r4 = String.format(Locale.CHINESE, "%s%d", new Object[]{"res://", Integer.valueOf(r1.getIconId())});
        goto L28
    L27:
        r4 = null;
        goto L28
    L31:
        return r8;
    }

    @Override // com.bytedance.android.live.emoji.api.IEmojiService
    public SpannableString parseEmojiV2(SpannableString r11, int r12) {
        r90.a.a().b.getClass();
        ArrayList r0 = new ArrayList();
        if (r11 != null) goto L5;
    L26:
        Iterator r1 = r0.iterator();
    L28:
        if (r1.hasNext() == false) goto L33;
        a r2 = (a) r1.next();
        Drawable r3 = r2.a;
        if (r3 == null) goto L28;
        s90.a.a(r11, r3, r2.b, r2.c, r12, r12, null);
        goto L28
    L33:
        return r11;
    L5:
        if (r11.length() < 3) goto L26;
        StringBuilder r4 = new StringBuilder();
        int r5 = 0;
        boolean r6 = false;
        int r7 = 0;
    L9:
        if (r5 >= r11.length()) goto L26;
        char r8 = r11.charAt(r5);
        if (r8 != '[') goto L14;
        r4.setLength(0);
        r4.append('[');
        r6 = true;
        r7 = r5;
    L25:
        r5 = r5 + 1;
        goto L9
    L14:
        if (r8 != ']') goto L23;
        if (r6 == false) goto L23;
        r4.append(']');
        if (k.f(IAwemeEmojiProxy.class) == null) goto L19;
        Drawable r9 = ((IAwemeEmojiProxy) k.f(IAwemeEmojiProxy.class)).getRealDrawable(r4.toString());
    L20:
        if (r9 == null) goto L22;
        r0.add(new a(r9, r7, r5 + 1));
    L22:
        r4.setLength(0);
        r6 = false;
        goto L25
    L19:
        r9 = null;
    L23:
        if (r6 == false) goto L25;
        r4.append(r8);
        goto L25
    }

    @Override // com.bytedance.android.live.emoji.api.IEmojiService
    public Spannable parseOnlyEmoji(Spannable r11, int r12) {
        List<a> r0 = r90.a.a().b.b(r11);
        int r1 = 0;
    L3:
        ArrayList r2 = (ArrayList) r0;
        if (r1 >= r2.size()) goto L13;
        Drawable r3 = ((a) ListProtector.get(r0, r1)).a;
        if (r3 == null) goto L12;
        if (r1 != (r2.size() - 1)) goto L11;
        s90.a.a(r11, r3, r1, r11.length(), r12, r12, null);
        goto L12
    L11:
        s90.a.a(r11, r3, r1, r1 + 1, r12, r12, null);
    L12:
        r1 = r1 + 1;
        goto L3
    L13:
        return r11;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, android.view.ViewGroup, com.bytedance.android.live.emoji.widget.EmojiSelectPanel, t90.a] */
    @Override // com.bytedance.android.live.emoji.api.IEmojiService
    public View createEmojiSelectPanel(Context r12, boolean r13, int r14, com.bytedance.android.livesdk.interactivity.api.expression.k r15) {
        ?? r0 = new EmojiSelectPanel(r12);
        r0.setOnEmojiSelectListener(r15);
        if (r13 == false) goto L5;
        int r16 = 3;
    L6:
        r0.h = r16;
        if (r13 == false) goto L9;
        int r17 = 6;
    L10:
        r0.i = r17;
        r0.j = r16 * r17;
        r0.k = r14;
        r0.a = r0.findViewById(2131378057);
        r0.c = r0.findViewById(2131381814);
        EmojiPanelAdapter r18 = new EmojiPanelAdapter(r0.getContext(), r0.h, r0.i, r0.k);
        r0.b = r18;
        r18.i = r0;
        r0.a.setAdapter(r18);
        int r19 = 0;
        r0.a.setLayoutManager(new SSGridLayoutManager(r0.getContext(), r0.h, 0));
        r0.a.setHasFixedSize(true);
        r0.a.setItemViewCacheSize(36);
        x90.b r110 = new x90.b(r0);
        r110.h(r0.h);
        r110.g(r0.i);
        r110.attachToRecyclerView(r0.a);
        r0.a.addOnScrollListener(new x90.c(r0));
        r0.c.setMargin((int) r0.getContext().getResources().getDimension(2131168969));
        RtlViewPagerShower r111 = r0.c;
        Drawable r112 = r0.getContext().getResources().getDrawable(2131250531);
        Drawable r1 = r0.getContext().getResources().getDrawable(2131250532);
        r111.c = r112;
        r111.d = r1;
        List<BaseEmoji> r113 = r90.a.a().b();
        if (Lists.isEmpty(r113) == true) goto L42;
        EmojiPanelAdapter r114 = r0.b;
        r114.getClass();
        if (Lists.isEmpty(r113) == false) goto L16;
        int r2 = 0;
    L21:
        int r3 = r114.f * r2;
        int r4 = 1;
    L22:
        if (r4 > r2) goto L27;
        int r5 = (r114.f * r4) - 1;
        if (r5 >= r113.size()) goto L26;
        ListProtector.add(r113, r5, new v90.a(r114.h));
    L26:
        r4 = r4 + 1;
        goto L22
    L27:
        BaseEmoji[] r6 = new BaseEmoji[r3];
        int r7 = 0;
    L28:
        if (r7 >= r3) goto L30;
        r6[r7] = new v90.b();
        r7 = r7 + 1;
        goto L28
    L30:
        Iterator<BaseEmoji> r8 = r113.iterator();
    L32:
        if (r8.hasNext() == false) goto L37;
        BaseEmoji r9 = r8.next();
        int r11 = r114.d;
        int r21 = r114.e;
        int r22 = r114.f;
        int r23 = r19 % r22;
        int r115 = ((r23 / r21) + 1) - 1;
        int r24 = ((r11 * (r23 - (r21 * r115))) + r115) + ((r19 / r22) * r22);
        r19 = r19 + 1;
        if (r24 >= r3) goto L32;
        r6[r24] = r9;
        goto L32
    L37:
        r6[r3 - 1] = new v90.a(r114.h);
        List r116 = Arrays.asList(r6);
        ((ArrayList) r114.c).clear();
        if (r116 == null) goto L41;
        ((ArrayList) r114.c).addAll(r116);
    L41:
        r0.b.notifyDataSetChanged();
        int r117 = (r113.size() / r0.j) + 1;
        r0.g = r117;
        r0.c.a(r117, r0.e);
        goto L42
    L16:
        int r25 = r113.size() / (r114.f - 1);
        if ((r113.size() % (r114.f - 1)) <= 0) goto L19;
        int r26 = 1;
    L20:
        r2 = r25 + r26;
        goto L21
    L19:
        r26 = 0;
    L42:
        return r0;
    L9:
        r17 = 12;
        goto L10
    L5:
        r16 = 2;
        goto L6
    }

    @Override // com.bytedance.android.live.emoji.api.IEmojiService
    public SpannableString parseEmojiWithFontSize(Context r1, CharSequence r2, float r3, boolean r4) {
        return r90.a.a().c(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.emoji.api.IEmojiService
    public View createNewEmojiSelectPanel(Context r2, boolean r3, int r4, i r5, j r6) {
        e r0 = new e(r2, r4, r3, r5);
        r0.setOnCommentSendDelegate(r6);
        return r0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, android.view.ViewGroup, androidx.constraintlayout.widget.ConstraintLayout, com.bytedance.android.live.emoji.widget.VSEmojiSelectPanel, t90.a] */
    @Override // com.bytedance.android.live.emoji.api.IEmojiService
    public View createVSEmojiSelectPanel(Context r2, boolean r3, int r4, int r5, com.bytedance.android.livesdk.interactivity.api.expression.k r6) {
        final ?? r0 = new VSEmojiSelectPanel(r2, r5);
        r0.setOnEmojiSelectListener(r6);
        if (r3 == false) goto L5;
        int r7 = 7;
    L6:
        r0.f = r7;
        r0.g = r4;
        r0.a = r0.findViewById(2131378057);
        r0.b = r0.findViewById(2131371524);
        r0.d = r0.findViewById(2131371523);
        r0.b.setOnClickListener(new d(r0));
        if (r0.h > 0) goto L9;
    L11:
        GridLayoutManager r8 = new GridLayoutManager(r0.getContext(), r0.f, 1, false);
        r0.a.setLayoutManager(r8);
        r0.a.setHasFixedSize(true);
        r0.a.setItemViewCacheSize(36);
        EmojiPanelWaterfallAdapter r9 = new EmojiPanelWaterfallAdapter(r0.getContext(), r0.f, r0.g);
        r0.c = r9;
        r9.d = LayoutInflater.from(r0.getContext()).inflate(2131566341, null);
        r9.notifyDataSetChanged();
        EmojiPanelWaterfallAdapter r11 = r0.c;
        r11.g = r0;
        r0.a.setAdapter(r11);
        List<BaseEmoji> r12 = r90.a.a().b();
        if (Lists.isEmpty(r12) == true) goto L15;
        ((ArrayList) r0.c.c).addAll(r12);
        r0.c.notifyDataSetChanged();
    L15:
        return r0;
    L9:
        if (r0.d == null) goto L11;
        ConstraintLayout.LayoutParams r13 = new ConstraintLayout.LayoutParams(-1, r0.h);
        ((ViewGroup.MarginLayoutParams) r13).height = r0.h;
        r0.setLayoutParams(r13);
        r0.requestLayout();
        r0.d.setLayoutParams(r13);
        r0.d.requestLayout();
        goto L11
    L5:
        r7 = 11;
        goto L6
    }
}
