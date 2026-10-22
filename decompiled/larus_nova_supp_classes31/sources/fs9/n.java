package fs9;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.bot.BotStatusCacheDelegate;
import com.larus.bmhome.chat.bean.BotAction;
import com.larus.bmhome.chat.bean.BotOnBoarding;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.BotConfItem;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotStatistic;
import com.larus.im.bean.bot.BotSwitchConfInfo;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.im.bean.bot.FirstMet;
import com.larus.im.bean.bot.ModelItem;
import com.larus.im.bean.bot.ShareInfo;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.internal.protocol.model.BotCommentInfo;
import com.larus.im.internal.protocol.model.LikeInfo;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\bb\n\u0002\u0018\u0002\n\u0002\b*\b\u0086\b\u0018\u00002\u00020\u0001B§\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\b\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(\u0012\u0012\b\u0002\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010+\u0018\u00010*\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000102\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000104\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u00107\u001a\u000208¢\u0006\u0004\b9\u0010:J\u0007\u0010\u0095\u0001\u001a\u00020\bJ\u0007\u0010\u0096\u0001\u001a\u00020\bJ\u0007\u0010\u0099\u0001\u001a\u00020\u0005J\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001J\t\u0010\u009c\u0001\u001a\u00020\u0005H\u0016J\f\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u009e\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010 \u0001\u001a\u00020\bHÆ\u0003J\f\u0010¡\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¢\u0001\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\f\u0010£\u0001\u001a\u0004\u0018\u00010\rHÆ\u0003J\n\u0010¤\u0001\u001a\u00020\bHÆ\u0003J\n\u0010¥\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010¦\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\f\u0010§\u0001\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\f\u0010¨\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\f\u0010©\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010ª\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010[J\f\u0010«\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¬\u0001\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\f\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\f\u0010®\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¯\u0001\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\n\u0010°\u0001\u001a\u00020\bHÆ\u0003J\f\u0010±\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010²\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010³\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010´\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010µ\u0001\u001a\u0004\u0018\u00010&HÆ\u0003J\f\u0010¶\u0001\u001a\u0004\u0018\u00010(HÆ\u0003J\u0014\u0010·\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010+\u0018\u00010*HÆ\u0003J\f\u0010¸\u0001\u001a\u0004\u0018\u00010-HÆ\u0003J\f\u0010¹\u0001\u001a\u0004\u0018\u00010/HÆ\u0003J\f\u0010º\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010»\u0001\u001a\u0004\u0018\u000102HÆ\u0003J\f\u0010¼\u0001\u001a\u0004\u0018\u000104HÆ\u0003J\f\u0010½\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010¾\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0003\u0010\u008b\u0001J\n\u0010¿\u0001\u001a\u000208HÆ\u0003J°\u0003\u0010À\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\u0012\b\u0002\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010+\u0018\u00010*2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00106\u001a\u0004\u0018\u00010\b2\b\b\u0002\u00107\u001a\u000208HÆ\u0001¢\u0006\u0003\u0010Á\u0001J\u0015\u0010Â\u0001\u001a\u00020\b2\t\u0010Ã\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010Ä\u0001\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010<\"\u0004\bB\u0010CR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010<\"\u0004\bG\u0010CR\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u001e\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010E\"\u0004\bM\u0010NR\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010>R \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR \u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010<\"\u0004\bY\u0010CR\"\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010^\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010<R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010aR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010cR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010<R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010fR\u001e\u0010 \u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010E\"\u0004\bh\u0010NR \u0010!\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010<\"\u0004\bj\u0010CR \u0010\"\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010<\"\u0004\bl\u0010CR \u0010#\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010<\"\u0004\bn\u0010CR \u0010$\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010<\"\u0004\bp\u0010CR \u0010%\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR \u0010'\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR(\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010+\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u0018\u0010,\u001a\u0004\u0018\u00010-8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b}\u0010~R\u0019\u0010.\u001a\u0004\u0018\u00010/8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u007f\u0010\u0080\u0001R\u0019\u00100\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u0010<R$\u00101\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001a\u00103\u001a\u0004\u0018\u0001048\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\"\u00105\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u0010<\"\u0005\b\u0089\u0001\u0010CR'\u00106\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0003\u0010\u008e\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R\"\u00107\u001a\u0002088\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R$\u0010\u0093\u0001\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u008e\u0001\u001a\u0006\b\u0093\u0001\u0010\u008b\u0001\"\u0006\b\u0094\u0001\u0010\u008d\u0001R\u0013\u0010\u0097\u0001\u001a\u00020\b8F¢\u0006\u0007\u001a\u0005\b\u0098\u0001\u0010E¨\u0006Å\u0001"}, d2 = {"Lcom/larus/profile/api/bean/ProfileBot;", "", "botId", "", "botMode", "", "name", "hasConversation", "", "conversationId", "botOnBoarding", "Lcom/larus/bmhome/chat/bean/BotOnBoarding;", "action", "Lcom/larus/bmhome/chat/bean/BotAction;", "muted", "botType", "iconImage", "Lcom/larus/im/bean/bot/BotIconImage;", "creatorInfo", "Lcom/larus/im/bean/bot/BotCreatorInfo;", "botStatus", "Lcom/larus/im/bean/bot/BotStatistic;", "bio", "privateStatus", "humanDescription", "model", "Lcom/larus/im/bean/bot/ModelItem;", "voice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "editPos", "shareInfo", "Lcom/larus/im/bean/bot/ShareInfo;", "disabled", "disabledTag", "bgImgUrl", "bgImgColor", "bgImgUri", "bgImgInfo", "Lcom/larus/im/bean/bot/BgImageInfo;", "switchConfInfo", "Lcom/larus/im/bean/bot/BotSwitchConfInfo;", "botConf", "", "Lcom/larus/im/bean/bot/BotConfItem;", "conversationPage", "Lcom/larus/im/bean/bot/ConversationPage;", "firstMet", "Lcom/larus/im/bean/bot/FirstMet;", "botFeatureLabel", "likeInfo", "Lcom/larus/im/internal/protocol/model/LikeInfo;", "commentInfo", "Lcom/larus/im/internal/protocol/model/BotCommentInfo;", "callerName", "callerNameSetting", "recommendIndex", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;ZLjava/lang/String;Lcom/larus/bmhome/chat/bean/BotOnBoarding;Lcom/larus/bmhome/chat/bean/BotAction;ZILcom/larus/im/bean/bot/BotIconImage;Lcom/larus/im/bean/bot/BotCreatorInfo;Lcom/larus/im/bean/bot/BotStatistic;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/im/bean/bot/ModelItem;Lcom/larus/im/bean/bot/SpeakerVoice;Ljava/lang/String;Lcom/larus/im/bean/bot/ShareInfo;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BgImageInfo;Lcom/larus/im/bean/bot/BotSwitchConfInfo;Ljava/util/List;Lcom/larus/im/bean/bot/ConversationPage;Lcom/larus/im/bean/bot/FirstMet;Ljava/lang/String;Lcom/larus/im/internal/protocol/model/LikeInfo;Lcom/larus/im/internal/protocol/model/BotCommentInfo;Ljava/lang/String;Ljava/lang/Boolean;J)V", "getBotId", "()Ljava/lang/String;", "getBotMode", "()I", "setBotMode", "(I)V", "getName", "setName", "(Ljava/lang/String;)V", "getHasConversation", "()Z", "getConversationId", "setConversationId", "getBotOnBoarding", "()Lcom/larus/bmhome/chat/bean/BotOnBoarding;", "getAction", "()Lcom/larus/bmhome/chat/bean/BotAction;", "getMuted", "setMuted", "(Z)V", "getBotType", "getIconImage", "()Lcom/larus/im/bean/bot/BotIconImage;", "setIconImage", "(Lcom/larus/im/bean/bot/BotIconImage;)V", "getCreatorInfo", "()Lcom/larus/im/bean/bot/BotCreatorInfo;", "getBotStatus", "()Lcom/larus/im/bean/bot/BotStatistic;", "getBio", "setBio", "getPrivateStatus", "()Ljava/lang/Integer;", "setPrivateStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getHumanDescription", "getModel", "()Lcom/larus/im/bean/bot/ModelItem;", "getVoice", "()Lcom/larus/im/bean/bot/SpeakerVoice;", "getEditPos", "getShareInfo", "()Lcom/larus/im/bean/bot/ShareInfo;", "getDisabled", "setDisabled", "getDisabledTag", "setDisabledTag", "getBgImgUrl", "setBgImgUrl", "getBgImgColor", "setBgImgColor", "getBgImgUri", "setBgImgUri", "getBgImgInfo", "()Lcom/larus/im/bean/bot/BgImageInfo;", "setBgImgInfo", "(Lcom/larus/im/bean/bot/BgImageInfo;)V", "getSwitchConfInfo", "()Lcom/larus/im/bean/bot/BotSwitchConfInfo;", "setSwitchConfInfo", "(Lcom/larus/im/bean/bot/BotSwitchConfInfo;)V", "getBotConf", "()Ljava/util/List;", "setBotConf", "(Ljava/util/List;)V", "getConversationPage", "()Lcom/larus/im/bean/bot/ConversationPage;", "getFirstMet", "()Lcom/larus/im/bean/bot/FirstMet;", "getBotFeatureLabel", "getLikeInfo", "()Lcom/larus/im/internal/protocol/model/LikeInfo;", "setLikeInfo", "(Lcom/larus/im/internal/protocol/model/LikeInfo;)V", "getCommentInfo", "()Lcom/larus/im/internal/protocol/model/BotCommentInfo;", "getCallerName", "setCallerName", "getCallerNameSetting", "()Ljava/lang/Boolean;", "setCallerNameSetting", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getRecommendIndex", "()J", "setRecommendIndex", "(J)V", "isAddedByUser", "setAddedByUser", "isAdded", "isChatOnly", "bgImgOpen", "getBgImgOpen", "getStatus", "toBotModel", "Lcom/larus/im/bean/bot/BotModel;", "hashCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "copy", "(Ljava/lang/String;ILjava/lang/String;ZLjava/lang/String;Lcom/larus/bmhome/chat/bean/BotOnBoarding;Lcom/larus/bmhome/chat/bean/BotAction;ZILcom/larus/im/bean/bot/BotIconImage;Lcom/larus/im/bean/bot/BotCreatorInfo;Lcom/larus/im/bean/bot/BotStatistic;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/im/bean/bot/ModelItem;Lcom/larus/im/bean/bot/SpeakerVoice;Ljava/lang/String;Lcom/larus/im/bean/bot/ShareInfo;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BgImageInfo;Lcom/larus/im/bean/bot/BotSwitchConfInfo;Ljava/util/List;Lcom/larus/im/bean/bot/ConversationPage;Lcom/larus/im/bean/bot/FirstMet;Ljava/lang/String;Lcom/larus/im/internal/protocol/model/LikeInfo;Lcom/larus/im/internal/protocol/model/BotCommentInfo;Ljava/lang/String;Ljava/lang/Boolean;J)Lcom/larus/profile/api/bean/ProfileBot;", "equals", "other", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class n {
    public Boolean a;

    @SerializedName("action")
    private final BotAction action;

    @SerializedName("bg_img_avg_hue")
    private String bgImgColor;

    @SerializedName("bg_img_info")
    private BgImageInfo bgImgInfo;

    @SerializedName("bg_img_uri")
    private String bgImgUri;

    @SerializedName("bg_img_url")
    private String bgImgUrl;

    @SerializedName("bio")
    private String bio;

    @SerializedName("bot_conf")
    private List<BotConfItem> botConf;

    @SerializedName("bot_feature_label")
    private final String botFeatureLabel;

    @SerializedName("bot_id")
    private final String botId;

    @SerializedName("bot_mode")
    private int botMode;

    @SerializedName("onboarding")
    private final BotOnBoarding botOnBoarding;

    @SerializedName("bot_stats")
    private final BotStatistic botStatus;

    @SerializedName("bot_type")
    private final int botType;

    @SerializedName("caller_name")
    private String callerName;

    @SerializedName("caller_name_setting")
    private Boolean callerNameSetting;

    @SerializedName("comment_info")
    private final BotCommentInfo commentInfo;

    @SerializedName("conversation_id")
    private String conversationId;

    @SerializedName("conversation_page")
    private final ConversationPage conversationPage;

    @SerializedName("creator_info")
    private final BotCreatorInfo creatorInfo;

    @SerializedName("disabled")
    private boolean disabled;

    @SerializedName("disabled_tag")
    private String disabledTag;

    @SerializedName("edit_pos")
    private final String editPos;

    @SerializedName("first_met")
    private final FirstMet firstMet;

    @SerializedName("has_conversation")
    private final boolean hasConversation;

    @SerializedName("description_for_human")
    private final String humanDescription;

    @SerializedName("icon_image")
    private BotIconImage iconImage;

    @SerializedName("like_info")
    private LikeInfo likeInfo;

    @SerializedName("model")
    private final ModelItem model;

    @SerializedName("muted")
    private boolean muted;

    @SerializedName("name")
    private String name;

    @SerializedName("private_status")
    private Integer privateStatus;

    @SerializedName("recommend_index")
    private long recommendIndex;

    @SerializedName("share_info")
    private final ShareInfo shareInfo;

    @SerializedName("switch_conf")
    private BotSwitchConfInfo switchConfInfo;

    @SerializedName("voice_type")
    private final SpeakerVoice voice;

    public n() {
        Boolean r1 = Boolean.FALSE;
        this.botId = "";
        this.botMode = -1;
        this.name = "";
        this.hasConversation = false;
        this.conversationId = "";
        this.botOnBoarding = null;
        this.action = null;
        this.muted = false;
        this.botType = 0;
        this.iconImage = null;
        this.creatorInfo = null;
        this.botStatus = null;
        this.bio = "";
        this.privateStatus = 2;
        this.humanDescription = "";
        this.model = null;
        this.voice = null;
        this.editPos = "";
        this.shareInfo = null;
        this.disabled = false;
        this.disabledTag = "";
        this.bgImgUrl = null;
        this.bgImgColor = null;
        this.bgImgUri = null;
        this.bgImgInfo = null;
        this.switchConfInfo = null;
        this.botConf = null;
        this.conversationPage = null;
        this.firstMet = null;
        this.botFeatureLabel = null;
        this.likeInfo = null;
        this.commentInfo = null;
        this.callerName = null;
        this.callerNameSetting = r1;
        this.recommendIndex = 0;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof n) == true) goto L8;
        return false;
    L8:
        n r9 = (n) r8;
        if (Intrinsics.areEqual(this.botId, r9.botId) == true) goto L12;
        return false;
    L12:
        if (this.botMode == r9.botMode) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.name, r9.name) == true) goto L18;
        return false;
    L18:
        if (this.hasConversation == r9.hasConversation) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.conversationId, r9.conversationId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.botOnBoarding, r9.botOnBoarding) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.action, r9.action) == true) goto L30;
        return false;
    L30:
        if (this.muted == r9.muted) goto L33;
        return false;
    L33:
        if (this.botType == r9.botType) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.iconImage, r9.iconImage) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.creatorInfo, r9.creatorInfo) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.botStatus, r9.botStatus) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.bio, r9.bio) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.privateStatus, r9.privateStatus) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.humanDescription, r9.humanDescription) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.model, r9.model) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.voice, r9.voice) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.editPos, r9.editPos) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.shareInfo, r9.shareInfo) == true) goto L66;
        return false;
    L66:
        if (this.disabled == r9.disabled) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.disabledTag, r9.disabledTag) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.bgImgUrl, r9.bgImgUrl) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.bgImgColor, r9.bgImgColor) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.bgImgUri, r9.bgImgUri) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.bgImgInfo, r9.bgImgInfo) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.switchConfInfo, r9.switchConfInfo) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.botConf, r9.botConf) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.conversationPage, r9.conversationPage) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.firstMet, r9.firstMet) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.botFeatureLabel, r9.botFeatureLabel) == true) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.likeInfo, r9.likeInfo) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.commentInfo, r9.commentInfo) == true) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.callerName, r9.callerName) == true) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.callerNameSetting, r9.callerNameSetting) == true) goto L111;
        return false;
    L111:
        if (this.recommendIndex == r9.recommendIndex) goto L113;
        return false;
    L113:
        return true;
    }

    public final String toString() {
        return "ProfileBot(botId=" + this.botId + ", botMode=" + this.botMode + ", name=" + this.name + ", hasConversation=" + this.hasConversation + ", conversationId=" + this.conversationId + ", botOnBoarding=" + this.botOnBoarding + ", action=" + this.action + ", muted=" + this.muted + ", botType=" + this.botType + ", iconImage=" + this.iconImage + ", creatorInfo=" + this.creatorInfo + ", botStatus=" + this.botStatus + ", bio=" + this.bio + ", privateStatus=" + this.privateStatus + ", humanDescription=" + this.humanDescription + ", model=" + this.model + ", voice=" + this.voice + ", editPos=" + this.editPos + ", shareInfo=" + this.shareInfo + ", disabled=" + this.disabled + ", disabledTag=" + this.disabledTag + ", bgImgUrl=" + this.bgImgUrl + ", bgImgColor=" + this.bgImgColor + ", bgImgUri=" + this.bgImgUri + ", bgImgInfo=" + this.bgImgInfo + ", switchConfInfo=" + this.switchConfInfo + ", botConf=" + this.botConf + ", conversationPage=" + this.conversationPage + ", firstMet=" + this.firstMet + ", botFeatureLabel=" + this.botFeatureLabel + ", likeInfo=" + this.likeInfo + ", commentInfo=" + this.commentInfo + ", callerName=" + this.callerName + ", callerNameSetting=" + this.callerNameSetting + ", recommendIndex=" + this.recommendIndex + ')';
    }

    public final boolean b() {
        BgImageInfo r0 = this.bgImgInfo;
        if (r0 == null) goto L7;
        Boolean r1 = r0.getBgImgOpen();
        if (r1 == null) goto L7;
        return r1.booleanValue();
    L7:
        return true;
    }

    public final int hashCode() {
        String r0 = this.botId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.name;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return ((((r3 + r1) * 31) + this.botMode) * 31) + this.botType;
    L5:
        r2 = 0;
        goto L6
    }

    public final boolean p() {
        BotStatusCacheDelegate r0 = BotStatusCacheDelegate.b;
        String r1 = this.botId;
        String r2 = "";
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        if (r0.c(r1) == null) goto L13;
        String r3 = this.botId;
        if (r3 == null) goto L12;
        r2 = r3;
    L12:
        return Intrinsics.areEqual(r0.c(r2), Boolean.TRUE);
    L13:
        Boolean r4 = this.a;
        if (r4 != null) goto L26;
        BotAction r5 = this.action;
        if (r5 == null) goto L24;
        Integer r6 = r5.a();
        if (r6 == null) goto L24;
        if (r6.intValue() != 2) goto L24;
        return true;
    L24:
        return false;
    L26:
        return r4.booleanValue();
    }

    public final boolean q() {
        BotStatusCacheDelegate r0 = BotStatusCacheDelegate.b;
        String r1 = this.botId;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        Boolean r2 = r0.b(r1);
        if (r2 != null) goto L10;
        return false;
    L10:
        return r2.booleanValue();
    }

    public final BotModel z() {
        String r1 = this.botId;
        if (r1 != null) goto L5;
        String r4 = "";
    L6:
        String r5 = this.name;
        BotIconImage r6 = this.iconImage;
        int r2 = this.botType;
        List<BotConfItem> r3 = this.botConf;
        if (r3 == null) goto L10;
        List r7 = CollectionsKt.filterNotNull(r3);
        if (r7 == null) goto L10;
    L11:
        List r35 = r7;
        int r12 = this.botMode;
        ShareInfo r11 = this.shareInfo;
        BotCreatorInfo r14 = this.creatorInfo;
        Integer r13 = this.privateStatus;
        String r10 = this.humanDescription;
        String r8 = this.disabledTag;
        if (r8 == null) goto L36;
        switch(r8.hashCode()) {
            case -314497661: goto L32;
            case -259719452: goto L28;
            case 97295: goto L24;
            case 493044106: goto L20;
            case 1550463001: goto L17;
            default: goto L36;
        };
    L17:
        if (r8.equals("deleted") == false) goto L36;
    L37:
        int r17 = -10;
    L39:
        ModelItem r9 = this.model;
        if (r9 == null) goto L45;
        String r15 = r9.getName();
        if (r15 == null) goto L45;
        String r19 = r15;
    L46:
        ModelItem r16 = this.model;
        if (r16 == null) goto L49;
        long r18 = r16.getModelType();
    L50:
        long r20 = r18;
        ModelItem r21 = this.model;
        if (r21 == null) goto L56;
        String r22 = r21.getModelName();
        if (r22 == null) goto L56;
        String r23 = r22;
    L57:
        ModelItem r24 = this.model;
        List r25 = null;
        if (r24 == null) goto L60;
        Boolean r26 = r24.getTypeWriter();
    L61:
        ModelItem r37 = new ModelItem(r19, r20, r23, r26, null, null, 48, null);
        String r27 = this.editPos;
        boolean r28 = this.muted;
        BotOnBoarding r29 = this.botOnBoarding;
        if (r29 == null) goto L67;
        String r30 = r29.d();
        if (r30 == null) goto L67;
        String r110 = r30;
    L68:
        BotOnBoarding r31 = this.botOnBoarding;
        if (r31 == null) goto L71;
        List r210 = r31.e();
    L72:
        BotOnBoarding r32 = this.botOnBoarding;
        if (r32 == null) goto L78;
        String r33 = r32.b();
        if (r33 == null) goto L78;
        String r211 = r33;
    L79:
        BotOnBoarding r34 = this.botOnBoarding;
        if (r34 == null) goto L82;
        int r212 = r34.a();
    L83:
        BotOnBoarding r36 = this.botOnBoarding;
        if (r36 == null) goto L86;
        r25 = r36.c();
    L86:
        com.larus.im.bean.bot.BotOnBoarding r43 = new com.larus.im.bean.bot.BotOnBoarding(r110, r210, r211, r212, r25);
        String r38 = this.bio;
        SpeakerVoice r39 = this.voice;
        String r40 = this.bgImgUrl;
        String r41 = this.bgImgColor;
        String r42 = this.bgImgUri;
        BgImageInfo r44 = this.bgImgInfo;
        BotSwitchConfInfo r45 = this.switchConfInfo;
        String r46 = this.callerName;
        Boolean r47 = this.callerNameSetting;
        ConversationPage r111 = this.conversationPage;
        int r48 = (int) this.recommendIndex;
        return new BotModel(r4, r5, r6, 0, null, Integer.valueOf(r2), r11, r14, null, null, r111, null, r10, Integer.valueOf(r17), null, r13, r37, r39, r27, r28, Integer.valueOf(r48), null, null, null, r38, null, null, null, null, null, r35, null, r12, r40, r41, null, null, r45, r43, r46, r47, null, false, null, null, this.botFeatureLabel, r42, r44, null, null, null, null, null, null, null, null, null, null, this.likeInfo, null, null, this.commentInfo, null, -1092596968, 1543446040, null);
    L82:
        r212 = 0;
    L78:
        r211 = "";
        goto L79
    L71:
        r210 = null;
    L67:
        r110 = "";
        goto L68
    L60:
        r26 = null;
    L56:
        r23 = "";
        goto L57
    L49:
        r18 = 0;
    L45:
        r19 = "";
        goto L46
    L20:
        if (r8.equals("reviewing") == false) goto L36;
        r17 = -20;
        goto L39
    L24:
        if (r8.equals("ban") == false) goto L36;
        r17 = -30;
        goto L39
    L28:
        if (r8.equals("rollback") == false) goto L36;
        r17 = -50;
        goto L39
    L32:
        if (r8.equals("private") == false) goto L36;
        r17 = -40;
    L36:
        if (this.disabled == true) goto L37;
        r17 = 10;
    L10:
        r7 = CollectionsKt.emptyList();
        goto L11
    L5:
        r4 = r1;
        goto L6
    }

    public final String a() {
        return this.bgImgColor;
    }

    public final String c() {
        return this.bgImgUrl;
    }

    public final String d() {
        return this.bio;
    }

    public final String e() {
        return this.botId;
    }

    public final BotOnBoarding f() {
        return this.botOnBoarding;
    }

    public final BotStatistic g() {
        return this.botStatus;
    }

    public final int h() {
        return this.botType;
    }

    public final String i() {
        return this.conversationId;
    }

    public final ConversationPage j() {
        return this.conversationPage;
    }

    public final BotCreatorInfo k() {
        return this.creatorInfo;
    }

    public final String l() {
        return this.disabledTag;
    }

    public final BotIconImage m() {
        return this.iconImage;
    }

    public final String n() {
        return this.name;
    }

    public final Integer o() {
        return this.privateStatus;
    }

    public final void r(String r1) {
        this.bgImgColor = r1;
    }

    public final void s(BgImageInfo r1) {
        this.bgImgInfo = r1;
    }

    public final void t(String r1) {
        this.bgImgUri = r1;
    }

    public final void u(String r1) {
        this.bgImgUrl = r1;
    }

    public final void v(String r1) {
        this.conversationId = r1;
    }

    public final void w(BotIconImage r1) {
        this.iconImage = r1;
    }

    public final void x(String r1) {
        this.name = r1;
    }

    public final void y(Integer r1) {
        this.privateStatus = r1;
    }
}
