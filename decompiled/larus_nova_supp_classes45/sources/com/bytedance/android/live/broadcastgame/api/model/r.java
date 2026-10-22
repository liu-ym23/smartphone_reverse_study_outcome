package com.bytedance.android.live.broadcastgame.api.model;

import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0002Ö\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001a\u0010\u0018\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010R\u001a\u0010\u001e\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001f\u0010\u0010R\u001a\u0010 \u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u000e\u001a\u0004\b!\u0010\u0010R\u001a\u0010\"\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u000e\u001a\u0004\b#\u0010\u0010R\u001a\u0010$\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u0019\u001a\u0004\b%\u0010\u001bR\u001a\u0010&\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006R\u001a\u0010(\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u000e\u001a\u0004\b)\u0010\u0010R\u001a\u0010*\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\u000e\u001a\u0004\b+\u0010\u0010R\"\u0010-\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010\u0004\u001a\u0004\b2\u0010\u0006R\"\u00103\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010.\u001a\u0004\b4\u00100R\"\u00105\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010.\u001a\u0004\b6\u00100R\"\u00107\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010.\u001a\u0004\b8\u00100R\u001a\u00109\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010\u0004\u001a\u0004\b:\u0010\u0006R\"\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010.\u001a\u0004\b<\u00100R\u001a\u0010=\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010\u000e\u001a\u0004\b>\u0010\u0010R\u001a\u0010?\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b?\u0010\u0019\u001a\u0004\b@\u0010\u001bR\u001a\u0010A\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bA\u0010\u000e\u001a\u0004\bB\u0010\u0010R\u001a\u0010C\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\bC\u0010\u0019\u001a\u0004\bD\u0010\u001bR\u001a\u0010E\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\bE\u0010\u0019\u001a\u0004\bF\u0010\u001bR\u001a\u0010G\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\bG\u0010\u0019\u001a\u0004\bH\u0010\u001bR\u001a\u0010J\u001a\u00020I8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u001a\u0010O\u001a\u00020N8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u001a\u0010T\u001a\u00020S8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR$\u0010X\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bX\u0010\u000e\u001a\u0004\bY\u0010\u0010\"\u0004\bZ\u0010[R\u001a\u0010\\\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\\\u0010\t\u001a\u0004\b]\u0010\u000bR\u001c\u0010^\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b^\u0010\u000e\u001a\u0004\b_\u0010\u0010R\u001a\u0010`\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b`\u0010\u0004\u001a\u0004\ba\u0010\u0006R\u001a\u0010b\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\bb\u0010\u0019\u001a\u0004\bc\u0010\u001bR\u001a\u0010d\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\bd\u0010\u0019\u001a\u0004\be\u0010\u001bR\u001a\u0010f\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\bf\u0010\u0019\u001a\u0004\bg\u0010\u001bR\u001a\u0010h\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bh\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001a\u0010i\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\bi\u0010\u0019\u001a\u0004\b\u0004\u0010\u001bR\u001a\u0010j\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\bj\u0010\t\u001a\u0004\bk\u0010\u000bR\u001a\u0010l\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bl\u0010\u000e\u001a\u0004\bm\u0010\u0010R\u001a\u0010n\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bn\u0010\u000e\u001a\u0004\bo\u0010\u0010R\u001a\u0010p\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bp\u0010\u0004\u001a\u0004\bq\u0010\u0006R\u001a\u0010r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\br\u0010\u0004\u001a\u0004\bs\u0010\u0006R\u001a\u0010t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bt\u0010\u0004\u001a\u0004\bu\u0010\u0006R\u001a\u0010w\u001a\u00020v8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bw\u0010x\u001a\u0004\by\u0010zR\u001a\u0010{\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b{\u0010\u0019\u001a\u0004\b|\u0010\u001bR\u001a\u0010}\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b}\u0010\t\u001a\u0004\b~\u0010\u000bR\u001b\u0010\u007f\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\r\n\u0004\b\u007f\u0010\u0019\u001a\u0005\b\u0080\u0001\u0010\u001bR\u001d\u0010\u0081\u0001\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0081\u0001\u0010\u0019\u001a\u0005\b\u0082\u0001\u0010\u001bR\u001d\u0010\u0083\u0001\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0083\u0001\u0010\u0019\u001a\u0005\b\u0084\u0001\u0010\u001bR\u001d\u0010\u0085\u0001\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0085\u0001\u0010\u0019\u001a\u0005\b\u0086\u0001\u0010\u001bR\u001d\u0010\u0087\u0001\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0087\u0001\u0010\u0004\u001a\u0005\b\u0088\u0001\u0010\u0006R\u001d\u0010\u0089\u0001\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0089\u0001\u0010\u0004\u001a\u0005\b\u008a\u0001\u0010\u0006R\u001d\u0010\u008b\u0001\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u008b\u0001\u0010\u0019\u001a\u0005\b\u008c\u0001\u0010\u001bR\"\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001f\u0010\u0092\u0001\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0092\u0001\u0010\u000e\u001a\u0005\b\u0093\u0001\u0010\u0010R\u001f\u0010\u0094\u0001\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0094\u0001\u0010\u000e\u001a\u0005\b\u0095\u0001\u0010\u0010R\u001f\u0010\u0096\u0001\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0096\u0001\u0010\u000e\u001a\u0005\b\u0097\u0001\u0010\u0010R\u001f\u0010\u0098\u0001\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0098\u0001\u0010\u000e\u001a\u0005\b\u0099\u0001\u0010\u0010R\u001f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u009a\u0001\u0010\u000e\u001a\u0005\b\u009b\u0001\u0010\u0010R\u001f\u0010\u009c\u0001\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u009c\u0001\u0010\u000e\u001a\u0005\b\u009d\u0001\u0010\u0010R\u001f\u0010\u009e\u0001\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u009e\u0001\u0010\u000e\u001a\u0005\b\u009f\u0001\u0010\u0010R\u001f\u0010 \u0001\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b \u0001\u0010\u000e\u001a\u0005\b¡\u0001\u0010\u0010R\"\u0010£\u0001\u001a\u0005\u0018\u00010¢\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b£\u0001\u0010¤\u0001\u001a\u0006\b¥\u0001\u0010¦\u0001R\"\u0010¨\u0001\u001a\u0005\u0018\u00010§\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b¨\u0001\u0010©\u0001\u001a\u0006\bª\u0001\u0010«\u0001R\u001f\u0010¬\u0001\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¬\u0001\u0010\u000e\u001a\u0005\b\u00ad\u0001\u0010\u0010R\u001f\u0010®\u0001\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b®\u0001\u0010\u000e\u001a\u0005\b¯\u0001\u0010\u0010R\u001d\u0010°\u0001\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b°\u0001\u0010\u000e\u001a\u0005\b±\u0001\u0010\u0010RA\u0010´\u0001\u001a$\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010²\u0001j\u0011\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u0001`³\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b´\u0001\u0010µ\u0001\u001a\u0006\b¶\u0001\u0010·\u0001R\u001d\u0010¸\u0001\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¸\u0001\u0010\u0004\u001a\u0005\b¹\u0001\u0010\u0006RA\u0010º\u0001\u001a$\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010²\u0001j\u0011\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u0001`³\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\bº\u0001\u0010µ\u0001\u001a\u0006\b»\u0001\u0010·\u0001R\u001f\u0010¼\u0001\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¼\u0001\u0010\u000e\u001a\u0005\b½\u0001\u0010\u0010R\u001f\u0010¾\u0001\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¾\u0001\u0010\u000e\u001a\u0005\b¿\u0001\u0010\u0010R\u001d\u0010À\u0001\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÀ\u0001\u0010\u0004\u001a\u0005\bÁ\u0001\u0010\u0006R\u001d\u0010Â\u0001\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÂ\u0001\u0010\u000e\u001a\u0005\bÃ\u0001\u0010\u0010R\u001d\u0010Ä\u0001\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÄ\u0001\u0010\u000e\u001a\u0005\bÅ\u0001\u0010\u0010R\u001d\u0010Æ\u0001\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÆ\u0001\u0010\u000e\u001a\u0005\bÇ\u0001\u0010\u0010R\u001d\u0010È\u0001\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÈ\u0001\u0010\u000e\u001a\u0005\bÉ\u0001\u0010\u0010R%\u0010Ê\u0001\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÊ\u0001\u0010.\u001a\u0005\bË\u0001\u00100R&\u0010Í\u0001\u001a\u000b\u0012\u0005\u0012\u00030Ì\u0001\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÍ\u0001\u0010.\u001a\u0005\bÎ\u0001\u00100R\u001d\u0010Ï\u0001\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÏ\u0001\u0010\u0004\u001a\u0005\bÐ\u0001\u0010\u0006R%\u0010Ñ\u0001\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0016\n\u0005\bÑ\u0001\u0010\u0004\u0012\u0006\bÓ\u0001\u0010Ô\u0001\u001a\u0005\bÒ\u0001\u0010\u0006R(\u0010Õ\u0001\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÕ\u0001\u0010\u000e\u001a\u0005\bÖ\u0001\u0010\u0010\"\u0005\b×\u0001\u0010[R \u0010Ø\u0001\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0007\n\u0005\bØ\u0001\u0010.R\u001f\u0010Ù\u0001\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÙ\u0001\u0010\u000e\u001a\u0005\bÚ\u0001\u0010\u0010R\u001f\u0010Û\u0001\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÛ\u0001\u0010\u000e\u001a\u0005\bÜ\u0001\u0010\u0010R\"\u0010Þ\u0001\u001a\u0005\u0018\u00010Ý\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\bÞ\u0001\u0010ß\u0001\u001a\u0006\bà\u0001\u0010á\u0001R!\u0010ã\u0001\u001a\u0005\u0018\u00010â\u00018\u0006X\u0087\u0004¢\u0006\u000f\n\u0006\bã\u0001\u0010ä\u0001\u001a\u0005\bx\u0010å\u0001R\"\u0010ç\u0001\u001a\u0005\u0018\u00010æ\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\bç\u0001\u0010è\u0001\u001a\u0006\bé\u0001\u0010ê\u0001R\u001d\u0010ë\u0001\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bë\u0001\u0010\u0004\u001a\u0005\bì\u0001\u0010\u0006R\u001d\u0010í\u0001\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bí\u0001\u0010\u0004\u001a\u0005\bî\u0001\u0010\u0006R\u001f\u0010ï\u0001\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bï\u0001\u0010\u000e\u001a\u0005\bð\u0001\u0010\u0010R\"\u0010ò\u0001\u001a\u0005\u0018\u00010ñ\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\bò\u0001\u0010ó\u0001\u001a\u0006\bô\u0001\u0010õ\u0001¨\u0006ö\u0001"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/r;", "", "", "game_type", "I", "r", "()I", "", "game_id", "J", "p", "()J", "", "game_name", "Ljava/lang/String;", "q", "()Ljava/lang/String;", "open_type", "getOpen_type", "support_players", "getSupport_players", "orientation", "getOrientation", "", "need_game_desc", "Z", "getNeed_game_desc", "()Z", "game_description_snippet", "getGame_description_snippet", "game_cover", "getGame_cover", "game_video", "getGame_video", "game_package", "getGame_package", "autodownload", "d", "loading_time", "getLoading_time", "loading_text", "getLoading_text", "ab_param_key", "getAb_param_key", "", "url_prefix", "Ljava/util/List;", "L", "()Ljava/util/List;", "repelPanel", "getRepelPanel", "supportLiveScene", "H", "supportChatRoomType", "getSupportChatRoomType", "supportLiveMode", "getSupportLiveMode", "supportLiveRole", "G", "supportLiveRoleV2", "getSupportLiveRoleV2", "bigCover", "getBigCover", "audience_show_loading", "getAudience_show_loading", "audience_loading_text", "getAudience_loading_text", "need_show_rematch_entrance", "getNeed_show_rematch_entrance", "need_local_mix_stream", "getNeed_local_mix_stream", "hide_user_entrance", "u", "Lcom/bytedance/android/live/broadcastgame/api/model/c;", "bubble_config", "Lcom/bytedance/android/live/broadcastgame/api/model/c;", "f", "()Lcom/bytedance/android/live/broadcastgame/api/model/c;", "Lcom/bytedance/android/live/broadcastgame/api/model/a;", "breathing_light_config", "Lcom/bytedance/android/live/broadcastgame/api/model/a;", "e", "()Lcom/bytedance/android/live/broadcastgame/api/model/a;", "Lcom/bytedance/android/live/broadcastgame/api/model/j0;", "red_dot_config", "Lcom/bytedance/android/live/broadcastgame/api/model/j0;", "B", "()Lcom/bytedance/android/live/broadcastgame/api/model/j0;", "game_identifier", "getGame_identifier", "setGame_identifier", "(Ljava/lang/String;)V", "effect_id", "l", "guide_name", "s", "guide_show_count", "t", "loadgame_when_guide", "v", "need_beat", "y", "need_bgmusic", "z", "support_mode", "support_effect_mix_stream", "wmini_game_ttid", "getWmini_game_ttid", "wmini_game_id", "getWmini_game_id", "loading_bg_url", "getLoading_bg_url", "wmini_game_matching_players", "getWmini_game_matching_players", "game_base_on_type", "o", "wtimor_game_repel_panel", "getWtimor_game_repel_panel", "", "anchor_window_threshold", "F", "getAnchor_window_threshold", "()F", "wtimor_delete_start_request", "getWtimor_delete_start_request", "audience_game_start_channel", "getAudience_game_start_channel", "show_anchor_float_entrance", "getShow_anchor_float_entrance", "show_audience_float_entrance", "E", "allow_auto_show_anchor_panel", "getAllow_auto_show_anchor_panel", "allow_auto_show_audience_panel", "getAllow_auto_show_audience_panel", "anchor_panel_limit_frequency", "getAnchor_panel_limit_frequency", "audience_panel_limit_frequency", "getAudience_panel_limit_frequency", "allow_panel_transparency", "getAllow_panel_transparency", "Lcom/bytedance/android/live/broadcastgame/api/model/FloatEntranceStyle;", "float_entrance_style", "Lcom/bytedance/android/live/broadcastgame/api/model/FloatEntranceStyle;", "getFloat_entrance_style", "()Lcom/bytedance/android/live/broadcastgame/api/model/FloatEntranceStyle;", "lynx_channel", "getLynx_channel", "effect_channel", "getEffect_channel", "anchor_effect_resource_url", "getAnchor_effect_resource_url", "audience_effect_resource_url", "getAudience_effect_resource_url", "audience_effect_resource_version", "getAudience_effect_resource_version", "lynx_resource_business_version", "getLynx_resource_business_version", "anchor_lynx_resource_url", "getAnchor_lynx_resource_url", "audience_lynx_resource_url", "getAudience_lynx_resource_url", "Lcom/bytedance/android/live/broadcastgame/api/model/d0;", "min_support_version", "Lcom/bytedance/android/live/broadcastgame/api/model/d0;", "getMin_support_version", "()Lcom/bytedance/android/live/broadcastgame/api/model/d0;", "Lcom/bytedance/android/live/broadcastgame/api/model/a0;", "lynx_fallback_url", "Lcom/bytedance/android/live/broadcastgame/api/model/a0;", "getLynx_fallback_url", "()Lcom/bytedance/android/live/broadcastgame/api/model/a0;", "resource_access_key", "getResource_access_key", "float_entrance_channel", "getFloat_entrance_channel", "schema", "C", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "gameDynamicResources", "Ljava/util/HashMap;", "getGameDynamicResources", "()Ljava/util/HashMap;", "useSZLiveGameFramework", "getUseSZLiveGameFramework", "linkMicTagImages", "getLinkMicTagImages", "interactGameTitle", "getInteractGameTitle", "interactGameImage", "getInteractGameImage", "innerGame", "getInnerGame", "appId", "b", "textIntro", "K", "developer", "j", "appVersion", "c", "sensitivityTip", "D", "Lcom/bytedance/android/live/broadcastgame/api/model/b0;", "mediaIntro", "w", "businessType", "g", "anchorRatio", "getAnchorRatio", "getAnchorRatio$annotations", "()V", "anchorRatioV2", "a", "setAnchorRatioV2", "supportiveEntrance", "gameCardInfo", "m", "desc", "i", "Lcom/bytedance/android/live/broadcastgame/api/model/d;", "chatroomScreencastConfig", "Lcom/bytedance/android/live/broadcastgame/api/model/d;", "h", "()Lcom/bytedance/android/live/broadcastgame/api/model/d;", "Lcom/bytedance/android/live/broadcastgame/api/model/p0;", "singleScreencastConfig", "Lcom/bytedance/android/live/broadcastgame/api/model/p0;", "()Lcom/bytedance/android/live/broadcastgame/api/model/p0;", "Lcom/bytedance/android/live/broadcastgame/api/model/g;", "gameEngineInfo", "Lcom/bytedance/android/live/broadcastgame/api/model/g;", "n", "()Lcom/bytedance/android/live/broadcastgame/api/model/g;", "gameMultiPlayerType", "getGameMultiPlayerType", "dynamicInteractId", "k", "playRule", "A", "Lcom/bytedance/android/live/broadcastgame/api/model/c0;", "microGameInfo", "Lcom/bytedance/android/live/broadcastgame/api/model/c0;", "x", "()Lcom/bytedance/android/live/broadcastgame/api/model/c0;", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r {
    public transient Sticker a;

    @SerializedName("ab_param_key")
    private final String ab_param_key;

    @SerializedName("allow_auto_show_anchor_panel")
    private final boolean allow_auto_show_anchor_panel;

    @SerializedName("allow_auto_show_audience_panel")
    private final boolean allow_auto_show_audience_panel;

    @SerializedName("allow_panel_transparency")
    private final boolean allow_panel_transparency;

    @SerializedName("anchor_ratio")
    private final int anchorRatio;

    @SerializedName("anchor_ratio_v2")
    private String anchorRatioV2;

    @SerializedName("anchor_effect_resource_url")
    private final String anchor_effect_resource_url;

    @SerializedName("anchor_lynx_resource_url")
    private final String anchor_lynx_resource_url;

    @SerializedName("anchor_panel_limit_frequency")
    private final int anchor_panel_limit_frequency;

    @SerializedName("wtimor_game_window_threshold")
    private final float anchor_window_threshold;

    @SerializedName(OpenPlatformBaseDebugger.APP_ID)
    private final String appId;

    @SerializedName("app_version")
    private final String appVersion;

    @SerializedName("audience_effect_resource_url")
    private final String audience_effect_resource_url;

    @SerializedName("effect_resource_version")
    private final String audience_effect_resource_version;

    @SerializedName("to_audience_game_start_channel")
    private final long audience_game_start_channel;

    @SerializedName("audience_loading_text")
    private final String audience_loading_text;

    @SerializedName("audience_lynx_resource_url")
    private final String audience_lynx_resource_url;

    @SerializedName("audience_panel_limit_frequency")
    private final int audience_panel_limit_frequency;

    @SerializedName("audience_show_loading")
    private final boolean audience_show_loading;

    @SerializedName("autodownload")
    private final boolean autodownload;

    @SerializedName("support_pk_end_cover")
    private final String bigCover;

    @SerializedName("breathing_light_config")
    private final com.bytedance.android.live.broadcastgame.api.model.a breathing_light_config;

    @SerializedName("bubble_config")
    private final c bubble_config;

    @SerializedName("business_type")
    private final int businessType;

    @SerializedName("screencast_config")
    private final d chatroomScreencastConfig;

    @SerializedName("desc")
    private final String desc;

    @SerializedName("developer")
    private final String developer;

    @SerializedName("dynamic_interact_id")
    private final int dynamicInteractId;

    @SerializedName("effect_channel")
    private final String effect_channel;

    @SerializedName("effect_id")
    private final long effect_id;

    @SerializedName("float_entrance_channel")
    private final String float_entrance_channel;

    @SerializedName("float_entrance_style")
    private final FloatEntranceStyle float_entrance_style;

    @SerializedName("game_card_extra")
    private final String gameCardInfo;

    @SerializedName("game_dynamic_prefab_resource")
    private final HashMap<String, String> gameDynamicResources;

    @SerializedName("game_engine_info")
    private final g gameEngineInfo;

    @SerializedName("game_multiplayer_type")
    private final int gameMultiPlayerType;

    @SerializedName("wtimor_game_type")
    private final int game_base_on_type;

    @SerializedName("game_cover")
    private final String game_cover;

    @SerializedName("game_description_snippet")
    private final String game_description_snippet;

    @SerializedName("game_id")
    private final long game_id;

    @SerializedName("game_identifier")
    private String game_identifier;

    @SerializedName("game_name")
    private final String game_name;

    @SerializedName("game_package")
    private final String game_package;

    @SerializedName("game_type")
    private final int game_type;

    @SerializedName("game_video")
    private final String game_video;

    @SerializedName("guide_name")
    private final String guide_name;

    @SerializedName("guide_show_count")
    private final int guide_show_count;

    @SerializedName("hide_user_entrance")
    private final boolean hide_user_entrance;

    @SerializedName("inner_game")
    private final int innerGame;

    @SerializedName("interact_game_image")
    private final String interactGameImage;

    @SerializedName("interact_game_title")
    private final String interactGameTitle;

    @SerializedName("link_mic_tag_images")
    private final HashMap<String, String> linkMicTagImages;

    @SerializedName("loadgame_when_guide")
    private final boolean loadgame_when_guide;

    @SerializedName("loading_bg_url")
    private final String loading_bg_url;

    @SerializedName("loading_text")
    private final String loading_text;

    @SerializedName("loading_time")
    private final int loading_time;

    @SerializedName("lynx_channel")
    private final String lynx_channel;

    @SerializedName("lynx_fallback_url")
    private final a0 lynx_fallback_url;

    @SerializedName("lynx_resource_business_version")
    private final String lynx_resource_business_version;

    @SerializedName("media_intro")
    private final List<b0> mediaIntro;

    @SerializedName("micro_game_info")
    private final c0 microGameInfo;

    @SerializedName("min_support_version")
    private final d0 min_support_version;

    @SerializedName("need_beat")
    private final boolean need_beat;

    @SerializedName("need_bgmusic")
    private final boolean need_bgmusic;

    @SerializedName("need_game_desc")
    private final boolean need_game_desc;

    @SerializedName("need_local_mix_stream")
    private final boolean need_local_mix_stream;

    @SerializedName("need_show_rematch_entrance")
    private final boolean need_show_rematch_entrance;

    @SerializedName("open_type")
    private final String open_type;

    @SerializedName("orientation")
    private final int orientation;

    @SerializedName("play_rule")
    private final String playRule;

    @SerializedName("red_dot_config")
    private final j0 red_dot_config;

    @SerializedName("RepelPanel")
    private final int repelPanel;

    @SerializedName("resource_access_key")
    private final String resource_access_key;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("sensitivity_tip")
    private final List<String> sensitivityTip;

    @SerializedName("show_anchor_float_entrance")
    private final boolean show_anchor_float_entrance;

    @SerializedName("show_audience_float_entrance")
    private final boolean show_audience_float_entrance;

    @SerializedName("single_screencast_config")
    private final p0 singleScreencastConfig;

    @SerializedName("support_chatroom_type")
    private final List<Integer> supportChatRoomType;

    @SerializedName("support_live_mode")
    private final List<Integer> supportLiveMode;

    @SerializedName("support_live_role")
    private final int supportLiveRole;

    @SerializedName("support_live_role_v2")
    private final List<Integer> supportLiveRoleV2;

    @SerializedName("support_live_scene")
    private final List<Integer> supportLiveScene;

    @SerializedName("support_effect_mix_stream")
    private final boolean support_effect_mix_stream;

    @SerializedName("support_mode")
    private final int support_mode;

    @SerializedName("support_players")
    private final int support_players;

    @SerializedName("support_live_entrance")
    public List<Long> supportiveEntrance;

    @SerializedName("text_intro")
    private final String textIntro;

    @SerializedName("url_prefix")
    private final List<String> url_prefix;

    @SerializedName("use_sz_live_game_framework")
    private final int useSZLiveGameFramework;

    @SerializedName("wtimor_game_id")
    private final String wmini_game_id;

    @SerializedName("wtimor_game_matching_players")
    private final int wmini_game_matching_players;

    @SerializedName("wtimor_game_ttid")
    private final long wmini_game_ttid;

    @SerializedName("wtimor_delete_start_request")
    private final boolean wtimor_delete_start_request;

    @SerializedName("wtimor_game_repel_panel")
    private final int wtimor_game_repel_panel;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof r) == false) goto L196;
        r r7 = (r) r6;
        if (this.game_type == r7.game_type) goto L8;
        return false;
    L8:
        if (this.game_id == r7.game_id) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.game_name, r7.game_name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.open_type, r7.open_type) == true) goto L14;
        return false;
    L14:
        if (this.support_players == r7.support_players) goto L16;
        return false;
    L16:
        if (this.orientation == r7.orientation) goto L18;
        return false;
    L18:
        if (this.need_game_desc == r7.need_game_desc) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.game_description_snippet, r7.game_description_snippet) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.game_cover, r7.game_cover) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.game_video, r7.game_video) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.game_package, r7.game_package) == true) goto L28;
        return false;
    L28:
        if (this.autodownload == r7.autodownload) goto L30;
        return false;
    L30:
        if (this.loading_time == r7.loading_time) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.loading_text, r7.loading_text) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.ab_param_key, r7.ab_param_key) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.url_prefix, r7.url_prefix) == true) goto L38;
        return false;
    L38:
        if (this.repelPanel == r7.repelPanel) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.supportLiveScene, r7.supportLiveScene) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.supportChatRoomType, r7.supportChatRoomType) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.supportLiveMode, r7.supportLiveMode) == true) goto L46;
        return false;
    L46:
        if (this.supportLiveRole == r7.supportLiveRole) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.supportLiveRoleV2, r7.supportLiveRoleV2) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.bigCover, r7.bigCover) == true) goto L52;
        return false;
    L52:
        if (this.audience_show_loading == r7.audience_show_loading) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.audience_loading_text, r7.audience_loading_text) == true) goto L56;
        return false;
    L56:
        if (this.need_show_rematch_entrance == r7.need_show_rematch_entrance) goto L58;
        return false;
    L58:
        if (this.need_local_mix_stream == r7.need_local_mix_stream) goto L60;
        return false;
    L60:
        if (this.hide_user_entrance == r7.hide_user_entrance) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.bubble_config, r7.bubble_config) == true) goto L64;
        return false;
    L64:
        if (Intrinsics.areEqual(this.breathing_light_config, r7.breathing_light_config) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.red_dot_config, r7.red_dot_config) == true) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.game_identifier, r7.game_identifier) == true) goto L70;
        return false;
    L70:
        if (this.effect_id == r7.effect_id) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.guide_name, r7.guide_name) == true) goto L74;
        return false;
    L74:
        if (this.guide_show_count == r7.guide_show_count) goto L76;
        return false;
    L76:
        if (this.loadgame_when_guide == r7.loadgame_when_guide) goto L78;
        return false;
    L78:
        if (this.need_beat == r7.need_beat) goto L80;
        return false;
    L80:
        if (this.need_bgmusic == r7.need_bgmusic) goto L82;
        return false;
    L82:
        if (this.support_mode == r7.support_mode) goto L84;
        return false;
    L84:
        if (this.support_effect_mix_stream == r7.support_effect_mix_stream) goto L86;
        return false;
    L86:
        if (this.wmini_game_ttid == r7.wmini_game_ttid) goto L88;
        return false;
    L88:
        if (Intrinsics.areEqual(this.wmini_game_id, r7.wmini_game_id) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.loading_bg_url, r7.loading_bg_url) == true) goto L92;
        return false;
    L92:
        if (this.wmini_game_matching_players == r7.wmini_game_matching_players) goto L94;
        return false;
    L94:
        if (this.game_base_on_type == r7.game_base_on_type) goto L96;
        return false;
    L96:
        if (this.wtimor_game_repel_panel == r7.wtimor_game_repel_panel) goto L98;
        return false;
    L98:
        if (Float.compare(this.anchor_window_threshold, r7.anchor_window_threshold) == 0) goto L100;
        return false;
    L100:
        if (this.wtimor_delete_start_request == r7.wtimor_delete_start_request) goto L102;
        return false;
    L102:
        if (this.audience_game_start_channel == r7.audience_game_start_channel) goto L104;
        return false;
    L104:
        if (this.show_anchor_float_entrance == r7.show_anchor_float_entrance) goto L106;
        return false;
    L106:
        if (this.show_audience_float_entrance == r7.show_audience_float_entrance) goto L108;
        return false;
    L108:
        if (this.allow_auto_show_anchor_panel == r7.allow_auto_show_anchor_panel) goto L110;
        return false;
    L110:
        if (this.allow_auto_show_audience_panel == r7.allow_auto_show_audience_panel) goto L112;
        return false;
    L112:
        if (this.anchor_panel_limit_frequency == r7.anchor_panel_limit_frequency) goto L114;
        return false;
    L114:
        if (this.audience_panel_limit_frequency == r7.audience_panel_limit_frequency) goto L116;
        return false;
    L116:
        if (this.allow_panel_transparency == r7.allow_panel_transparency) goto L118;
        return false;
    L118:
        if (Intrinsics.areEqual(this.float_entrance_style, r7.float_entrance_style) == true) goto L120;
        return false;
    L120:
        if (Intrinsics.areEqual(this.lynx_channel, r7.lynx_channel) == true) goto L122;
        return false;
    L122:
        if (Intrinsics.areEqual(this.effect_channel, r7.effect_channel) == true) goto L124;
        return false;
    L124:
        if (Intrinsics.areEqual(this.anchor_effect_resource_url, r7.anchor_effect_resource_url) == true) goto L126;
        return false;
    L126:
        if (Intrinsics.areEqual(this.audience_effect_resource_url, r7.audience_effect_resource_url) == true) goto L128;
        return false;
    L128:
        if (Intrinsics.areEqual(this.audience_effect_resource_version, r7.audience_effect_resource_version) == true) goto L130;
        return false;
    L130:
        if (Intrinsics.areEqual(this.lynx_resource_business_version, r7.lynx_resource_business_version) == true) goto L132;
        return false;
    L132:
        if (Intrinsics.areEqual(this.anchor_lynx_resource_url, r7.anchor_lynx_resource_url) == true) goto L134;
        return false;
    L134:
        if (Intrinsics.areEqual(this.audience_lynx_resource_url, r7.audience_lynx_resource_url) == true) goto L136;
        return false;
    L136:
        if (Intrinsics.areEqual(this.min_support_version, r7.min_support_version) == true) goto L138;
        return false;
    L138:
        if (Intrinsics.areEqual(this.lynx_fallback_url, r7.lynx_fallback_url) == true) goto L140;
        return false;
    L140:
        if (Intrinsics.areEqual(this.resource_access_key, r7.resource_access_key) == true) goto L142;
        return false;
    L142:
        if (Intrinsics.areEqual(this.float_entrance_channel, r7.float_entrance_channel) == true) goto L144;
        return false;
    L144:
        if (Intrinsics.areEqual(this.schema, r7.schema) == true) goto L146;
        return false;
    L146:
        if (Intrinsics.areEqual(this.gameDynamicResources, r7.gameDynamicResources) == true) goto L148;
        return false;
    L148:
        if (this.useSZLiveGameFramework == r7.useSZLiveGameFramework) goto L150;
        return false;
    L150:
        if (Intrinsics.areEqual(this.linkMicTagImages, r7.linkMicTagImages) == true) goto L152;
        return false;
    L152:
        if (Intrinsics.areEqual(this.interactGameTitle, r7.interactGameTitle) == true) goto L154;
        return false;
    L154:
        if (Intrinsics.areEqual(this.interactGameImage, r7.interactGameImage) == true) goto L156;
        return false;
    L156:
        if (this.innerGame == r7.innerGame) goto L158;
        return false;
    L158:
        if (Intrinsics.areEqual(this.appId, r7.appId) == true) goto L160;
        return false;
    L160:
        if (Intrinsics.areEqual(this.textIntro, r7.textIntro) == true) goto L162;
        return false;
    L162:
        if (Intrinsics.areEqual(this.developer, r7.developer) == true) goto L164;
        return false;
    L164:
        if (Intrinsics.areEqual(this.appVersion, r7.appVersion) == true) goto L166;
        return false;
    L166:
        if (Intrinsics.areEqual(this.sensitivityTip, r7.sensitivityTip) == true) goto L168;
        return false;
    L168:
        if (Intrinsics.areEqual(this.mediaIntro, r7.mediaIntro) == true) goto L170;
        return false;
    L170:
        if (this.businessType == r7.businessType) goto L172;
        return false;
    L172:
        if (this.anchorRatio == r7.anchorRatio) goto L174;
        return false;
    L174:
        if (Intrinsics.areEqual(this.anchorRatioV2, r7.anchorRatioV2) == true) goto L176;
        return false;
    L176:
        if (Intrinsics.areEqual(this.supportiveEntrance, r7.supportiveEntrance) == true) goto L178;
        return false;
    L178:
        if (Intrinsics.areEqual(this.gameCardInfo, r7.gameCardInfo) == true) goto L180;
        return false;
    L180:
        if (Intrinsics.areEqual(this.desc, r7.desc) == true) goto L182;
        return false;
    L182:
        if (Intrinsics.areEqual(this.chatroomScreencastConfig, r7.chatroomScreencastConfig) == true) goto L184;
        return false;
    L184:
        if (Intrinsics.areEqual(this.singleScreencastConfig, r7.singleScreencastConfig) == true) goto L186;
        return false;
    L186:
        if (Intrinsics.areEqual(this.gameEngineInfo, r7.gameEngineInfo) == true) goto L188;
        return false;
    L188:
        if (this.gameMultiPlayerType == r7.gameMultiPlayerType) goto L190;
        return false;
    L190:
        if (this.dynamicInteractId == r7.dynamicInteractId) goto L192;
        return false;
    L192:
        if (Intrinsics.areEqual(this.playRule, r7.playRule) == true) goto L194;
        return false;
    L194:
        if (Intrinsics.areEqual(this.microGameInfo, r7.microGameInfo) == true) goto L295;
        return false;
    L295:
        return true;
    L196:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v103, types: [int] */
    /* JADX WARN: Type inference failed for: r1v106, types: [int] */
    /* JADX WARN: Type inference failed for: r1v108, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v110, types: [int] */
    /* JADX WARN: Type inference failed for: r1v112, types: [int] */
    /* JADX WARN: Type inference failed for: r1v25, types: [int] */
    /* JADX WARN: Type inference failed for: r1v251 */
    /* JADX WARN: Type inference failed for: r1v252 */
    /* JADX WARN: Type inference failed for: r1v253 */
    /* JADX WARN: Type inference failed for: r1v254 */
    /* JADX WARN: Type inference failed for: r1v255 */
    /* JADX WARN: Type inference failed for: r1v258 */
    /* JADX WARN: Type inference failed for: r1v259 */
    /* JADX WARN: Type inference failed for: r1v260 */
    /* JADX WARN: Type inference failed for: r1v261 */
    /* JADX WARN: Type inference failed for: r1v267 */
    /* JADX WARN: Type inference failed for: r1v268 */
    /* JADX WARN: Type inference failed for: r1v269 */
    /* JADX WARN: Type inference failed for: r1v271 */
    /* JADX WARN: Type inference failed for: r1v280 */
    /* JADX WARN: Type inference failed for: r1v285 */
    /* JADX WARN: Type inference failed for: r1v288 */
    /* JADX WARN: Type inference failed for: r1v289 */
    /* JADX WARN: Type inference failed for: r1v290 */
    /* JADX WARN: Type inference failed for: r1v291 */
    /* JADX WARN: Type inference failed for: r1v292 */
    /* JADX WARN: Type inference failed for: r1v293 */
    /* JADX WARN: Type inference failed for: r1v294 */
    /* JADX WARN: Type inference failed for: r1v295 */
    /* JADX WARN: Type inference failed for: r1v296 */
    /* JADX WARN: Type inference failed for: r1v297 */
    /* JADX WARN: Type inference failed for: r1v298 */
    /* JADX WARN: Type inference failed for: r1v299 */
    /* JADX WARN: Type inference failed for: r1v300 */
    /* JADX WARN: Type inference failed for: r1v301 */
    /* JADX WARN: Type inference failed for: r1v302 */
    /* JADX WARN: Type inference failed for: r1v54, types: [int] */
    /* JADX WARN: Type inference failed for: r1v59, types: [int] */
    /* JADX WARN: Type inference failed for: r1v61, types: [int] */
    /* JADX WARN: Type inference failed for: r1v63, types: [int] */
    /* JADX WARN: Type inference failed for: r1v82, types: [int] */
    /* JADX WARN: Type inference failed for: r1v84, types: [int] */
    /* JADX WARN: Type inference failed for: r1v86, types: [int] */
    /* JADX WARN: Type inference failed for: r1v89, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [int] */
    /* JADX WARN: Type inference failed for: r4v3 */
    public final int hashCode() {
        int r0 = this.game_type * 31;
        long r1 = this.game_id;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        String r3 = this.game_name;
        int r4 = 0;
        if (r3 == null) goto L5;
        int r5 = r3.hashCode();
    L6:
        int r6 = (r2 + r5) * 31;
        String r7 = this.open_type;
        if (r7 == null) goto L9;
        int r8 = r7.hashCode();
    L10:
        int r9 = (((((r6 + r8) * 31) + this.support_players) * 31) + this.orientation) * 31;
        boolean r11 = this.need_game_desc;
        ?? r12 = 1;
        ?? r13 = r11;
        if (r11 == false) goto L13;
        r13 = 1;
    L13:
        int r14 = (r9 + r13) * 31;
        String r15 = this.game_description_snippet;
        if (r15 == null) goto L16;
        int r16 = r15.hashCode();
    L17:
        int r17 = (r14 + r16) * 31;
        String r18 = this.game_cover;
        if (r18 == null) goto L20;
        int r19 = r18.hashCode();
    L21:
        int r21 = (r17 + r19) * 31;
        String r22 = this.game_video;
        if (r22 == null) goto L24;
        int r23 = r22.hashCode();
    L25:
        int r24 = (r21 + r23) * 31;
        String r25 = this.game_package;
        if (r25 == null) goto L28;
        int r26 = r25.hashCode();
    L29:
        int r27 = (r24 + r26) * 31;
        boolean r28 = this.autodownload;
        ?? r29 = r28;
        if (r28 == false) goto L32;
        r29 = 1;
    L32:
        int r31 = (((r27 + r29) * 31) + this.loading_time) * 31;
        String r32 = this.loading_text;
        if (r32 == null) goto L35;
        int r33 = r32.hashCode();
    L36:
        int r34 = (r31 + r33) * 31;
        String r35 = this.ab_param_key;
        if (r35 == null) goto L39;
        int r36 = r35.hashCode();
    L40:
        int r37 = (r34 + r36) * 31;
        List<String> r38 = this.url_prefix;
        if (r38 == null) goto L43;
        int r39 = r38.hashCode();
    L44:
        int r41 = (((r37 + r39) * 31) + this.repelPanel) * 31;
        List<Integer> r42 = this.supportLiveScene;
        if (r42 == null) goto L47;
        int r43 = r42.hashCode();
    L48:
        int r44 = (r41 + r43) * 31;
        List<Integer> r45 = this.supportChatRoomType;
        if (r45 == null) goto L51;
        int r46 = r45.hashCode();
    L52:
        int r47 = (r44 + r46) * 31;
        List<Integer> r48 = this.supportLiveMode;
        if (r48 == null) goto L55;
        int r49 = r48.hashCode();
    L56:
        int r51 = (((r47 + r49) * 31) + this.supportLiveRole) * 31;
        List<Integer> r52 = this.supportLiveRoleV2;
        if (r52 == null) goto L59;
        int r53 = r52.hashCode();
    L60:
        int r54 = (r51 + r53) * 31;
        String r55 = this.bigCover;
        if (r55 == null) goto L63;
        int r56 = r55.hashCode();
    L64:
        int r57 = (r54 + r56) * 31;
        boolean r58 = this.audience_show_loading;
        ?? r59 = r58;
        if (r58 == false) goto L67;
        r59 = 1;
    L67:
        int r61 = (r57 + r59) * 31;
        String r62 = this.audience_loading_text;
        if (r62 == null) goto L70;
        int r63 = r62.hashCode();
    L71:
        int r64 = (r61 + r63) * 31;
        boolean r65 = this.need_show_rematch_entrance;
        ?? r66 = r65;
        if (r65 == false) goto L74;
        r66 = 1;
    L74:
        int r67 = (r64 + r66) * 31;
        boolean r68 = this.need_local_mix_stream;
        ?? r69 = r68;
        if (r68 == false) goto L77;
        r69 = 1;
    L77:
        int r71 = (r67 + r69) * 31;
        boolean r72 = this.hide_user_entrance;
        ?? r73 = r72;
        if (r72 == false) goto L80;
        r73 = 1;
    L80:
        int r74 = (r71 + r73) * 31;
        c r75 = this.bubble_config;
        if (r75 == null) goto L83;
        int r76 = r75.hashCode();
    L84:
        int r77 = (r74 + r76) * 31;
        com.bytedance.android.live.broadcastgame.api.model.a r78 = this.breathing_light_config;
        if (r78 == null) goto L87;
        int r79 = r78.hashCode();
    L88:
        int r81 = (r77 + r79) * 31;
        j0 r82 = this.red_dot_config;
        if (r82 == null) goto L91;
        int r83 = r82.hashCode();
    L92:
        int r84 = (r81 + r83) * 31;
        String r85 = this.game_identifier;
        if (r85 == null) goto L95;
        int r86 = r85.hashCode();
    L96:
        long r87 = this.effect_id;
        int r88 = (((r84 + r86) * 31) + ((int) (r87 ^ (r87 >>> 32)))) * 31;
        String r89 = this.guide_name;
        if (r89 == null) goto L99;
        int r91 = r89.hashCode();
    L100:
        int r92 = (((r88 + r91) * 31) + this.guide_show_count) * 31;
        boolean r93 = this.loadgame_when_guide;
        ?? r94 = r93;
        if (r93 == false) goto L103;
        r94 = 1;
    L103:
        int r95 = (r92 + r94) * 31;
        boolean r96 = this.need_beat;
        ?? r97 = r96;
        if (r96 == false) goto L106;
        r97 = 1;
    L106:
        int r98 = (r95 + r97) * 31;
        boolean r99 = this.need_bgmusic;
        ?? r100 = r99;
        if (r99 == false) goto L109;
        r100 = 1;
    L109:
        int r101 = (((r98 + r100) * 31) + this.support_mode) * 31;
        boolean r102 = this.support_effect_mix_stream;
        ?? r103 = r102;
        if (r102 == false) goto L112;
        r103 = 1;
    L112:
        long r104 = this.wmini_game_ttid;
        int r105 = (((r101 + r103) * 31) + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        String r106 = this.wmini_game_id;
        if (r106 == null) goto L115;
        int r107 = r106.hashCode();
    L116:
        int r108 = (r105 + r107) * 31;
        String r109 = this.loading_bg_url;
        if (r109 == null) goto L119;
        int r110 = r109.hashCode();
    L120:
        int r111 = (((((((((r108 + r110) * 31) + this.wmini_game_matching_players) * 31) + this.game_base_on_type) * 31) + this.wtimor_game_repel_panel) * 31) + Float.floatToIntBits(this.anchor_window_threshold)) * 31;
        boolean r112 = this.wtimor_delete_start_request;
        ?? r113 = r112;
        if (r112 == false) goto L123;
        r113 = 1;
    L123:
        long r114 = this.audience_game_start_channel;
        int r115 = (((r111 + r113) * 31) + ((int) (r114 ^ (r114 >>> 32)))) * 31;
        boolean r116 = this.show_anchor_float_entrance;
        ?? r117 = r116;
        if (r116 == false) goto L126;
        r117 = 1;
    L126:
        int r118 = (r115 + r117) * 31;
        boolean r119 = this.show_audience_float_entrance;
        ?? r120 = r119;
        if (r119 == false) goto L129;
        r120 = 1;
    L129:
        int r121 = (r118 + r120) * 31;
        boolean r122 = this.allow_auto_show_anchor_panel;
        ?? r123 = r122;
        if (r122 == false) goto L132;
        r123 = 1;
    L132:
        int r124 = (r121 + r123) * 31;
        boolean r125 = this.allow_auto_show_audience_panel;
        ?? r126 = r125;
        if (r125 == false) goto L135;
        r126 = 1;
    L135:
        int r127 = (((((r124 + r126) * 31) + this.anchor_panel_limit_frequency) * 31) + this.audience_panel_limit_frequency) * 31;
        boolean r128 = this.allow_panel_transparency;
        if (r128 == true) goto L139;
        r12 = r128;
    L139:
        int r129 = (r127 + r12) * 31;
        FloatEntranceStyle r130 = this.float_entrance_style;
        if (r130 == null) goto L142;
        int r131 = r130.hashCode();
    L143:
        int r132 = (r129 + r131) * 31;
        String r133 = this.lynx_channel;
        if (r133 == null) goto L146;
        int r134 = r133.hashCode();
    L147:
        int r135 = (r132 + r134) * 31;
        String r136 = this.effect_channel;
        if (r136 == null) goto L150;
        int r137 = r136.hashCode();
    L151:
        int r138 = (r135 + r137) * 31;
        String r139 = this.anchor_effect_resource_url;
        if (r139 == null) goto L154;
        int r140 = r139.hashCode();
    L155:
        int r141 = (r138 + r140) * 31;
        String r142 = this.audience_effect_resource_url;
        if (r142 == null) goto L158;
        int r143 = r142.hashCode();
    L159:
        int r144 = (r141 + r143) * 31;
        String r145 = this.audience_effect_resource_version;
        if (r145 == null) goto L162;
        int r146 = r145.hashCode();
    L163:
        int r147 = (r144 + r146) * 31;
        String r148 = this.lynx_resource_business_version;
        if (r148 == null) goto L166;
        int r149 = r148.hashCode();
    L167:
        int r150 = (r147 + r149) * 31;
        String r151 = this.anchor_lynx_resource_url;
        if (r151 == null) goto L170;
        int r152 = r151.hashCode();
    L171:
        int r153 = (r150 + r152) * 31;
        String r154 = this.audience_lynx_resource_url;
        if (r154 == null) goto L174;
        int r155 = r154.hashCode();
    L175:
        int r156 = (r153 + r155) * 31;
        d0 r157 = this.min_support_version;
        if (r157 == null) goto L178;
        int r158 = r157.hashCode();
    L179:
        int r159 = (r156 + r158) * 31;
        a0 r160 = this.lynx_fallback_url;
        if (r160 == null) goto L182;
        int r161 = r160.hashCode();
    L183:
        int r162 = (r159 + r161) * 31;
        String r163 = this.resource_access_key;
        if (r163 == null) goto L186;
        int r164 = r163.hashCode();
    L187:
        int r165 = (r162 + r164) * 31;
        String r166 = this.float_entrance_channel;
        if (r166 == null) goto L190;
        int r167 = r166.hashCode();
    L191:
        int r168 = (r165 + r167) * 31;
        String r169 = this.schema;
        if (r169 == null) goto L194;
        int r170 = r169.hashCode();
    L195:
        int r171 = (r168 + r170) * 31;
        HashMap<String, String> r172 = this.gameDynamicResources;
        if (r172 == null) goto L198;
        int r173 = r172.hashCode();
    L199:
        int r174 = (((r171 + r173) * 31) + this.useSZLiveGameFramework) * 31;
        HashMap<String, String> r175 = this.linkMicTagImages;
        if (r175 == null) goto L202;
        int r176 = r175.hashCode();
    L203:
        int r177 = (r174 + r176) * 31;
        String r178 = this.interactGameTitle;
        if (r178 == null) goto L206;
        int r179 = r178.hashCode();
    L207:
        int r180 = (r177 + r179) * 31;
        String r181 = this.interactGameImage;
        if (r181 == null) goto L210;
        int r182 = r181.hashCode();
    L211:
        int r183 = (((r180 + r182) * 31) + this.innerGame) * 31;
        String r184 = this.appId;
        if (r184 == null) goto L214;
        int r185 = r184.hashCode();
    L215:
        int r186 = (r183 + r185) * 31;
        String r187 = this.textIntro;
        if (r187 == null) goto L218;
        int r188 = r187.hashCode();
    L219:
        int r189 = (r186 + r188) * 31;
        String r190 = this.developer;
        if (r190 == null) goto L222;
        int r191 = r190.hashCode();
    L223:
        int r192 = (r189 + r191) * 31;
        String r193 = this.appVersion;
        if (r193 == null) goto L226;
        int r194 = r193.hashCode();
    L227:
        int r195 = (r192 + r194) * 31;
        List<String> r196 = this.sensitivityTip;
        if (r196 == null) goto L230;
        int r197 = r196.hashCode();
    L231:
        int r198 = (r195 + r197) * 31;
        List<b0> r199 = this.mediaIntro;
        if (r199 == null) goto L234;
        int r200 = r199.hashCode();
    L235:
        int r201 = (((((r198 + r200) * 31) + this.businessType) * 31) + this.anchorRatio) * 31;
        String r202 = this.anchorRatioV2;
        if (r202 == null) goto L238;
        int r203 = r202.hashCode();
    L239:
        int r204 = (r201 + r203) * 31;
        List<Long> r205 = this.supportiveEntrance;
        if (r205 == null) goto L242;
        int r206 = r205.hashCode();
    L243:
        int r207 = (r204 + r206) * 31;
        String r208 = this.gameCardInfo;
        if (r208 == null) goto L246;
        int r209 = r208.hashCode();
    L247:
        int r210 = (r207 + r209) * 31;
        String r211 = this.desc;
        if (r211 == null) goto L250;
        int r212 = r211.hashCode();
    L251:
        int r213 = (r210 + r212) * 31;
        d r214 = this.chatroomScreencastConfig;
        if (r214 == null) goto L254;
        int r215 = r214.hashCode();
    L255:
        int r216 = (r213 + r215) * 31;
        p0 r217 = this.singleScreencastConfig;
        if (r217 == null) goto L258;
        int r218 = r217.hashCode();
    L259:
        int r219 = (r216 + r218) * 31;
        g r220 = this.gameEngineInfo;
        if (r220 == null) goto L262;
        int r221 = r220.hashCode();
    L263:
        int r222 = (((((r219 + r221) * 31) + this.gameMultiPlayerType) * 31) + this.dynamicInteractId) * 31;
        String r223 = this.playRule;
        if (r223 == null) goto L266;
        int r224 = r223.hashCode();
    L267:
        int r225 = (r222 + r224) * 31;
        c0 r226 = this.microGameInfo;
        if (r226 == null) goto L271;
        r4 = r226.hashCode();
    L271:
        return r225 + r4;
    L266:
        r224 = 0;
        goto L267
    L262:
        r221 = 0;
        goto L263
    L258:
        r218 = 0;
        goto L259
    L254:
        r215 = 0;
        goto L255
    L250:
        r212 = 0;
        goto L251
    L246:
        r209 = 0;
        goto L247
    L242:
        r206 = 0;
        goto L243
    L238:
        r203 = 0;
        goto L239
    L234:
        r200 = 0;
        goto L235
    L230:
        r197 = 0;
        goto L231
    L226:
        r194 = 0;
        goto L227
    L222:
        r191 = 0;
        goto L223
    L218:
        r188 = 0;
        goto L219
    L214:
        r185 = 0;
        goto L215
    L210:
        r182 = 0;
        goto L211
    L206:
        r179 = 0;
        goto L207
    L202:
        r176 = 0;
        goto L203
    L198:
        r173 = 0;
        goto L199
    L194:
        r170 = 0;
        goto L195
    L190:
        r167 = 0;
        goto L191
    L186:
        r164 = 0;
        goto L187
    L182:
        r161 = 0;
        goto L183
    L178:
        r158 = 0;
        goto L179
    L174:
        r155 = 0;
        goto L175
    L170:
        r152 = 0;
        goto L171
    L166:
        r149 = 0;
        goto L167
    L162:
        r146 = 0;
        goto L163
    L158:
        r143 = 0;
        goto L159
    L154:
        r140 = 0;
        goto L155
    L150:
        r137 = 0;
        goto L151
    L146:
        r134 = 0;
        goto L147
    L142:
        r131 = 0;
        goto L143
    L119:
        r110 = 0;
        goto L120
    L115:
        r107 = 0;
        goto L116
    L99:
        r91 = 0;
        goto L100
    L95:
        r86 = 0;
        goto L96
    L91:
        r83 = 0;
        goto L92
    L87:
        r79 = 0;
        goto L88
    L83:
        r76 = 0;
        goto L84
    L70:
        r63 = 0;
        goto L71
    L63:
        r56 = 0;
        goto L64
    L59:
        r53 = 0;
        goto L60
    L55:
        r49 = 0;
        goto L56
    L51:
        r46 = 0;
        goto L52
    L47:
        r43 = 0;
        goto L48
    L43:
        r39 = 0;
        goto L44
    L39:
        r36 = 0;
        goto L40
    L35:
        r33 = 0;
        goto L36
    L28:
        r26 = 0;
        goto L29
    L24:
        r23 = 0;
        goto L25
    L20:
        r19 = 0;
        goto L21
    L16:
        r16 = 0;
        goto L17
    L9:
        r8 = 0;
        goto L10
    L5:
        r5 = 0;
        goto L6
    }

    public final String toString() {
        return "InteractGameExtra(game_type=" + this.game_type + ", game_id=" + this.game_id + ", game_name=" + this.game_name + ", open_type=" + this.open_type + ", support_players=" + this.support_players + ", orientation=" + this.orientation + ", need_game_desc=" + this.need_game_desc + ", game_description_snippet=" + this.game_description_snippet + ", game_cover=" + this.game_cover + ", game_video=" + this.game_video + ", game_package=" + this.game_package + ", autodownload=" + this.autodownload + ", loading_time=" + this.loading_time + ", loading_text=" + this.loading_text + ", ab_param_key=" + this.ab_param_key + ", url_prefix=" + this.url_prefix + ", repelPanel=" + this.repelPanel + ", supportLiveScene=" + this.supportLiveScene + ", supportChatRoomType=" + this.supportChatRoomType + ", supportLiveMode=" + this.supportLiveMode + ", supportLiveRole=" + this.supportLiveRole + ", supportLiveRoleV2=" + this.supportLiveRoleV2 + ", bigCover=" + this.bigCover + ", audience_show_loading=" + this.audience_show_loading + ", audience_loading_text=" + this.audience_loading_text + ", need_show_rematch_entrance=" + this.need_show_rematch_entrance + ", need_local_mix_stream=" + this.need_local_mix_stream + ", hide_user_entrance=" + this.hide_user_entrance + ", bubble_config=" + this.bubble_config + ", breathing_light_config=" + this.breathing_light_config + ", red_dot_config=" + this.red_dot_config + ", game_identifier=" + this.game_identifier + ", effect_id=" + this.effect_id + ", guide_name=" + this.guide_name + ", guide_show_count=" + this.guide_show_count + ", loadgame_when_guide=" + this.loadgame_when_guide + ", need_beat=" + this.need_beat + ", need_bgmusic=" + this.need_bgmusic + ", support_mode=" + this.support_mode + ", support_effect_mix_stream=" + this.support_effect_mix_stream + ", wmini_game_ttid=" + this.wmini_game_ttid + ", wmini_game_id=" + this.wmini_game_id + ", loading_bg_url=" + this.loading_bg_url + ", wmini_game_matching_players=" + this.wmini_game_matching_players + ", game_base_on_type=" + this.game_base_on_type + ", wtimor_game_repel_panel=" + this.wtimor_game_repel_panel + ", anchor_window_threshold=" + this.anchor_window_threshold + ", wtimor_delete_start_request=" + this.wtimor_delete_start_request + ", audience_game_start_channel=" + this.audience_game_start_channel + ", show_anchor_float_entrance=" + this.show_anchor_float_entrance + ", show_audience_float_entrance=" + this.show_audience_float_entrance + ", allow_auto_show_anchor_panel=" + this.allow_auto_show_anchor_panel + ", allow_auto_show_audience_panel=" + this.allow_auto_show_audience_panel + ", anchor_panel_limit_frequency=" + this.anchor_panel_limit_frequency + ", audience_panel_limit_frequency=" + this.audience_panel_limit_frequency + ", allow_panel_transparency=" + this.allow_panel_transparency + ", float_entrance_style=" + this.float_entrance_style + ", lynx_channel=" + this.lynx_channel + ", effect_channel=" + this.effect_channel + ", anchor_effect_resource_url=" + this.anchor_effect_resource_url + ", audience_effect_resource_url=" + this.audience_effect_resource_url + ", audience_effect_resource_version=" + this.audience_effect_resource_version + ", lynx_resource_business_version=" + this.lynx_resource_business_version + ", anchor_lynx_resource_url=" + this.anchor_lynx_resource_url + ", audience_lynx_resource_url=" + this.audience_lynx_resource_url + ", min_support_version=" + this.min_support_version + ", lynx_fallback_url=" + this.lynx_fallback_url + ", resource_access_key=" + this.resource_access_key + ", float_entrance_channel=" + this.float_entrance_channel + ", schema=" + this.schema + ", gameDynamicResources=" + this.gameDynamicResources + ", useSZLiveGameFramework=" + this.useSZLiveGameFramework + ", linkMicTagImages=" + this.linkMicTagImages + ", interactGameTitle=" + this.interactGameTitle + ", interactGameImage=" + this.interactGameImage + ", innerGame=" + this.innerGame + ", appId=" + this.appId + ", textIntro=" + this.textIntro + ", developer=" + this.developer + ", appVersion=" + this.appVersion + ", sensitivityTip=" + this.sensitivityTip + ", mediaIntro=" + this.mediaIntro + ", businessType=" + this.businessType + ", anchorRatio=" + this.anchorRatio + ", anchorRatioV2=" + this.anchorRatioV2 + ", supportiveEntrance=" + this.supportiveEntrance + ", gameCardInfo=" + this.gameCardInfo + ", desc=" + this.desc + ", chatroomScreencastConfig=" + this.chatroomScreencastConfig + ", singleScreencastConfig=" + this.singleScreencastConfig + ", gameEngineInfo=" + this.gameEngineInfo + ", gameMultiPlayerType=" + this.gameMultiPlayerType + ", dynamicInteractId=" + this.dynamicInteractId + ", playRule=" + this.playRule + ", microGameInfo=" + this.microGameInfo + ")";
    }

    public final String A() {
        return this.playRule;
    }

    public final j0 B() {
        return this.red_dot_config;
    }

    public final String C() {
        return this.schema;
    }

    public final List<String> D() {
        return this.sensitivityTip;
    }

    public final boolean E() {
        return this.show_audience_float_entrance;
    }

    public final p0 F() {
        return this.singleScreencastConfig;
    }

    public final int G() {
        return this.supportLiveRole;
    }

    public final List<Integer> H() {
        return this.supportLiveScene;
    }

    public final boolean I() {
        return this.support_effect_mix_stream;
    }

    public final int J() {
        return this.support_mode;
    }

    public final String K() {
        return this.textIntro;
    }

    public final List<String> L() {
        return this.url_prefix;
    }

    public final String a() {
        return this.anchorRatioV2;
    }

    public final String b() {
        return this.appId;
    }

    public final String c() {
        return this.appVersion;
    }

    public final boolean d() {
        return this.autodownload;
    }

    public final com.bytedance.android.live.broadcastgame.api.model.a e() {
        return this.breathing_light_config;
    }

    public final c f() {
        return this.bubble_config;
    }

    public final int g() {
        return this.businessType;
    }

    public final d h() {
        return this.chatroomScreencastConfig;
    }

    public final String i() {
        return this.desc;
    }

    public final String j() {
        return this.developer;
    }

    public final int k() {
        return this.dynamicInteractId;
    }

    public final long l() {
        return this.effect_id;
    }

    public final String m() {
        return this.gameCardInfo;
    }

    public final g n() {
        return this.gameEngineInfo;
    }

    public final int o() {
        return this.game_base_on_type;
    }

    public final long p() {
        return this.game_id;
    }

    public final String q() {
        return this.game_name;
    }

    public final int r() {
        return this.game_type;
    }

    public final String s() {
        return this.guide_name;
    }

    public final int t() {
        return this.guide_show_count;
    }

    public final boolean u() {
        return this.hide_user_entrance;
    }

    public final boolean v() {
        return this.loadgame_when_guide;
    }

    public final List<b0> w() {
        return this.mediaIntro;
    }

    public final c0 x() {
        return this.microGameInfo;
    }

    public final boolean y() {
        return this.need_beat;
    }

    public final boolean z() {
        return this.need_bgmusic;
    }
}
