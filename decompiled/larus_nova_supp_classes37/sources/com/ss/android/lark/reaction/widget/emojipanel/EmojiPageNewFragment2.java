package com.ss.android.lark.reaction.widget.emojipanel;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.CallbackManager;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.newemoji.emoji_list.EmojiListView;
import com.ss.android.lark.newemoji.emoji_list.adapter.EmojiListAdapter;
import com.ss.android.lark.newemoji.emoji_list.adapter.f;
import com.ss.android.lark.newemoji.emoji_panel.DefaultEmojiPanelData;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.UIHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import qsb.i;
import s5c.d;
import z5c.n3;
import z5c.z2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u008f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b)*\u00013\b\u0016\u0018\u0000 a2\u00020\u0001:\u0001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010!\u001a\u0004\u0018\u00010\b2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020-H\u0014J\u001a\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u00101\u001a\u00020/H\u0014J\b\u00108\u001a\u000209H\u0002J\u000e\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u000209J\b\u0010<\u001a\u000209H\u0002J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010>\u001a\u000209J\n\u0010?\u001a\u0004\u0018\u00010\u0011H\u0002J\u000e\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\u0011J\u0010\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001bH\u0002J\u0014\u0010C\u001a\u00020\u00002\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00110\u001bJ\n\u0010E\u001a\u0004\u0018\u00010\u0011H\u0002J\u000e\u0010F\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\u0011J\b\u0010G\u001a\u000209H\u0002J\u000e\u0010H\u001a\u00020\u00002\u0006\u0010I\u001a\u000209J\b\u0010J\u001a\u000209H\u0002J\u000e\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u000209J\b\u0010M\u001a\u000209H\u0002J\u000e\u0010N\u001a\u00020\u00002\u0006\u0010O\u001a\u000209J\u0010\u0010P\u001a\u00020\u00002\b\u0010Q\u001a\u0004\u0018\u00010\u0006J\b\u0010R\u001a\u00020/H\u0002J\u0006\u0010S\u001a\u00020/J\b\u0010T\u001a\u00020/H\u0002J\b\u0010U\u001a\u00020/H\u0002J\b\u0010V\u001a\u00020/H\u0002J\b\u0010W\u001a\u00020/H\u0016J\b\u0010X\u001a\u00020/H\u0002J\b\u0010Y\u001a\u00020/H\u0002J\u000e\u0010\u000e\u001a\u00020/2\u0006\u0010Z\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020/2\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010[\u001a\u00020'H\u0002J\u0010\u0010\\\u001a\u00020/2\u0006\u0010]\u001a\u00020'H\u0002J\b\u0010^\u001a\u00020\u000fH\u0002J\b\u0010_\u001a\u00020\rH\u0014J\b\u0010`\u001a\u00020\rH\u0014R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00102\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b4\u00105¨\u0006b"}, d2 = {"Lcom/ss/android/lark/reaction/widget/emojipanel/EmojiPageNewFragment2;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "refListener", "Ljava/lang/ref/WeakReference;", "Lcom/ss/android/lark/reaction/widget/emojipanel/OnEmojiOperationListener;", "deleteView", "Landroid/view/View;", "rootView", "contentView", "Lcom/ss/android/lark/newemoji/emoji_list/EmojiListView;", "defaultColumn", "", "emojiScene", "Lcom/ss/android/lark/statistics/extensions/IParam;", "chatId", "", "rootWidth", "showColumn", "emojiContainerWidth", "emojiLeftMargin", "rvLeftPadding", "rvRightPadding", "localCallbackManager", "Lcom/larksuite/framework/callback/CallbackManager;", "mruEmojis", "", "Lcom/ss/android/lark/newemoji/larkemoji/LarkEmoji;", "emojiPanelData", "Lcom/ss/android/lark/newemoji/emoji_panel/DefaultEmojiPanelData;", "rootViewTreeObserver", "Landroid/view/ViewTreeObserver;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "createRootView", "context", "Landroid/content/Context;", "createDeleteIcon", "parent", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onViewCreated", "", "view", "notifyEmojiView", "globalLayoutListener", "com/ss/android/lark/reaction/widget/emojipanel/EmojiPageNewFragment2$globalLayoutListener$2$1", "getGlobalLayoutListener", "()Lcom/ss/android/lark/reaction/widget/emojipanel/EmojiPageNewFragment2$globalLayoutListener$2$1;", "globalLayoutListener$delegate", "Lkotlin/Lazy;", "isEnableEmojiSkinTone", "", "setEnableEmojiSkinTone", "enableEmojiSkinTones", "isEnableRecentUsed", "setEnableRecentUsed", "enableRecentUse", "getRecentTitle", "setRecentTitle", "title", "getRecentEmojis", "setRecentEmojis", "emojis", "getDefaultTitle", "setDefaultTitle", "isDeleteIconEnable", "setDeleteIconEnable", "enable", "isEnableCustomEmoji", "setEnableCustomEmoji", "value", "isShowOnDialog", "setShowOnDialog", "showOnDialog", "setOnOperationListener", "onOperationListener", "bindView", "initList", "setEmojiListData", "compute", "initListener", "onDestroyView", "resetEmojiParams", "unRegisterListener", "scene", "getArgumentsNotNull", "setArgumentsSafely", "bundle", "getHaveOrganizationEmojis", "getFirstEmojiCenterToParent", "getEmojiHeight", "Companion", "reaction-component_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public class EmojiPageNewFragment2 extends BaseFragment {
    public WeakReference<c> d;
    public View e;
    public EmojiListView f;
    public final int g;
    public d h;
    public String i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public final CallbackManager p;
    public List<? extends com.ss.android.lark.newemoji.larkemoji.a> q;
    public DefaultEmojiPanelData r;
    public ViewTreeObserver s;
    public final Lazy t;

    public static final class a {
    }

    static {
    }

    public final void S90() {
        Log.i("EmojiPageNewFragment2", "bindView");
        if (this.k != 0) goto L6;
        T90();
    L6:
        if (isActive() == true) goto L9;
        Log.w("EmojiPageNewFragment2", "bindView cancel because not active");
        return;
    L9:
        int r0 = this.j;
        if (r0 > 0) goto L13;
        Log.w("EmojiPageNewFragment2", "bindView cancel because rootWidth <= 0");
        return;
    L13:
        int r6 = W90();
        int r4 = r6 + (i.a(8, UIHelper.getContext()) * 2);
        int r7 = (r0 - this.n) - this.o;
        Log.i("EmojiPageNewFragment2", "bindView, bind_view_window_width: " + r0);
        ssb.a r1 = new ssb.a(this.l, r4, this.m, r6, r7, this.n, this.o, this.k);
        EmojiListView r2 = this.f;
        if (r2 == null) goto L16;
        r2.d(r1);
        r2.setShowOnDialog(V90().getBoolean("SHOW_ON_DIALOG", false));
    L16:
        Log.i("EmojiPageNewFragment2", "bindView, item_params: " + r1);
    }

    public final void T90() {
        Log.i("EmojiPageNewFragment2", "compute");
        if (this.l == 0) goto L6;
        return;
    L6:
        if (isActive() == true) goto L9;
        Log.w("EmojiPageNewFragment2", "compute cancel because not active");
        return;
    L9:
        int r0 = this.j;
        if (r0 > 0) goto L13;
        Log.w("EmojiPageNewFragment2", "compute cancel because rootWidth <= 0");
        return;
    L13:
        int r2 = X90();
        if (this.k != 0) goto L23;
        int r3 = r0 - (r2 * 2);
        if ((r3 / (this.g - 1)) <= UIHelper.dp2px(64.0f)) goto L19;
        int r4 = this.g + 1;
    L22:
        this.k = r4;
        goto L23
    L19:
        if ((r3 / (this.g - 1)) >= UIHelper.dp2px(48.0f)) goto L21;
        r4 = this.g - 1;
        goto L22
    L21:
        r4 = this.g;
    L23:
        int r5 = r2 * 2;
        int r6 = this.k;
        int r7 = (r0 - r5) / (r6 - 1);
        if (r7 <= r5) goto L26;
        this.l = r5;
    L27:
        int r8 = this.l;
        int r9 = r7 - r8;
        this.m = r9;
        this.o = (r0 - (r6 * (r8 + r9))) - this.n;
        Log.i("EmojiPageNewFragment2", "compute, emoji info: showColumn: " + this.k + ", windowWidth: " + r0 + ", emojiLeftMargin: " + this.m + ", marginFirstEmoji: " + r2);
        return;
    L26:
        this.l = r7;
        this.n = r2 - (r7 / 2);
        goto L27
    }

    public int W90() {
        return UIHelper.dp2px(32.0f);
    }

    public int X90() {
        return UIHelper.dp2px(30.0f);
    }

    public final void Y90() {
        Log.i("EmojiPageNewFragment2", "initList");
        List<String> r0 = k2c.a.a().h();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        com.ss.android.lark.newemoji.larkemoji.b r3 = com.ss.android.lark.newemoji.larkemoji.c.d((String) r2.next());
        if (r3 == null) goto L4;
        r1.add(r3);
        goto L4
    L8:
        DefaultEmojiPanelData r4 = k2c.a.a().a();
        if (r4.d() == false) goto L11;
        return;
    L11:
        this.q = r1;
        Intrinsics.checkNotNull(r4);
        this.r = r4;
        aa0();
    }

    public void Z90() {
        int r0 = com.ss.android.lark.reaction.widget.emojipanel.a.a;
        Statistics.sendEvent("public_emoji_panel_widget_view");
    }

    public final void aa0() {
        Log.i("EmojiPageNewFragment2", "setEmojiListData");
        if (isActive() == true) goto L7;
        Log.w("EmojiPageNewFragment2", "setEmojiListData cancel because not active");
        return;
    L7:
        if (this.j > 0) goto L11;
        Log.w("EmojiPageNewFragment2", "setEmojiListData cancel because rootWidth <= 0");
        return;
    L11:
        if (this.r.d() == false) goto L14;
        return;
    L14:
        if (this.k != 0) goto L16;
        T90();
    L16:
        ArrayList r2 = new ArrayList();
        r2.add(new ssb.b.b(8));
        boolean r6 = false;
        if (V90().getBoolean("ENABLE_RECENT_USE", true) == false) goto L75;
        ArrayList<String> r3 = V90().getStringArrayList("RECENT_EMOJIS");
        if (r3 == null) goto L26;
        ArrayList r9 = new ArrayList();
        Iterator<T> r4 = r3.iterator();
    L22:
        if (r4.hasNext() == false) goto L27;
        com.ss.android.lark.newemoji.larkemoji.b r10 = com.ss.android.lark.newemoji.larkemoji.c.d((String) r4.next());
        if (r10 == null) goto L22;
        r9.add(r10);
    L27:
        if (r9 != null) goto L29;
    L32:
        boolean r5 = true;
    L33:
        if (r5 == false) goto L35;
        List<? extends com.ss.android.lark.newemoji.larkemoji.a> r11 = this.q;
        int r7 = usb.a.a();
        List<? extends com.ss.android.lark.newemoji.larkemoji.a> r12 = r11;
    L37:
        if ((!r12.isEmpty()) == false) goto L75;
        String r13 = V90().getString("RECENT_TITLE");
        if (r13 != null) goto L42;
        r13 = "";
    L42:
        if (r13.length() != 0) goto L44;
        boolean r14 = true;
    L45:
        if (r14 == false) goto L47;
        r13 = UIHelper.getString(2131891136);
    L47:
        Intrinsics.checkNotNull(r13);
        r2.add(new ssb.b.d(r13, null));
        ArrayList r8 = new ArrayList();
        Iterator r15 = r12.iterator();
    L49:
        if (r15.hasNext() == false) goto L55;
        Object r16 = r15.next();
        com.ss.android.lark.newemoji.larkemoji.a r17 = (com.ss.android.lark.newemoji.larkemoji.a) r16;
        boolean r18 = r17.c(false);
        if (r18 == true) goto L53;
        Log.w("EmojiPageNewFragment2", "set mru emojis, emoji [" + r17.getId() + "] is not prepared");
    L53:
        if (r18 == false) goto L49;
        r8.add(r16);
        goto L49
    L55:
        ArrayList r19 = new ArrayList();
        Iterator r20 = r8.iterator();
    L57:
        if (r20.hasNext() == false) goto L67;
        Object r110 = r20.next();
        com.ss.android.lark.newemoji.larkemoji.a r111 = (com.ss.android.lark.newemoji.larkemoji.a) r110;
        if (V90().getBoolean("ENABLE_CUSTOM_EMOJI", true) == false) goto L61;
    L64:
        boolean r112 = true;
    L65:
        if (r112 == false) goto L57;
        r19.add(r110);
        goto L57
    L61:
        if (k2c.a.a().j5(r111.b()) == false) goto L64;
        r112 = false;
        goto L65
    L67:
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
        Iterator r22 = r19.iterator();
        int r113 = 0;
    L69:
        if (r22.hasNext() == false) goto L74;
        Object r114 = r22.next();
        int r115 = r113 + 1;
        if (r113 >= 0) goto L73;
        CollectionsKt.throwIndexOverflow();
    L73:
        r21.add(new ssb.b.c((com.ss.android.lark.newemoji.larkemoji.a) r114, false, n3.e, Integer.valueOf(r115)));
        r113 = r115;
        goto L69
    L74:
        r2.add(new ssb.b.a(r21, r7));
        goto L75
    L44:
        r14 = false;
        goto L45
    L35:
        r7 = -1;
        r12 = r9;
        goto L37
    L29:
        if (r9.isEmpty() == true) goto L32;
        r5 = false;
        goto L33
    L26:
        r9 = null;
    L75:
        Iterator r23 = ((ArrayList) this.r.a).iterator();
    L77:
        if (r23.hasNext() == false) goto L119;
        DefaultEmojiPanelData.a r24 = (DefaultEmojiPanelData.a) r23.next();
        if (r24.getType() == DefaultEmojiPanelData.Type.UNKNOWN) goto L77;
        if (V90().getBoolean("ENABLE_CUSTOM_EMOJI", true) == true) goto L87;
        if (r24.getType() == DefaultEmojiPanelData.Type.CUSTOM) goto L77;
    L87:
        if (r24.getType() != DefaultEmojiPanelData.Type.DEFAULT) goto L103;
        String r25 = V90().getString("DEFAULT_TITLE");
        if (r25 != null) goto L92;
        r25 = "";
    L92:
        if (r25.length() != 0) goto L94;
        boolean r116 = true;
    L95:
        if (r116 == false) goto L98;
        r25 = r24.c;
    L98:
        if (r25.length() != 0) goto L100;
        boolean r117 = true;
    L101:
        if (r117 == false) goto L104;
        r25 = UIHelper.getString(2131890747);
    L104:
        Intrinsics.checkNotNull(r25);
        r2.add(new ssb.b.d(r25, r24.b));
        ArrayList r26 = new ArrayList();
        Iterator r27 = ((ArrayList) r24.b()).iterator();
        int r118 = 0;
    L106:
        if (r27.hasNext() == false) goto L113;
        com.ss.android.lark.newemoji.larkemoji.a r119 = (com.ss.android.lark.newemoji.larkemoji.a) r27.next();
        if (r119.c(r6) == false) goto L106;
        r118 = r118 + 1;
        r2.add(new ssb.b.c(r119, V90().getBoolean("ENABLE_EMOJI_SKIN_TONES", true), n3.d, Integer.valueOf(r118)));
        if (V90().getBoolean("ENABLE_EMOJI_SKIN_TONES", true) == false) goto L112;
        r26.add(r119.getId());
    L112:
        r6 = false;
        goto L106
    L113:
        if (r118 != 0) goto L116;
        ListProtector.remove(r2, CollectionsKt.getLastIndex(r2));
    L116:
        if ((!r26.isEmpty()) == false) goto L118;
        Log.i("EmojiPageNewFragment2", "setEmojiListData, enabled skin tones change key is: " + r26);
    L118:
        r6 = false;
        goto L77
    L100:
        r117 = false;
        goto L101
    L94:
        r116 = false;
        goto L95
    L103:
        r25 = r24.c;
        goto L104
    L119:
        r2.add(new ssb.b.b(56));
        EmojiListView r1 = this.f;
        if (r1 == null) goto L154;
        r1.setData(r2);
        return;
    }

    public EmojiPageNewFragment2() {
        this.g = 7;
        this.h = z2.c;
        this.i = "";
        this.p = new CallbackManager();
        List<String> r0 = k2c.a.a().h();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        com.ss.android.lark.newemoji.larkemoji.b r3 = com.ss.android.lark.newemoji.larkemoji.c.d((String) r2.next());
        if (r3 == null) goto L4;
        r1.add(r3);
        goto L4
    L8:
        this.q = r1;
        this.r = k2c.a.a().a();
        this.t = LazyKt.lazy(new EmojiPageNewFragment2$globalLayoutListener$2(this));
    }

    public final Bundle V90() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L7;
        r0 = BundleKt.bundleOf();
        if (isStateSaved() == true) goto L7;
        super/*androidx.fragment.app.Fragment*/.setArguments(r0);
    L7:
        return r0;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        Log.i("EmojiPageNewFragment2", "onDestroyView");
        this.p.cancelCallbacks();
        EmojiListView r0 = this.f;
        if (r0 == null) goto L5;
        r0.c = null;
    L5:
        if (r0 == null) goto L7;
        com.ss.android.lark.newemoji.larkemoji.c.e(r0);
    L7:
        ViewTreeObserver r1 = this.s;
        if (r1 == null) goto L12;
        boolean r3 = true;
        if (r1.isAlive() != true) goto L12;
    L13:
        if (r3 == false) goto L17;
        ViewTreeObserver r2 = this.s;
        if (r2 == null) goto L17;
        r2.removeOnGlobalLayoutListener((EmojiPageNewFragment2$globalLayoutListener$2.a) this.t.getValue());
    L17:
        this.s = null;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        return;
    L12:
        r3 = false;
        goto L13
    }

    public View U90(ConstraintLayout r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        ImageView r0 = new ImageView(r4.getContext());
        r0.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        ConstraintLayout.LayoutParams r5 = new ConstraintLayout.LayoutParams(UIHelper.dp2px(56.0f), UIHelper.dp2px(56.0f));
        r0.setLayoutParams(r5);
        r5.bottomToBottom = 0;
        r5.endToEnd = 0;
        r0.setImageResource(2131237786);
        r0.setBackgroundColor(UIHelper.getColor(2131103546));
        return r0;
    }

    public void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        Log.i("EmojiPageNewFragment2", "onViewCreated");
        this.j = r4.getWidth();
        S90();
        aa0();
        EmojiListView r6 = this.f;
        if (r6 == null) goto L9;
        EmojiListAdapter r0 = r6.b;
        if (r0 == null) goto L9;
        RecyclerView r7 = r6.a;
        Intrinsics.checkNotNullParameter(r7, "rv");
        f r1 = (f) r0.d.get(1);
        if (r1 == null) goto L9;
        Intrinsics.checkNotNullParameter(r7, "rv");
        r1.a = r7;
    L9:
        EmojiListView r8 = this.f;
        if (r8 == null) goto L12;
        com.ss.android.lark.newemoji.larkemoji.c.c(r8);
    L12:
        EmojiListView r9 = this.f;
        if (r9 == null) goto L15;
        r9.setOnEmojiSelectListener(new EmojiPageNewFragment2$initListener$1(this));
    L15:
        ViewTreeObserver r10 = r4.getViewTreeObserver();
        this.s = r10;
        if (r10 == null) goto L18;
        r10.addOnGlobalLayoutListener((EmojiPageNewFragment2$globalLayoutListener$2.a) this.t.getValue());
    L18:
        Z90();
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Log.i("EmojiPageNewFragment2", "onCreateView");
        Context r6 = getLayoutInflater().getContext();
        Intrinsics.checkNotNull(r6);
        ConstraintLayout r7 = new ConstraintLayout(r6);
        r7.setId(2131367766);
        r7.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        EmojiListView r8 = new EmojiListView(r6);
        r8.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        r7.addView(r8);
        View r9 = U90(r7);
        r9.setId(2131368791);
        r9.setOnClickListener(new b(this));
        r7.addView(r9);
        this.f = r8;
        this.e = r9;
        int r1 = 0;
        if (V90().getBoolean("DELETE_ICON_VISIBLE", false) == true) goto L6;
        r1 = 8;
    L6:
        r9.setVisibility(r1);
        return r7;
    }
}
