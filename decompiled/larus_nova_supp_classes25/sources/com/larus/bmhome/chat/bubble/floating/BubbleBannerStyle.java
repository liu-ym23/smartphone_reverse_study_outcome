package com.larus.bmhome.chat.bubble.floating;

import com.larus.bmhome.chat.bean.WcbRenderStatus;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/BubbleBannerStyle;", "", "layout", "", "<init>", "(Ljava/lang/String;II)V", "getLayout", "()I", WcbRenderStatus.DEFAULT, "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum BubbleBannerStyle extends Enum<BubbleBannerStyle> {
    public static final a Companion = null;
    public static final BubbleBannerStyle DEFAULT = null;
    public static final BubbleBannerStyle a = null;
    public static final /* synthetic */ BubbleBannerStyle[] b = null;
    public static final /* synthetic */ EnumEntries c = null;
    private final int layout;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<BubbleBannerStyle> getEntries() {
        return c;
    }

    static {
        BubbleBannerStyle r0 = new BubbleBannerStyle();
        DEFAULT = r0;
        BubbleBannerStyle[] r1 = {r0};
        b = r1;
        c = EnumEntriesKt.enumEntries(r1);
        Companion = new a();
        a = r0;
    }

    public BubbleBannerStyle() {
        super(WcbRenderStatus.DEFAULT, 0);
        this.layout = 1;
    }

    public static BubbleBannerStyle[] values() {
        return (BubbleBannerStyle[]) b.clone();
    }

    public static final /* synthetic */ BubbleBannerStyle access$getDEFAULT_STYLE$cp() {
        return a;
    }

    public final int getLayout() {
        return this.layout;
    }

    public static BubbleBannerStyle valueOf(String r1) {
        return (BubbleBannerStyle) r27.a.a(BubbleBannerStyle.class, r1);
    }
}
