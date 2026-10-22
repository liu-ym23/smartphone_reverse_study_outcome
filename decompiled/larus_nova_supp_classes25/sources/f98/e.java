package f98;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR(\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001e\u0010\u0003\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\"\u0010!\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R \u0010'\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001a\"\u0004\b/\u0010\u001cR$\u00100\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b1\u0010\u0003\u001a\u0004\b2\u0010\u001a\"\u0004\b3\u0010\u001c¨\u00064"}, d2 = {"Lcom/larus/avlink/e/model/DoraUploadFileRequest;", "", "<init>", "()V", "botId", "", "getBotId", "()Ljava/lang/String;", "setBotId", "(Ljava/lang/String;)V", "conversationId", "getConversationId", "setConversationId", "contents", "", "Lcom/larus/avlink/e/model/FileContent;", "getContents", "()Ljava/util/List;", "setContents", "(Ljava/util/List;)V", "extString", "getExtString", "setExtString", "productType", "", "getProductType", "()I", "setProductType", "(I)V", "scene", "getScene$annotations", "getScene", "setScene", "visionBizScene", "getVisionBizScene", "()Ljava/lang/Integer;", "setVisionBizScene", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "fileCtrlParams", "Lcom/larus/avlink/e/model/FileCtrlParams;", "getFileCtrlParams", "()Lcom/larus/avlink/e/model/FileCtrlParams;", "setFileCtrlParams", "(Lcom/larus/avlink/e/model/FileCtrlParams;)V", "totalCount", "getTotalCount", "setTotalCount", "mode", "getMode$annotations", "getMode", "setMode", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class e {
    public transient int a;
    public transient int b;

    @SerializedName("bot_id")
    private String botId;

    @SerializedName("contents")
    private List<l> contents;

    @SerializedName("conversation_id")
    private String conversationId;

    @SerializedName("ext")
    private String extString;

    @SerializedName("ctrl_params")
    private m fileCtrlParams;

    @SerializedName("product_type")
    private int productType;

    @SerializedName("scene")
    private int scene;

    @SerializedName("vision_biz_scene")
    private Integer visionBizScene;

    public e() {
        this.b = 1;
    }

    public final List<l> a() {
        return this.contents;
    }

    public final String b() {
        return this.conversationId;
    }

    public final void c(String r1) {
        this.botId = r1;
    }

    public final void d(List<l> r1) {
        this.contents = r1;
    }

    public final void e(String r1) {
        this.conversationId = r1;
    }

    public final void f(String r1) {
        this.extString = r1;
    }

    public final void g(m r1) {
        this.fileCtrlParams = r1;
    }

    public final void h(int r1) {
        this.productType = r1;
    }

    public final void i(int r1) {
        this.scene = r1;
    }

    public final void j(Integer r1) {
        this.visionBizScene = r1;
    }
}
