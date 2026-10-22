package com.larus.bmhome.chat.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.list.cell.text.components.bottom.riskwarning.TipsBlockType;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.TipsBlock;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.mainbot.impl.databinding.LarusRiskTipsTextViewBinding;
import com.larus.utils.e1;
import kc8.z;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import po8.r;
import po8.s;
import po8.t;
import po8.w;
import v19.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ2\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J,\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006%"}, d2 = {"Lcom/larus/bmhome/chat/view/RiskTipsTextView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "bottomPadding", "binding", "Lcom/larus/mainbot/impl/databinding/LarusRiskTipsTextViewBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusRiskTipsTextViewBinding;", "binding$delegate", "Lkotlin/Lazy;", "bindData", "", "message", "Lcom/larus/im/bean/message/Message;", "block", "Lcom/larus/im/bean/message/block/Block;", "isLastBlockModel", "", "blockLongClickHandler", "Lcom/larus/bmhome/chat/block/base/config/IBlockLongClickHandler;", "setupRiskView", "data", "Lcom/larus/im/bean/message/block/TipsBlock;", "setWarningUrl", "view", "Landroid/widget/TextView;", "textOfUrl", ShareType.URL, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RiskTipsTextView extends LinearLayout {
    public static final /* synthetic */ int c = 0;
    public final int a;
    public final Lazy b;

    public RiskTipsTextView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RiskTipsTextView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final LarusRiskTipsTextViewBinding getBinding() {
        return (LarusRiskTipsTextViewBinding) this.b.getValue();
    }

    public RiskTipsTextView(final Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.a = getResources().getDimensionPixelSize(c.b(2130971163, null, 2131166696));
        this.b = LazyKt.lazy(new r(r3, this));
    }

    public /* synthetic */ RiskTipsTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void a(final Message r7, Block r8, boolean r9, final z r10) {
        Intrinsics.checkNotNullParameter(r7, "message");
        Intrinsics.checkNotNullParameter(r8, "block");
        BlockContent r0 = r8.getContent();
        if (r0 == null) goto L60;
        TipsBlock r1 = r0.getTipsBlock();
        if (r1 == null) goto L63;
        LarusRiskTipsTextViewBinding r2 = getBinding();
        e1.o(r2.a);
        e1.o(r2.b);
        r2.a.setOnLongClickListener(new s(r10));
        boolean r3 = true;
        if (d.Q0(r7) == true) goto L14;
        if (d.I0(r7) == true) goto L14;
        if (r7.getMessageStatusLocal() == 20) goto L14;
    L19:
        boolean r11 = true;
    L20:
        if (r11 == false) goto L58;
        String r12 = r7.getMessageId();
        if (r12 != null) goto L24;
    L27:
        boolean r13 = true;
    L28:
        if (r13 == true) goto L58;
        String r14 = r1.text;
        if (r14 == null) goto L33;
        String r15 = StringsKt.trimStart(r14, new char[]{'\n'});
    L34:
        e1.x(r2.a);
        TextView r4 = r2.b;
        int r5 = r1.type;
        if (r5 != TipsBlockType.TIPS_BLOCK_TYPE_TEXT.getValue()) goto L38;
        r4.setText(r15);
        r4.setTextSize(0, r4.getResources().getDimensionPixelSize(c.b(2130972273, null, 2131167616)));
        r4.setTextColor(ContextCompat.getColor(r4.getContext(), c.b(2130972081, r4.getContext(), 2131103143)));
        Intrinsics.checkNotNull(r4);
        e1.x(r4);
    L56:
        if (r9 == false) goto L61;
        r4.setPaddingRelative(r4.getPaddingStart(), r4.getPaddingTop(), r4.getPaddingEnd(), this.a);
        return;
    L61:
        return;
    L38:
        if (r5 != TipsBlockType.TIPS_BLOCK_TYPE_URL.getValue()) goto L56;
        Intrinsics.checkNotNull(r4);
        final String r6 = r1.url;
        if (r15 != null) goto L42;
    L45:
        boolean r16 = true;
    L46:
        if (r16 == true) goto L55;
        if (r6 != null) goto L49;
    L52:
        if (r3 == true) goto L55;
        SpannableString r17 = new SpannableString(r15);
        r17.setSpan(new w(r6, this), 0, r15.length(), 33);
        r4.setText(r17);
        r4.setTextSize(0, r4.getResources().getDimensionPixelSize(c.b(2130972275, null, 2131167620)));
        r4.setMovementMethod(LinkMovementMethod.getInstance());
        ExposeXTrackerExtKt.b(r4, new t(r7, r6));
        goto L55
    L49:
        if (r6.length() == 0) goto L52;
        r3 = false;
    L55:
        e1.x(r4);
        goto L56
    L42:
        if (r15.length() == 0) goto L45;
        r16 = false;
        goto L46
    L33:
        r15 = null;
        goto L34
    L24:
        if (r12.length() == 0) goto L27;
        r13 = false;
    L58:
        e1.o(r2.a);
        return;
    L14:
        if (r7.getMessageStatusLocal() == 23) goto L19;
        if (r8.isFinish() == true) goto L19;
        r11 = false;
        goto L20
    L63:
        return;
    }
}
