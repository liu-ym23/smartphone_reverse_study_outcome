package com.ss.android.lark.officesdk.minutes.ui.foundation.widget.markdown;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class RichTextInlineTagData {
    public final List<Integer> a;
    public final Style b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/markdown/RichTextInlineTagData$Style;", "", "<init>", "(Ljava/lang/String;I)V", "BOLD", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum Style extends Enum<Style> {
        public static final Style BOLD = null;
        public static final /* synthetic */ Style[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Style> getEntries() {
            return b;
        }

        static {
            Style r0 = new Style();
            BOLD = r0;
            Style[] r1 = {r0};
            a = r1;
            b = EnumEntriesKt.enumEntries(r1);
        }

        public Style() {
            super("BOLD", 0);
        }

        public static Style[] values() {
            return (Style[]) a.clone();
        }

        public static Style valueOf(String r1) {
            return (Style) r27.a.a(Style.class, r1);
        }
    }

    public RichTextInlineTagData(List<Integer> r2, Style r3) {
        Intrinsics.checkNotNullParameter(r2, "indexData");
        Intrinsics.checkNotNullParameter(r3, "style");
        this.a = r2;
        this.b = r3;
    }
}
