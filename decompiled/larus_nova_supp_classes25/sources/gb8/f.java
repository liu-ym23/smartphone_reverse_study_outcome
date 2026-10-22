package gb8;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.markdown.reference.SearchReferenceData;
import com.larus.bmhome.chat.markdown.reference.Stage;
import com.larus.bmhome.chat.markdown.reference.ToolType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.SearchQueryResultBlock;
import com.larus.im.bean.message.block.SearchQueryResultExtend;
import com.larus.im.bean.message.block.SearchType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f extends jc8.a implements jc8.j {
    @Override // jc8.a
    public final String g() {
        return "DeepThinkImageSearchBlockBizModel";
    }

    @Override // jc8.a
    public final int l() {
        int r0 = com.larus.bmhome.chat.deepresearch.view.j.a;
        return com.larus.bmhome.chat.deepresearch.view.j.v;
    }

    public final SearchReferenceData o() {
        BlockContent r1 = this.a.getContent();
        if (r1 == null) goto L44;
        SearchQueryResultBlock r2 = r1.getSearchQueryResultBlock();
        if (r2 == null) goto L44;
        String r6 = r2.summary;
        List r4 = r2.results;
        List r5 = r2.queries;
        if (this.a.isFinish() == false) goto L10;
        Stage r3 = Stage.Searched;
    L11:
        Integer r7 = Integer.valueOf(r3.getValue());
        SearchQueryResultExtend r8 = r2.extendFields;
        if (r8 == null) goto L14;
        Integer r9 = r8.thinkingIndex;
    L15:
        Integer r10 = r9;
        String r11 = r2.iconUrl;
        String r12 = r2.iconUrlDark;
        Integer r13 = r2.searchType;
        int r14 = SearchType.WebSearch.getValue();
        if (r13 != null) goto L19;
    L22:
        int r15 = SearchType.TextSearchImage.getValue();
        if (r13 != null) goto L26;
    L28:
        int r16 = SearchType.ImageSearchImage.getValue();
        if (r13 != null) goto L32;
    L34:
        int r17 = SearchType.ScholarSearch.getValue();
        if (r13 != null) goto L38;
    L40:
        String r18 = ToolType.SearchPlugin.getValue();
    L42:
        return new SearchReferenceData(r6, r4, r5, r6, r7, r10, r11, r12, r18, false, 512, null);
    L38:
        if (r13.intValue() != r17) goto L40;
        r18 = ToolType.ScholarSearch.getValue();
        goto L42
    L32:
        if (r13.intValue() != r16) goto L34;
        r18 = ToolType.SearchImage.getValue();
        goto L42
    L26:
        if (r13.intValue() != r15) goto L28;
        r18 = ToolType.TextSearchImage.getValue();
        goto L42
    L19:
        if (r13.intValue() != r14) goto L22;
        r18 = ToolType.SearchPlugin.getValue();
        goto L42
    L14:
        r9 = null;
        goto L15
    L10:
        r3 = Stage.Searching;
    L44:
        return new SearchReferenceData(null, null, null, null, null, null, null, null, null, false, 1023, null);
    }

    @Override // jc8.j
    public final String c() {
        return (String) ListProtector.get(com.larus.bmhome.chat.markdown.reference.a.b(o()), 0);
    }

    @Override // jc8.j
    public final String a(boolean r4) {
        BlockContent r0 = this.a.getContent();
        String r1 = null;
        if (r0 == null) goto L5;
        SearchQueryResultBlock r2 = r0.getSearchQueryResultBlock();
    L7:
        if (r4 == false) goto L12;
        if (r2 == null) goto L10;
        r1 = r2.iconUrlDark;
    L10:
        if (r1 != null) goto L17;
        return "";
    L17:
        return r1;
    L12:
        if (r2 == null) goto L14;
        r1 = r2.iconUrl;
    L14:
        if (r1 != null) goto L17;
        return "";
    L5:
        r2 = null;
        goto L7
    }

    @Override // jc8.a
    public final boolean e(jc8.a r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        BlockContent r1 = this.a.getContent();
        SearchQueryResultBlock r2 = null;
        if (r1 == null) goto L8;
        SearchQueryResultBlock r3 = r1.getSearchQueryResultBlock();
    L9:
        if (r3 == null) goto L11;
        int r5 = r3.hashCode();
    L12:
        BlockContent r6 = r4.a.getContent();
        if (r6 == null) goto L15;
        r2 = r6.getSearchQueryResultBlock();
    L15:
        if (r2 == null) goto L17;
        int r7 = r2.hashCode();
    L18:
        if (r5 != r7) goto L21;
        return true;
    L21:
        return false;
    L17:
        r7 = 0;
        goto L18
    L11:
        r5 = 0;
        goto L12
    L8:
        r3 = null;
        goto L9
    }

    public f(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        super(r2, r3);
    }
}
