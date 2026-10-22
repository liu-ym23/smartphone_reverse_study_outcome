package com.bytedance.android.annie.param;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.method.abs.GetAppInfoResultModel;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\u0013\n\u0002\u0010\u0007\n\u0002\by\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\bf\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR\"\u0010(\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0014\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018R$\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00102\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0004\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\bR\"\u00105\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0004\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\bR\"\u00108\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0004\u001a\u0004\b9\u0010\u0006\"\u0004\b:\u0010\bR\"\u0010;\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010\u0004\u001a\u0004\b<\u0010\u0006\"\u0004\b=\u0010\bR\"\u0010>\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010\u0004\u001a\u0004\b?\u0010\u0006\"\u0004\b@\u0010\bR\"\u0010B\u001a\u00020A8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010H\u001a\u00020A8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010C\u001a\u0004\bI\u0010E\"\u0004\bJ\u0010GR\"\u0010K\u001a\u00020A8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010C\u001a\u0004\b\u0014\u0010E\"\u0004\bL\u0010GR0\u0010N\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010M8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR0\u0010T\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010M8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bT\u0010O\u001a\u0004\bU\u0010Q\"\u0004\bV\u0010SR0\u0010W\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010M8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bW\u0010O\u001a\u0004\bX\u0010Q\"\u0004\bY\u0010SR\"\u0010Z\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bZ\u0010\u0004\u001a\u0004\b[\u0010\u0006\"\u0004\b\\\u0010\bR\u001a\u0010]\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b]\u0010\u0004\u001a\u0004\b^\u0010\u0006R\u001a\u0010_\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b_\u0010\u0004\u001a\u0004\b`\u0010\u0006R\"\u0010b\u001a\u00020a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bb\u0010^\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\"\u0010g\u001a\u00020a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bg\u0010^\u001a\u0004\bh\u0010d\"\u0004\bi\u0010fR\"\u0010j\u001a\u00020a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bj\u0010^\u001a\u0004\bk\u0010d\"\u0004\bl\u0010fR\"\u0010m\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bm\u0010\u0014\u001a\u0004\bn\u0010\u0016\"\u0004\bo\u0010\u0018R\"\u0010p\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bp\u0010\u0014\u001a\u0004\bq\u0010\u0016\"\u0004\br\u0010\u0018R\"\u0010s\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bs\u0010\u0014\u001a\u0004\bt\u0010\u0016\"\u0004\bu\u0010\u0018R\"\u0010v\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bv\u0010\u0014\u001a\u0004\bw\u0010\u0016\"\u0004\bx\u0010\u0018R\"\u0010y\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\by\u0010\u0014\u001a\u0004\bz\u0010\u0016\"\u0004\b{\u0010\u0018R\"\u0010|\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b|\u0010\u0014\u001a\u0004\b}\u0010\u0016\"\u0004\b~\u0010\u0018R\u001b\u0010\u007f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\b\u007f\u0010\u0004\u001a\u0005\b\u0080\u0001\u0010\u0006R&\u0010\u0081\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0081\u0001\u0010\u0004\u001a\u0005\b\u0082\u0001\u0010\u0006\"\u0005\b\u0083\u0001\u0010\bR&\u0010\u0084\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0084\u0001\u0010\u0004\u001a\u0005\b\u0085\u0001\u0010\u0006\"\u0005\b\u0086\u0001\u0010\bR&\u0010\u0087\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0087\u0001\u0010\u0004\u001a\u0005\b\u0088\u0001\u0010\u0006\"\u0005\b\u0089\u0001\u0010\bR&\u0010\u008a\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008a\u0001\u0010\u0004\u001a\u0005\b\u008b\u0001\u0010\u0006\"\u0005\b\u008c\u0001\u0010\bR&\u0010\u008d\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008d\u0001\u0010\u0004\u001a\u0005\b\u008e\u0001\u0010\u0006\"\u0005\b\u008f\u0001\u0010\bR&\u0010\u0090\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0090\u0001\u0010\u0004\u001a\u0005\b\u0091\u0001\u0010\u0006\"\u0005\b\u0092\u0001\u0010\bR&\u0010\u0093\u0001\u001a\u00020a8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0093\u0001\u0010^\u001a\u0005\b\u0094\u0001\u0010d\"\u0005\b\u0095\u0001\u0010fR&\u0010\u0096\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0096\u0001\u0010\u0004\u001a\u0005\b\u0097\u0001\u0010\u0006\"\u0005\b\u0098\u0001\u0010\bR&\u0010\u0099\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0099\u0001\u0010\u0004\u001a\u0005\b\u009a\u0001\u0010\u0006\"\u0005\b\u009b\u0001\u0010\bR&\u0010\u009c\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009c\u0001\u0010\u0004\u001a\u0005\b\u009d\u0001\u0010\u0006\"\u0005\b\u009e\u0001\u0010\bR&\u0010\u009f\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009f\u0001\u0010\u0004\u001a\u0005\b \u0001\u0010\u0006\"\u0005\b¡\u0001\u0010\bR&\u0010¢\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¢\u0001\u0010\u0004\u001a\u0005\b£\u0001\u0010\u0006\"\u0005\b¤\u0001\u0010\bR&\u0010¥\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¥\u0001\u0010\u0004\u001a\u0005\b¦\u0001\u0010\u0006\"\u0005\b§\u0001\u0010\bR&\u0010¨\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¨\u0001\u0010\u0004\u001a\u0005\b©\u0001\u0010\u0006\"\u0005\bª\u0001\u0010\bR&\u0010«\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b«\u0001\u0010\u0004\u001a\u0005\b¬\u0001\u0010\u0006\"\u0005\b\u00ad\u0001\u0010\bR&\u0010®\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b®\u0001\u0010\u0004\u001a\u0005\b¯\u0001\u0010\u0006\"\u0005\b°\u0001\u0010\bR&\u0010±\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b±\u0001\u0010\u0004\u001a\u0005\b²\u0001\u0010\u0006\"\u0005\b³\u0001\u0010\bR&\u0010´\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b´\u0001\u0010\u0004\u001a\u0005\bµ\u0001\u0010\u0006\"\u0005\b¶\u0001\u0010\bR&\u0010·\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b·\u0001\u0010\u0004\u001a\u0005\b¸\u0001\u0010\u0006\"\u0005\b¹\u0001\u0010\bR&\u0010º\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bº\u0001\u0010\u0004\u001a\u0005\b»\u0001\u0010\u0006\"\u0005\b¼\u0001\u0010\bR&\u0010½\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b½\u0001\u0010\u0004\u001a\u0005\b¾\u0001\u0010\u0006\"\u0005\b¿\u0001\u0010\bR&\u0010À\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÀ\u0001\u0010\u0004\u001a\u0005\bÁ\u0001\u0010\u0006\"\u0005\bÂ\u0001\u0010\bR&\u0010Ã\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÃ\u0001\u0010\u0004\u001a\u0005\bÄ\u0001\u0010\u0006\"\u0005\bÅ\u0001\u0010\bR&\u0010Æ\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÆ\u0001\u0010\u0004\u001a\u0005\bÇ\u0001\u0010\u0006\"\u0005\bÈ\u0001\u0010\bR&\u0010É\u0001\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÉ\u0001\u0010\u0014\u001a\u0005\bÊ\u0001\u0010\u0016\"\u0005\bË\u0001\u0010\u0018R&\u0010Ì\u0001\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÌ\u0001\u0010\u0014\u001a\u0005\bÍ\u0001\u0010\u0016\"\u0005\bÎ\u0001\u0010\u0018R&\u0010Ï\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÏ\u0001\u0010\u0004\u001a\u0005\bÐ\u0001\u0010\u0006\"\u0005\bÑ\u0001\u0010\bR&\u0010Ò\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÒ\u0001\u0010\u0004\u001a\u0005\bÓ\u0001\u0010\u0006\"\u0005\bÔ\u0001\u0010\bR4\u0010Õ\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010M8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÕ\u0001\u0010O\u001a\u0005\bÖ\u0001\u0010Q\"\u0005\b×\u0001\u0010SR&\u0010Ø\u0001\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bØ\u0001\u0010\u0014\u001a\u0005\bÙ\u0001\u0010\u0016\"\u0005\bÚ\u0001\u0010\u0018R*\u0010Ü\u0001\u001a\u00030Û\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÜ\u0001\u0010¾\u0001\u001a\u0006\bÝ\u0001\u0010Þ\u0001\"\u0006\bß\u0001\u0010à\u0001R6\u0010á\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010M8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bá\u0001\u0010O\u001a\u0005\bâ\u0001\u0010Q\"\u0005\bã\u0001\u0010SR&\u0010ä\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bä\u0001\u0010\u0004\u001a\u0005\bå\u0001\u0010\u0006\"\u0005\bæ\u0001\u0010\bR&\u0010ç\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bç\u0001\u0010\u0004\u001a\u0005\bè\u0001\u0010\u0006\"\u0005\bé\u0001\u0010\bR&\u0010ê\u0001\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bê\u0001\u0010\u0014\u001a\u0005\bê\u0001\u0010\u0016\"\u0005\bë\u0001\u0010\u0018R&\u0010ì\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bì\u0001\u0010\u0004\u001a\u0005\bí\u0001\u0010\u0006\"\u0005\bî\u0001\u0010\bR&\u0010ï\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bï\u0001\u0010\u0004\u001a\u0005\bð\u0001\u0010\u0006\"\u0005\bñ\u0001\u0010\bR*\u0010ó\u0001\u001a\u00030ò\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bó\u0001\u0010\u0080\u0001\u001a\u0006\bô\u0001\u0010õ\u0001\"\u0006\bö\u0001\u0010÷\u0001R(\u0010ø\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bø\u0001\u0010\u0004\u001a\u0005\bù\u0001\u0010\u0006\"\u0005\bú\u0001\u0010\bR&\u0010û\u0001\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bû\u0001\u0010\u0014\u001a\u0005\bü\u0001\u0010\u0016\"\u0005\bý\u0001\u0010\u0018R/\u0010ÿ\u0001\u001a\u00020\u00022\u0007\u0010þ\u0001\u001a\u00020\u00028\u0006@FX\u0087\u000e¢\u0006\u0015\n\u0005\bÿ\u0001\u0010\u0004\u001a\u0005\b\u0080\u0002\u0010\u0006\"\u0005\b\u0081\u0002\u0010\bR/\u0010\u0082\u0002\u001a\u00020\u00022\u0007\u0010þ\u0001\u001a\u00020\u00028\u0006@FX\u0087\u000e¢\u0006\u0015\n\u0005\b\u0082\u0002\u0010\u0004\u001a\u0005\b\u0083\u0002\u0010\u0006\"\u0005\b\u0084\u0002\u0010\bR/\u0010\u0085\u0002\u001a\u00020\u00022\u0007\u0010þ\u0001\u001a\u00020\u00028\u0006@FX\u0087\u000e¢\u0006\u0015\n\u0005\b\u0085\u0002\u0010\u0004\u001a\u0005\b\u0086\u0002\u0010\u0006\"\u0005\b\u0087\u0002\u0010\bR/\u0010\u0088\u0002\u001a\u00020\u00022\u0007\u0010þ\u0001\u001a\u00020\u00028\u0006@FX\u0087\u000e¢\u0006\u0015\n\u0005\b\u0088\u0002\u0010\u0004\u001a\u0005\b\u0089\u0002\u0010\u0006\"\u0005\b\u008a\u0002\u0010\bR/\u0010\u008b\u0002\u001a\u00020\u00022\u0007\u0010þ\u0001\u001a\u00020\u00028\u0006@FX\u0087\u000e¢\u0006\u0015\n\u0005\b\u008b\u0002\u0010\u0004\u001a\u0005\b\u008c\u0002\u0010\u0006\"\u0005\b\u008d\u0002\u0010\bR/\u0010\u008e\u0002\u001a\u00020\u00022\u0007\u0010þ\u0001\u001a\u00020\u00028\u0006@FX\u0087\u000e¢\u0006\u0015\n\u0005\b\u008e\u0002\u0010\u0004\u001a\u0005\b\u008f\u0002\u0010\u0006\"\u0005\b\u0090\u0002\u0010\bR/\u0010\u0091\u0002\u001a\u00020\u00022\u0007\u0010þ\u0001\u001a\u00020\u00028\u0006@FX\u0087\u000e¢\u0006\u0015\n\u0005\b\u0091\u0002\u0010\u0004\u001a\u0005\b\u0092\u0002\u0010\u0006\"\u0005\b\u0093\u0002\u0010\bR/\u0010\u0094\u0002\u001a\u00020\u00022\u0007\u0010þ\u0001\u001a\u00020\u00028\u0006@FX\u0087\u000e¢\u0006\u0015\n\u0005\b\u0094\u0002\u0010\u0004\u001a\u0005\b\u0095\u0002\u0010\u0006\"\u0005\b\u0096\u0002\u0010\bR/\u0010\u0097\u0002\u001a\u00020\u00022\u0007\u0010þ\u0001\u001a\u00020\u00028\u0006@FX\u0087\u000e¢\u0006\u0015\n\u0005\b\u0097\u0002\u0010\u0004\u001a\u0005\b\u0098\u0002\u0010\u0006\"\u0005\b\u0099\u0002\u0010\bR/\u0010\u009a\u0002\u001a\u00020\u00022\u0007\u0010þ\u0001\u001a\u00020\u00028\u0006@FX\u0087\u000e¢\u0006\u0015\n\u0005\b\u009a\u0002\u0010\u0004\u001a\u0005\b\u009b\u0002\u0010\u0006\"\u0005\b\u009c\u0002\u0010\bR/\u0010\u009d\u0002\u001a\u00020\u00022\u0007\u0010þ\u0001\u001a\u00020\u00028\u0006@FX\u0087\u000e¢\u0006\u0015\n\u0005\b\u009d\u0002\u0010\u0004\u001a\u0005\b\u009e\u0002\u0010\u0006\"\u0005\b\u009f\u0002\u0010\bR/\u0010 \u0002\u001a\u00020\u00022\u0007\u0010þ\u0001\u001a\u00020\u00028\u0006@FX\u0087\u000e¢\u0006\u0015\n\u0005\b \u0002\u0010\u0004\u001a\u0005\b¡\u0002\u0010\u0006\"\u0005\b¢\u0002\u0010\bR/\u0010£\u0002\u001a\u00020\u00022\u0007\u0010þ\u0001\u001a\u00020\u00028\u0006@FX\u0087\u000e¢\u0006\u0015\n\u0005\b£\u0002\u0010\u0004\u001a\u0005\b¤\u0002\u0010\u0006\"\u0005\b¥\u0002\u0010\bR/\u0010¦\u0002\u001a\u00020\u00022\u0007\u0010þ\u0001\u001a\u00020\u00028\u0006@FX\u0087\u000e¢\u0006\u0015\n\u0005\b¦\u0002\u0010\u0004\u001a\u0005\b§\u0002\u0010\u0006\"\u0005\b¨\u0002\u0010\bR/\u0010©\u0002\u001a\u00020\u00022\u0007\u0010þ\u0001\u001a\u00020\u00028\u0006@FX\u0087\u000e¢\u0006\u0015\n\u0005\b©\u0002\u0010\u0004\u001a\u0005\bª\u0002\u0010\u0006\"\u0005\b«\u0002\u0010\bR/\u0010¬\u0002\u001a\u00020\u00022\u0007\u0010þ\u0001\u001a\u00020\u00028\u0006@FX\u0087\u000e¢\u0006\u0015\n\u0005\b¬\u0002\u0010\u0004\u001a\u0005\b\u00ad\u0002\u0010\u0006\"\u0005\b®\u0002\u0010\bR/\u0010¯\u0002\u001a\u00020\u00022\u0007\u0010þ\u0001\u001a\u00020\u00028\u0006@FX\u0087\u000e¢\u0006\u0015\n\u0005\b¯\u0002\u0010\u0004\u001a\u0005\b°\u0002\u0010\u0006\"\u0005\b±\u0002\u0010\bR/\u0010²\u0002\u001a\u00020a2\u0007\u0010þ\u0001\u001a\u00020a8\u0006@FX\u0087\u000e¢\u0006\u0015\n\u0005\b²\u0002\u0010^\u001a\u0005\b³\u0002\u0010d\"\u0005\b´\u0002\u0010fR/\u0010µ\u0002\u001a\u00020a2\u0007\u0010þ\u0001\u001a\u00020a8\u0006@FX\u0087\u000e¢\u0006\u0015\n\u0005\bµ\u0002\u0010^\u001a\u0005\b¶\u0002\u0010d\"\u0005\b·\u0002\u0010fR/\u0010¸\u0002\u001a\u00020\u00122\u0007\u0010þ\u0001\u001a\u00020\u00128\u0006@FX\u0087\u000e¢\u0006\u0015\n\u0005\b¸\u0002\u0010\u0014\u001a\u0005\b¹\u0002\u0010\u0016\"\u0005\bº\u0002\u0010\u0018R4\u0010»\u0002\u001a\u00030ò\u00012\b\u0010þ\u0001\u001a\u00030ò\u00018\u0006@FX\u0087\u000e¢\u0006\u0018\n\u0006\b»\u0002\u0010\u0080\u0001\u001a\u0006\b¼\u0002\u0010õ\u0001\"\u0006\b½\u0002\u0010÷\u0001R/\u0010¾\u0002\u001a\u00020\u00022\u0007\u0010þ\u0001\u001a\u00020\u00028\u0006@FX\u0087\u000e¢\u0006\u0015\n\u0005\b¾\u0002\u0010\u0004\u001a\u0005\b¿\u0002\u0010\u0006\"\u0005\bÀ\u0002\u0010\bR/\u0010Á\u0002\u001a\u00020\u00022\u0007\u0010þ\u0001\u001a\u00020\u00028\u0006@FX\u0087\u000e¢\u0006\u0015\n\u0005\bÁ\u0002\u0010\u0004\u001a\u0005\bÂ\u0002\u0010\u0006\"\u0005\bÃ\u0002\u0010\bR/\u0010Ä\u0002\u001a\u00020\u00022\u0007\u0010þ\u0001\u001a\u00020\u00028\u0006@FX\u0087\u000e¢\u0006\u0015\n\u0005\bÄ\u0002\u0010\u0004\u001a\u0005\bÅ\u0002\u0010\u0006\"\u0005\bÆ\u0002\u0010\bR/\u0010Ç\u0002\u001a\u00020a2\u0007\u0010þ\u0001\u001a\u00020a8\u0006@FX\u0087\u000e¢\u0006\u0015\n\u0005\bÇ\u0002\u0010^\u001a\u0005\bÈ\u0002\u0010d\"\u0005\bÉ\u0002\u0010fR/\u0010Ê\u0002\u001a\u00020a2\u0007\u0010þ\u0001\u001a\u00020a8\u0006@FX\u0087\u000e¢\u0006\u0015\n\u0005\bÊ\u0002\u0010^\u001a\u0005\bË\u0002\u0010d\"\u0005\bÌ\u0002\u0010fR/\u0010Í\u0002\u001a\u00020a2\u0007\u0010þ\u0001\u001a\u00020a8\u0006@FX\u0087\u000e¢\u0006\u0015\n\u0005\bÍ\u0002\u0010^\u001a\u0005\bÎ\u0002\u0010d\"\u0005\bÏ\u0002\u0010fR/\u0010Ð\u0002\u001a\u00020\u00122\u0007\u0010þ\u0001\u001a\u00020\u00128\u0006@FX\u0087\u000e¢\u0006\u0015\n\u0005\bÐ\u0002\u0010\u0014\u001a\u0005\bÑ\u0002\u0010\u0016\"\u0005\bÒ\u0002\u0010\u0018R/\u0010Ó\u0002\u001a\u00020\u00022\u0007\u0010þ\u0001\u001a\u00020\u00028\u0006@FX\u0087\u000e¢\u0006\u0015\n\u0005\bÓ\u0002\u0010\u0004\u001a\u0005\bÔ\u0002\u0010\u0006\"\u0005\bÕ\u0002\u0010\bR&\u0010Ö\u0002\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÖ\u0002\u0010\u0014\u001a\u0005\bÖ\u0002\u0010\u0016\"\u0005\b×\u0002\u0010\u0018¨\u0006Ø\u0002"}, d2 = {"Lcom/bytedance/android/annie/param/k;", "", "", "channel", "Ljava/lang/String;", "s", "()Ljava/lang/String;", "g1", "(Ljava/lang/String;)V", "appTheme", "l", "b1", "versionCode", "C0", "t2", "webcastSdkVersion", "H0", "y2", "", "isTeenMode", "I", "P0", "()I", "o2", "(I)V", com.bytedance.android.ec.core.event.a.KEY_LOCATION, "getLocation", "G1", "forestSessionId", "getForestSessionId", "y1", "containerID", "getContainerID", "h1", "initTimestamp", "P", "C1", "containerInitTime", "t", "i1", "offline", "getOffline", "N1", "Lcom/bytedance/android/annie/bridge/method/abs/GetAppInfoResultModel$GetAppInfoSafeArea;", "safeArea", "Lcom/bytedance/android/annie/bridge/method/abs/GetAppInfoResultModel$GetAppInfoSafeArea;", "getSafeArea", "()Lcom/bytedance/android/annie/bridge/method/abs/GetAppInfoResultModel$GetAppInfoSafeArea;", "c2", "(Lcom/bytedance/android/annie/bridge/method/abs/GetAppInfoResultModel$GetAppInfoSafeArea;)V", "userID", "A0", "r2", "secUserID", "r0", "j2", "anchorID", "g", "W0", "secAnchorID", "q0", "i2", "roomID", "j0", "a2", "Lcom/google/gson/JsonObject;", "settings", "Lcom/google/gson/JsonObject;", "s0", "()Lcom/google/gson/JsonObject;", "k2", "(Lcom/google/gson/JsonObject;)V", "activitySettings", "d", "T0", "dynamicSettings", "u1", "", "abParams", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "Q0", "(Ljava/util/Map;)V", "queryItems", "g0", "X1", "injectJson", "Q", "D1", "openUDid", "X", "O1", "device_platform", "F", "devicePlatform", "B", "", "screenWidth", "o0", "()F", "g2", "(F)V", "screenHeight", "l0", "d2", "realScreenHeight", "h0", "Y1", "screenWidthPx", "p0", "h2", "screenHeightPx", "m0", "e2", "bottomBarHeight", "p", "setBottomBarHeight", "isNotch", "N0", "L1", "perf", "f0", "V1", "isPad", "O0", "T1", "os", "Z", "ac", "b", "R0", "currentNetworkQualityInfo", "x", "k1", "webcastLocale", "G0", "x2", "webcastGpsAccess", "E0", "v2", "webcastLanguage", "F0", "w2", "deviceType", "D", "q1", "systemViewZoom", "w0", "n2", "iid", "O", "B1", "minorStatus", "U", "K1", "osApi", "a0", "Q1", "fakeRegion", "K", "w1", "hostAbi", "N", "A1", "cpuSupport64", "w", "j1", "resolution", "i0", "Z1", "ts", "x0", "p2", "manifestVersionCode", "T", "J1", "oaid", "W", "M1", "cdid", "r", "f1", "appType", "m", "c1", "dpi", "H", "t1", "effectChannel", "J", "v1", "addressBookAccess", "e", "U0", "rticket", "k0", "b2", "isAndroidPad", "K0", "X0", "webcastVersion", "I0", "z2", "padOptType", "e0", "U1", "containerName", "u", "setContainerName", "veDeviceScore", "B0", "s2", "appRunTimeInfo", "k", "a1", "glEsVersion", "M", "z1", "", "currentTime", "y", "()J", "l1", "(J)V", "businessData", "q", "e1", "osTheme", "c0", "setOsTheme", "networkType", "V", "setNetworkType", "isPrerender", "W1", "containerVersion", "v", "setContainerVersion", "containerType", "getContainerType", "setContainerType", "", "isDouyinSeries", "L0", "()Z", "s1", "(Z)V", "jsbProxyAppId", "R", "E1", "isLogin", "M0", "H1", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "aid", "f", "V0", "appID", "h", "setAppID", "deviceId", "A", "o1", "deviceID", "z", "n1", "app_name", "o", "setApp_name", BdpAwemeConstant.KEY_APP_NAME, "j", "Z0", "versionName", "D0", "u2", "appVersion", "n", "d1", "update_version_code", "z0", "setUpdate_version_code", "updateVersionCode", "y0", "q2", "lynx_version", "getLynx_version", "setLynx_version", "lynxVersion", "getLynxVersion", "I1", "language", "S", "F1", "appLanguage", "i", "Y0", "osLanguage", "b0", "setOsLanguage", "os_version", "d0", "setOs_version", "osVersion", "getOsVersion", "R1", "systemFontScale", "v0", "m2", "fontScale", "L", "x1", "isAccessible", "J0", "S0", "accessible", "c", "setAccessible", "device_brand", "E", "setDevice_brand", "deviceBrand", "getDeviceBrand", "m1", "device_score", "G", "r1", "deviceScore", "C", "p1", "status_bar_height", "u0", "setStatus_bar_height", "statusBarHeight", "t0", "l2", "orientation", "Y", "P1", "screenOrientation", "n0", "f2", "isOversea", "S1", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class k {
    public transient Map<String, ? extends Object> a;

    @SerializedName("ab_params")
    private Map<String, ? extends Object> abParams;

    /* JADX INFO: renamed from: ac, reason: collision with root package name */
    @SerializedName("ac")
    private String f15ac;

    @SerializedName("accessible")
    private boolean accessible;

    @SerializedName("activity_settings")
    private JsonObject activitySettings;

    @SerializedName("address_book_access")
    private String addressBookAccess;

    @SerializedName("aid")
    private String aid;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ANCHOR_ID)
    private String anchorID;

    @SerializedName("appID")
    private String appID;

    @SerializedName("appLanguage")
    private String appLanguage;

    @SerializedName(BdpAwemeConstant.KEY_APP_NAME)
    private String appName;

    @SerializedName("appRunTimeInfo")
    private Map<String, ? extends Object> appRunTimeInfo;

    @SerializedName("appTheme")
    private String appTheme;

    @SerializedName("app_type")
    private String appType;

    @SerializedName("appVersion")
    private String appVersion;

    @SerializedName("app_name")
    private String app_name;
    public transient Map<String, ? extends Object> b;

    @SerializedName("bottom_bar_height")
    private int bottomBarHeight;

    @SerializedName("initialBusinessProps")
    private Map<String, ? extends Object> businessData;
    public boolean c;

    @SerializedName("cdid")
    private String cdid;

    @SerializedName("channel")
    private String channel;

    @SerializedName("containerID")
    private String containerID;

    @SerializedName("containerInitTime")
    private String containerInitTime;

    @SerializedName("container_name")
    private String containerName;

    @SerializedName("containerType")
    private String containerType;

    @SerializedName("containerVersion")
    private String containerVersion;

    @SerializedName("cpu_support64")
    private String cpuSupport64;

    @SerializedName("current_network_quality_info")
    private String currentNetworkQualityInfo;

    @SerializedName("currentTime")
    private long currentTime;

    @SerializedName("deviceBrand")
    private String deviceBrand;

    @SerializedName("deviceID")
    private String deviceID;

    @SerializedName("device_id")
    private String deviceId;

    @SerializedName("devicePlatform")
    private final String devicePlatform;

    @SerializedName("deviceScore")
    private float deviceScore;

    @SerializedName("device_type")
    private String deviceType;

    @SerializedName("device_brand")
    private String device_brand;

    @SerializedName("device_platform")
    private final String device_platform;

    @SerializedName("device_score")
    private String device_score;

    @SerializedName("dpi")
    private String dpi;

    @SerializedName("dynamic_settings")
    private JsonObject dynamicSettings;

    @SerializedName("effect_channel")
    private String effectChannel;

    @SerializedName("fake_region")
    private String fakeRegion;

    @SerializedName("fontScale")
    private float fontScale;

    @SerializedName("forestSessionId")
    private String forestSessionId;

    @SerializedName("glEsVersion")
    private int glEsVersion;

    @SerializedName("host_abi")
    private String hostAbi;

    @SerializedName("iid")
    private String iid;

    @SerializedName("initTimestamp")
    private String initTimestamp;

    @SerializedName("inject_json")
    private Map<String, ? extends Object> injectJson;

    @SerializedName("isAccessible")
    private int isAccessible;

    @SerializedName("is_android_pad")
    private String isAndroidPad;

    @SerializedName("isDouyinSeries")
    private boolean isDouyinSeries;

    @SerializedName("isLogin")
    private int isLogin;

    @SerializedName("is_notch")
    private int isNotch;

    @SerializedName("is_oversea")
    private int isOversea;

    @SerializedName("is_pad")
    private int isPad;

    @SerializedName("isPrerender")
    private int isPrerender;

    @SerializedName("isTeenMode")
    private int isTeenMode;

    @SerializedName("jsbProxyAppId")
    private String jsbProxyAppId;

    @SerializedName("language")
    private String language;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_LOCATION)
    private String location;

    @SerializedName("lynxVersion")
    private String lynxVersion;

    @SerializedName("lynx_version")
    private String lynx_version;

    @SerializedName("manifest_version_code")
    private String manifestVersionCode;

    @SerializedName("minor_status")
    private String minorStatus;

    @SerializedName("networkType")
    private String networkType;

    @SerializedName("oaid")
    private String oaid;

    @SerializedName("offline")
    private int offline;

    @SerializedName("openudid")
    private String openUDid;

    @SerializedName("orientation")
    private int orientation;

    @SerializedName("os")
    private final String os;

    @SerializedName("os_api")
    private String osApi;

    @SerializedName("osLanguage")
    private String osLanguage;

    @SerializedName("osTheme")
    private String osTheme;

    @SerializedName("osVersion")
    private String osVersion;

    @SerializedName("os_version")
    private String os_version;

    @SerializedName("pad_opt_type")
    private int padOptType;

    @SerializedName("perf")
    private int perf;

    @SerializedName("queryItems")
    private Map<String, String> queryItems;

    @SerializedName("realScreenHeight")
    private float realScreenHeight;

    @SerializedName("resolution")
    private String resolution;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ROOM_ID)
    private String roomID;

    @SerializedName("_rticket")
    private String rticket;

    @SerializedName("safeArea")
    private GetAppInfoResultModel.GetAppInfoSafeArea safeArea;

    @SerializedName("screenHeight")
    private float screenHeight;

    @SerializedName("screenHeightPx")
    private int screenHeightPx;

    @SerializedName("screenOrientation")
    private String screenOrientation;

    @SerializedName("screenWidth")
    private float screenWidth;

    @SerializedName("screenWidthPx")
    private int screenWidthPx;

    @SerializedName("sec_anchor_id")
    private String secAnchorID;

    @SerializedName("sec_user_id")
    private String secUserID;

    @SerializedName("settings")
    private JsonObject settings;

    @SerializedName("statusBarHeight")
    private float statusBarHeight;

    @SerializedName("status_bar_height")
    private float status_bar_height;

    @SerializedName("systemFontScale")
    private float systemFontScale;

    @SerializedName("systemViewZoom")
    private float systemViewZoom;

    @SerializedName("ts")
    private String ts;

    @SerializedName("updateVersionCode")
    private String updateVersionCode;

    @SerializedName("update_version_code")
    private String update_version_code;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_USER_ID)
    private String userID;

    @SerializedName("ve_device_score")
    private String veDeviceScore;

    @SerializedName("version_code")
    private String versionCode;

    @SerializedName("version_name")
    private String versionName;

    @SerializedName("webcast_gps_access")
    private String webcastGpsAccess;

    @SerializedName("webcast_language")
    private String webcastLanguage;

    @SerializedName("webcast_locale")
    private String webcastLocale;

    @SerializedName("webcast_sdk_version")
    private String webcastSdkVersion;

    @SerializedName("webcast_version")
    private int webcastVersion;

    public k() {
        this(null);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof k) == true) goto L8;
        return false;
    L8:
        k r11 = (k) r10;
        if (Intrinsics.areEqual(this.channel, r11.channel) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appTheme, r11.appTheme) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.versionCode, r11.versionCode) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.webcastSdkVersion, r11.webcastSdkVersion) == true) goto L21;
        return false;
    L21:
        if (this.isTeenMode == r11.isTeenMode) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.location, r11.location) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.forestSessionId, r11.forestSessionId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.containerID, r11.containerID) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.initTimestamp, r11.initTimestamp) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.containerInitTime, r11.containerInitTime) == true) goto L39;
        return false;
    L39:
        if (this.offline == r11.offline) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.safeArea, r11.safeArea) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.userID, r11.userID) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.secUserID, r11.secUserID) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.anchorID, r11.anchorID) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.secAnchorID, r11.secAnchorID) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.roomID, r11.roomID) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.settings, r11.settings) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.activitySettings, r11.activitySettings) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.dynamicSettings, r11.dynamicSettings) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.abParams, r11.abParams) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.queryItems, r11.queryItems) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.injectJson, r11.injectJson) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.openUDid, r11.openUDid) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.device_platform, r11.device_platform) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.devicePlatform, r11.devicePlatform) == true) goto L87;
        return false;
    L87:
        if (Float.compare(this.screenWidth, r11.screenWidth) == 0) goto L90;
        return false;
    L90:
        if (Float.compare(this.screenHeight, r11.screenHeight) == 0) goto L93;
        return false;
    L93:
        if (Float.compare(this.realScreenHeight, r11.realScreenHeight) == 0) goto L96;
        return false;
    L96:
        if (this.screenWidthPx == r11.screenWidthPx) goto L99;
        return false;
    L99:
        if (this.screenHeightPx == r11.screenHeightPx) goto L102;
        return false;
    L102:
        if (this.bottomBarHeight == r11.bottomBarHeight) goto L105;
        return false;
    L105:
        if (this.isNotch == r11.isNotch) goto L108;
        return false;
    L108:
        if (this.perf == r11.perf) goto L111;
        return false;
    L111:
        if (this.isPad == r11.isPad) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.os, r11.os) == true) goto L117;
        return false;
    L117:
        if (Intrinsics.areEqual(this.f15ac, r11.f15ac) == true) goto L120;
        return false;
    L120:
        if (Intrinsics.areEqual(this.currentNetworkQualityInfo, r11.currentNetworkQualityInfo) == true) goto L123;
        return false;
    L123:
        if (Intrinsics.areEqual(this.webcastLocale, r11.webcastLocale) == true) goto L126;
        return false;
    L126:
        if (Intrinsics.areEqual(this.webcastGpsAccess, r11.webcastGpsAccess) == true) goto L129;
        return false;
    L129:
        if (Intrinsics.areEqual(this.webcastLanguage, r11.webcastLanguage) == true) goto L132;
        return false;
    L132:
        if (Intrinsics.areEqual(this.deviceType, r11.deviceType) == true) goto L135;
        return false;
    L135:
        if (Float.compare(this.systemViewZoom, r11.systemViewZoom) == 0) goto L138;
        return false;
    L138:
        if (Intrinsics.areEqual(this.iid, r11.iid) == true) goto L141;
        return false;
    L141:
        if (Intrinsics.areEqual(this.minorStatus, r11.minorStatus) == true) goto L144;
        return false;
    L144:
        if (Intrinsics.areEqual(this.osApi, r11.osApi) == true) goto L147;
        return false;
    L147:
        if (Intrinsics.areEqual(this.fakeRegion, r11.fakeRegion) == true) goto L150;
        return false;
    L150:
        if (Intrinsics.areEqual(this.hostAbi, r11.hostAbi) == true) goto L153;
        return false;
    L153:
        if (Intrinsics.areEqual(this.cpuSupport64, r11.cpuSupport64) == true) goto L156;
        return false;
    L156:
        if (Intrinsics.areEqual(this.resolution, r11.resolution) == true) goto L159;
        return false;
    L159:
        if (Intrinsics.areEqual(this.ts, r11.ts) == true) goto L162;
        return false;
    L162:
        if (Intrinsics.areEqual(this.manifestVersionCode, r11.manifestVersionCode) == true) goto L165;
        return false;
    L165:
        if (Intrinsics.areEqual(this.oaid, r11.oaid) == true) goto L168;
        return false;
    L168:
        if (Intrinsics.areEqual(this.cdid, r11.cdid) == true) goto L171;
        return false;
    L171:
        if (Intrinsics.areEqual(this.appType, r11.appType) == true) goto L174;
        return false;
    L174:
        if (Intrinsics.areEqual(this.dpi, r11.dpi) == true) goto L177;
        return false;
    L177:
        if (Intrinsics.areEqual(this.effectChannel, r11.effectChannel) == true) goto L180;
        return false;
    L180:
        if (Intrinsics.areEqual(this.addressBookAccess, r11.addressBookAccess) == true) goto L183;
        return false;
    L183:
        if (Intrinsics.areEqual(this.rticket, r11.rticket) == true) goto L186;
        return false;
    L186:
        if (Intrinsics.areEqual(this.isAndroidPad, r11.isAndroidPad) == true) goto L189;
        return false;
    L189:
        if (this.webcastVersion == r11.webcastVersion) goto L192;
        return false;
    L192:
        if (this.padOptType == r11.padOptType) goto L195;
        return false;
    L195:
        if (Intrinsics.areEqual(this.containerName, r11.containerName) == true) goto L198;
        return false;
    L198:
        if (Intrinsics.areEqual(this.veDeviceScore, r11.veDeviceScore) == true) goto L201;
        return false;
    L201:
        if (Intrinsics.areEqual(this.appRunTimeInfo, r11.appRunTimeInfo) == true) goto L204;
        return false;
    L204:
        if (this.glEsVersion == r11.glEsVersion) goto L207;
        return false;
    L207:
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L210;
        return false;
    L210:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L213;
        return false;
    L213:
        if (this.currentTime == r11.currentTime) goto L216;
        return false;
    L216:
        if (Intrinsics.areEqual(this.businessData, r11.businessData) == true) goto L219;
        return false;
    L219:
        if (Intrinsics.areEqual(this.osTheme, r11.osTheme) == true) goto L222;
        return false;
    L222:
        if (Intrinsics.areEqual(this.networkType, r11.networkType) == true) goto L225;
        return false;
    L225:
        if (this.isPrerender == r11.isPrerender) goto L228;
        return false;
    L228:
        if (Intrinsics.areEqual(this.containerVersion, r11.containerVersion) == true) goto L231;
        return false;
    L231:
        if (Intrinsics.areEqual(this.containerType, r11.containerType) == true) goto L234;
        return false;
    L234:
        if (this.isDouyinSeries == r11.isDouyinSeries) goto L237;
        return false;
    L237:
        if (Intrinsics.areEqual(this.jsbProxyAppId, r11.jsbProxyAppId) == true) goto L240;
        return false;
    L240:
        if (this.isLogin == r11.isLogin) goto L242;
        return false;
    L242:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((((((((((((this.channel.hashCode() * 31) + this.appTheme.hashCode()) * 31) + this.versionCode.hashCode()) * 31) + this.webcastSdkVersion.hashCode()) * 31) + this.isTeenMode) * 31) + this.location.hashCode()) * 31) + this.forestSessionId.hashCode()) * 31) + this.containerID.hashCode()) * 31) + this.initTimestamp.hashCode()) * 31) + this.containerInitTime.hashCode()) * 31) + this.offline) * 31;
        GetAppInfoResultModel.GetAppInfoSafeArea r1 = this.safeArea;
        int r10 = 0;
        if (r1 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (((((((((((((((((((r0 + r11) * 31) + this.userID.hashCode()) * 31) + this.secUserID.hashCode()) * 31) + this.anchorID.hashCode()) * 31) + this.secAnchorID.hashCode()) * 31) + this.roomID.hashCode()) * 31) + this.settings.hashCode()) * 31) + this.activitySettings.hashCode()) * 31) + this.dynamicSettings.hashCode()) * 31) + this.abParams.hashCode()) * 31;
        Map<String, String> r13 = this.queryItems;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((r12 + r14) * 31) + this.injectJson.hashCode()) * 31) + this.openUDid.hashCode()) * 31) + this.device_platform.hashCode()) * 31) + this.devicePlatform.hashCode()) * 31) + Float.floatToIntBits(this.screenWidth)) * 31) + Float.floatToIntBits(this.screenHeight)) * 31) + Float.floatToIntBits(this.realScreenHeight)) * 31) + this.screenWidthPx) * 31) + this.screenHeightPx) * 31) + this.bottomBarHeight) * 31) + this.isNotch) * 31) + this.perf) * 31) + this.isPad) * 31) + this.os.hashCode()) * 31) + this.f15ac.hashCode()) * 31) + this.currentNetworkQualityInfo.hashCode()) * 31) + this.webcastLocale.hashCode()) * 31) + this.webcastGpsAccess.hashCode()) * 31) + this.webcastLanguage.hashCode()) * 31) + this.deviceType.hashCode()) * 31) + Float.floatToIntBits(this.systemViewZoom)) * 31) + this.iid.hashCode()) * 31) + this.minorStatus.hashCode()) * 31) + this.osApi.hashCode()) * 31) + this.fakeRegion.hashCode()) * 31) + this.hostAbi.hashCode()) * 31) + this.cpuSupport64.hashCode()) * 31) + this.resolution.hashCode()) * 31) + this.ts.hashCode()) * 31) + this.manifestVersionCode.hashCode()) * 31) + this.oaid.hashCode()) * 31) + this.cdid.hashCode()) * 31) + this.appType.hashCode()) * 31) + this.dpi.hashCode()) * 31) + this.effectChannel.hashCode()) * 31) + this.addressBookAccess.hashCode()) * 31) + this.rticket.hashCode()) * 31) + this.isAndroidPad.hashCode()) * 31) + this.webcastVersion) * 31) + this.padOptType) * 31) + this.containerName.hashCode()) * 31) + this.veDeviceScore.hashCode()) * 31;
        Map<String, ? extends Object> r16 = this.appRunTimeInfo;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = (((r15 + r17) * 31) + this.glEsVersion) * 31;
        Map<String, ? extends Object> r19 = this.a;
        if (r19 != null) goto L17;
        int r20 = 0;
    L18:
        int r21 = (r18 + r20) * 31;
        Map<String, ? extends Object> r22 = this.b;
        if (r22 != null) goto L21;
        int r23 = 0;
    L22:
        long r24 = this.currentTime;
        int r25 = (((r21 + r23) * 31) + ((int) (r24 ^ (r24 >>> 32)))) * 31;
        Map<String, ? extends Object> r26 = this.businessData;
        if (r26 != null) goto L25;
        int r27 = 0;
    L26:
        int r28 = (((((((((((r25 + r27) * 31) + this.osTheme.hashCode()) * 31) + this.networkType.hashCode()) * 31) + this.isPrerender) * 31) + this.containerVersion.hashCode()) * 31) + this.containerType.hashCode()) * 31;
        if (this.isDouyinSeries == false) goto L29;
        int r29 = 1231;
    L30:
        int r30 = (r28 + r29) * 31;
        String r31 = this.jsbProxyAppId;
        if (r31 == null) goto L35;
        r10 = r31.hashCode();
    L35:
        return ((r30 + r10) * 31) + this.isLogin;
    L29:
        r29 = 1237;
        goto L30
    L25:
        r27 = r26.hashCode();
        goto L26
    L21:
        r23 = r22.hashCode();
        goto L22
    L17:
        r20 = r19.hashCode();
        goto L18
    L13:
        r17 = r16.hashCode();
        goto L14
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "GlobalPropsParams(channel=" + this.channel + ", appTheme=" + this.appTheme + ", versionCode=" + this.versionCode + ", webcastSdkVersion=" + this.webcastSdkVersion + ", isTeenMode=" + this.isTeenMode + ", location=" + this.location + ", forestSessionId=" + this.forestSessionId + ", containerID=" + this.containerID + ", initTimestamp=" + this.initTimestamp + ", containerInitTime=" + this.containerInitTime + ", offline=" + this.offline + ", safeArea=" + this.safeArea + ", userID=" + this.userID + ", secUserID=" + this.secUserID + ", anchorID=" + this.anchorID + ", secAnchorID=" + this.secAnchorID + ", roomID=" + this.roomID + ", settings=" + this.settings + ", activitySettings=" + this.activitySettings + ", dynamicSettings=" + this.dynamicSettings + ", abParams=" + this.abParams + ", queryItems=" + this.queryItems + ", injectJson=" + this.injectJson + ", openUDid=" + this.openUDid + ", device_platform=" + this.device_platform + ", devicePlatform=" + this.devicePlatform + ", screenWidth=" + this.screenWidth + ", screenHeight=" + this.screenHeight + ", realScreenHeight=" + this.realScreenHeight + ", screenWidthPx=" + this.screenWidthPx + ", screenHeightPx=" + this.screenHeightPx + ", bottomBarHeight=" + this.bottomBarHeight + ", isNotch=" + this.isNotch + ", perf=" + this.perf + ", isPad=" + this.isPad + ", os=" + this.os + ", ac=" + this.f15ac + ", currentNetworkQualityInfo=" + this.currentNetworkQualityInfo + ", webcastLocale=" + this.webcastLocale + ", webcastGpsAccess=" + this.webcastGpsAccess + ", webcastLanguage=" + this.webcastLanguage + ", deviceType=" + this.deviceType + ", systemViewZoom=" + this.systemViewZoom + ", iid=" + this.iid + ", minorStatus=" + this.minorStatus + ", osApi=" + this.osApi + ", fakeRegion=" + this.fakeRegion + ", hostAbi=" + this.hostAbi + ", cpuSupport64=" + this.cpuSupport64 + ", resolution=" + this.resolution + ", ts=" + this.ts + ", manifestVersionCode=" + this.manifestVersionCode + ", oaid=" + this.oaid + ", cdid=" + this.cdid + ", appType=" + this.appType + ", dpi=" + this.dpi + ", effectChannel=" + this.effectChannel + ", addressBookAccess=" + this.addressBookAccess + ", rticket=" + this.rticket + ", isAndroidPad=" + this.isAndroidPad + ", webcastVersion=" + this.webcastVersion + ", padOptType=" + this.padOptType + ", containerName=" + this.containerName + ", veDeviceScore=" + this.veDeviceScore + ", appRunTimeInfo=" + this.appRunTimeInfo + ", glEsVersion=" + this.glEsVersion + ", prefetchData=" + this.a + ", storageData=" + this.b + ", currentTime=" + this.currentTime + ", businessData=" + this.businessData + ", osTheme=" + this.osTheme + ", networkType=" + this.networkType + ", isPrerender=" + this.isPrerender + ", containerVersion=" + this.containerVersion + ", containerType=" + this.containerType + ", isDouyinSeries=" + this.isDouyinSeries + ", jsbProxyAppId=" + this.jsbProxyAppId + ", isLogin=" + this.isLogin + ')';
    }

    public final void E1() {
        this.jsbProxyAppId = "1128";
    }

    public final String A() {
        return this.deviceId;
    }

    public final String A0() {
        return this.userID;
    }

    public final String B() {
        return this.devicePlatform;
    }

    public final String B0() {
        return this.veDeviceScore;
    }

    public final float C() {
        return this.deviceScore;
    }

    public final String C0() {
        return this.versionCode;
    }

    public final String D() {
        return this.deviceType;
    }

    public final String D0() {
        return this.versionName;
    }

    public final String E() {
        return this.device_brand;
    }

    public final String E0() {
        return this.webcastGpsAccess;
    }

    public final String F() {
        return this.device_platform;
    }

    public final String F0() {
        return this.webcastLanguage;
    }

    public final String G() {
        return this.device_score;
    }

    public final String G0() {
        return this.webcastLocale;
    }

    public final String H() {
        return this.dpi;
    }

    public final String H0() {
        return this.webcastSdkVersion;
    }

    public final JsonObject I() {
        return this.dynamicSettings;
    }

    public final int I0() {
        return this.webcastVersion;
    }

    public final String J() {
        return this.effectChannel;
    }

    public final int J0() {
        return this.isAccessible;
    }

    public final String K() {
        return this.fakeRegion;
    }

    public final String K0() {
        return this.isAndroidPad;
    }

    public final float L() {
        return this.fontScale;
    }

    public final boolean L0() {
        return this.isDouyinSeries;
    }

    public final int M() {
        return this.glEsVersion;
    }

    public final int M0() {
        return this.isLogin;
    }

    public final String N() {
        return this.hostAbi;
    }

    public final int N0() {
        return this.isNotch;
    }

    public final String O() {
        return this.iid;
    }

    public final int O0() {
        return this.isPad;
    }

    public final String P() {
        return this.initTimestamp;
    }

    public final int P0() {
        return this.isTeenMode;
    }

    public final Map<String, Object> Q() {
        return this.injectJson;
    }

    public final String R() {
        return this.jsbProxyAppId;
    }

    public final String S() {
        return this.language;
    }

    public final String T() {
        return this.manifestVersionCode;
    }

    public final String U() {
        return this.minorStatus;
    }

    public final String V() {
        return this.networkType;
    }

    public final String W() {
        return this.oaid;
    }

    public final String X() {
        return this.openUDid;
    }

    public final int Y() {
        return this.orientation;
    }

    public final String Z() {
        return this.os;
    }

    public final Map<String, Object> a() {
        return this.abParams;
    }

    public final String a0() {
        return this.osApi;
    }

    public final String b() {
        return this.f15ac;
    }

    public final String b0() {
        return this.osLanguage;
    }

    public final boolean c() {
        return this.accessible;
    }

    public final String c0() {
        return this.osTheme;
    }

    public final JsonObject d() {
        return this.activitySettings;
    }

    public final String d0() {
        return this.os_version;
    }

    public final String e() {
        return this.addressBookAccess;
    }

    public final int e0() {
        return this.padOptType;
    }

    public final String f() {
        return this.aid;
    }

    public final int f0() {
        return this.perf;
    }

    public final String g() {
        return this.anchorID;
    }

    public final Map<String, String> g0() {
        return this.queryItems;
    }

    public final String h() {
        return this.appID;
    }

    public final float h0() {
        return this.realScreenHeight;
    }

    public final String i() {
        return this.appLanguage;
    }

    public final String i0() {
        return this.resolution;
    }

    public final String j() {
        return this.appName;
    }

    public final String j0() {
        return this.roomID;
    }

    public final Map<String, Object> k() {
        return this.appRunTimeInfo;
    }

    public final String k0() {
        return this.rticket;
    }

    public final String l() {
        return this.appTheme;
    }

    public final float l0() {
        return this.screenHeight;
    }

    public final String m() {
        return this.appType;
    }

    public final int m0() {
        return this.screenHeightPx;
    }

    public final String n() {
        return this.appVersion;
    }

    public final String n0() {
        return this.screenOrientation;
    }

    public final String o() {
        return this.app_name;
    }

    public final float o0() {
        return this.screenWidth;
    }

    public final int p() {
        return this.bottomBarHeight;
    }

    public final int p0() {
        return this.screenWidthPx;
    }

    public final Map<String, Object> q() {
        return this.businessData;
    }

    public final String q0() {
        return this.secAnchorID;
    }

    public final String r() {
        return this.cdid;
    }

    public final String r0() {
        return this.secUserID;
    }

    public final String s() {
        return this.channel;
    }

    public final JsonObject s0() {
        return this.settings;
    }

    public final String t() {
        return this.containerInitTime;
    }

    public final float t0() {
        return this.statusBarHeight;
    }

    public final String u() {
        return this.containerName;
    }

    public final float u0() {
        return this.status_bar_height;
    }

    public final String v() {
        return this.containerVersion;
    }

    public final float v0() {
        return this.systemFontScale;
    }

    public final String w() {
        return this.cpuSupport64;
    }

    public final float w0() {
        return this.systemViewZoom;
    }

    public final String x() {
        return this.currentNetworkQualityInfo;
    }

    public final String x0() {
        return this.ts;
    }

    public final long y() {
        return this.currentTime;
    }

    public final String y0() {
        return this.updateVersionCode;
    }

    public final String z() {
        return this.deviceID;
    }

    public final String z0() {
        return this.update_version_code;
    }

    public k(Object r17) {
        JsonObject r1 = new JsonObject();
        JsonObject r10 = new JsonObject();
        JsonObject r11 = new JsonObject();
        HashMap r12 = new HashMap();
        HashMap r13 = new HashMap();
        String r14 = Annie.getAnnieVersionName();
        Intrinsics.checkNotNullParameter("", "channel");
        Intrinsics.checkNotNullParameter("", "appTheme");
        Intrinsics.checkNotNullParameter("", "versionCode");
        Intrinsics.checkNotNullParameter("", "webcastSdkVersion");
        Intrinsics.checkNotNullParameter("", com.bytedance.android.ec.core.event.a.KEY_LOCATION);
        Intrinsics.checkNotNullParameter("-1", "forestSessionId");
        Intrinsics.checkNotNullParameter("-1", "containerID");
        Intrinsics.checkNotNullParameter("", "initTimestamp");
        Intrinsics.checkNotNullParameter("", "containerInitTime");
        Intrinsics.checkNotNullParameter("0", "userID");
        Intrinsics.checkNotNullParameter("0", "secUserID");
        Intrinsics.checkNotNullParameter("0", "anchorID");
        Intrinsics.checkNotNullParameter("0", "secAnchorID");
        Intrinsics.checkNotNullParameter("0", "roomID");
        Intrinsics.checkNotNullParameter(r1, "settings");
        Intrinsics.checkNotNullParameter(r10, "activitySettings");
        Intrinsics.checkNotNullParameter(r11, "dynamicSettings");
        Intrinsics.checkNotNullParameter(r12, "abParams");
        Intrinsics.checkNotNullParameter(r13, "injectJson");
        Intrinsics.checkNotNullParameter("0", "openUDid");
        Intrinsics.checkNotNullParameter("android", "device_platform");
        Intrinsics.checkNotNullParameter("mobile", "devicePlatform");
        Intrinsics.checkNotNullParameter("Android", "os");
        Intrinsics.checkNotNullParameter("", "ac");
        Intrinsics.checkNotNullParameter("{}", "currentNetworkQualityInfo");
        Intrinsics.checkNotNullParameter("", "webcastLocale");
        Intrinsics.checkNotNullParameter("", "webcastGpsAccess");
        Intrinsics.checkNotNullParameter("", "webcastLanguage");
        Intrinsics.checkNotNullParameter("", "deviceType");
        Intrinsics.checkNotNullParameter("", "iid");
        Intrinsics.checkNotNullParameter("0", "minorStatus");
        Intrinsics.checkNotNullParameter("", "osApi");
        Intrinsics.checkNotNullParameter("", "fakeRegion");
        Intrinsics.checkNotNullParameter("", "hostAbi");
        Intrinsics.checkNotNullParameter("", "cpuSupport64");
        Intrinsics.checkNotNullParameter("", "resolution");
        Intrinsics.checkNotNullParameter("", "ts");
        Intrinsics.checkNotNullParameter("", "manifestVersionCode");
        Intrinsics.checkNotNullParameter("", "oaid");
        Intrinsics.checkNotNullParameter("", "cdid");
        Intrinsics.checkNotNullParameter("", "appType");
        Intrinsics.checkNotNullParameter("0", "dpi");
        Intrinsics.checkNotNullParameter("", "effectChannel");
        Intrinsics.checkNotNullParameter("", "addressBookAccess");
        Intrinsics.checkNotNullParameter("", "rticket");
        Intrinsics.checkNotNullParameter("", "isAndroidPad");
        Intrinsics.checkNotNullParameter("annie", "containerName");
        Intrinsics.checkNotNullParameter("0", "veDeviceScore");
        Intrinsics.checkNotNullParameter("", "osTheme");
        Intrinsics.checkNotNullParameter("", "networkType");
        Intrinsics.checkNotNullParameter(r14, "containerVersion");
        Intrinsics.checkNotNullParameter("webcast", "containerType");
        this.channel = "";
        this.appTheme = "";
        this.versionCode = "";
        this.webcastSdkVersion = "";
        this.isTeenMode = -1;
        this.location = "";
        this.forestSessionId = "-1";
        this.containerID = "-1";
        this.initTimestamp = "";
        this.containerInitTime = "";
        this.offline = 0;
        this.safeArea = null;
        this.userID = "0";
        this.secUserID = "0";
        this.anchorID = "0";
        this.secAnchorID = "0";
        this.roomID = "0";
        this.settings = r1;
        this.activitySettings = r10;
        this.dynamicSettings = r11;
        this.abParams = r12;
        this.queryItems = null;
        this.injectJson = r13;
        this.openUDid = "0";
        this.device_platform = "android";
        this.devicePlatform = "mobile";
        this.screenWidth = 0.0f;
        this.screenHeight = 0.0f;
        this.realScreenHeight = 0.0f;
        this.screenWidthPx = 0;
        this.screenHeightPx = 0;
        this.bottomBarHeight = 0;
        this.isNotch = 0;
        this.perf = 0;
        this.isPad = 0;
        this.os = "Android";
        this.f15ac = "";
        this.currentNetworkQualityInfo = "{}";
        this.webcastLocale = "";
        this.webcastGpsAccess = "";
        this.webcastLanguage = "";
        this.deviceType = "";
        this.systemViewZoom = 1.0f;
        this.iid = "";
        this.minorStatus = "0";
        this.osApi = "";
        this.fakeRegion = "";
        this.hostAbi = "";
        this.cpuSupport64 = "";
        this.resolution = "";
        this.ts = "";
        this.manifestVersionCode = "";
        this.oaid = "";
        this.cdid = "";
        this.appType = "";
        this.dpi = "0";
        this.effectChannel = "";
        this.addressBookAccess = "";
        this.rticket = "";
        this.isAndroidPad = "";
        this.webcastVersion = 0;
        this.padOptType = 0;
        this.containerName = "annie";
        this.veDeviceScore = "0";
        this.appRunTimeInfo = null;
        this.glEsVersion = 0;
        this.a = null;
        this.b = null;
        this.currentTime = 0;
        this.businessData = null;
        this.osTheme = "";
        this.networkType = "";
        this.isPrerender = 0;
        this.containerVersion = r14;
        this.containerType = "webcast";
        this.isDouyinSeries = false;
        this.jsbProxyAppId = "";
        this.isLogin = -1;
        this.aid = "";
        this.appID = "";
        this.deviceId = "0";
        this.deviceID = "0";
        this.app_name = "";
        this.appName = "";
        this.versionName = "";
        this.appVersion = "";
        this.update_version_code = "";
        this.updateVersionCode = "";
        this.lynx_version = "";
        this.lynxVersion = "";
        this.language = "";
        this.appLanguage = "";
        this.osLanguage = "";
        this.os_version = "";
        this.osVersion = "";
        this.systemFontScale = 1.0f;
        this.fontScale = 1.0f;
        this.device_brand = "";
        this.deviceBrand = "";
        this.device_score = "0";
        this.screenOrientation = "";
    }

    public final void A1(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.hostAbi = r10;
    }

    public final void B1(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.iid = r10;
    }

    public final void C1(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.initTimestamp = r10;
    }

    public final void D1(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.injectJson = r10;
    }

    public final void F1(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        this.language = r10;
        if (Intrinsics.areEqual(r10, this.appLanguage) == true) goto L6;
        Y0(this.language);
    L6:
        if (Intrinsics.areEqual(this.language, this.osLanguage) == true) goto L11;
        String r11 = this.language;
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        this.osLanguage = r11;
        if (Intrinsics.areEqual(r11, this.language) == true) goto L12;
        F1(this.osLanguage);
        return;
    L12:
        return;
    }

    public final void G1(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.location = r10;
    }

    public final void H1(int r1) {
        this.isLogin = r1;
    }

    public final void I1(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        this.lynxVersion = r10;
        if (Intrinsics.areEqual(r10, this.lynx_version) == true) goto L8;
        String r11 = this.lynxVersion;
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        this.lynx_version = r11;
        if (Intrinsics.areEqual(r11, this.lynxVersion) == true) goto L9;
        I1(this.lynx_version);
        return;
    L9:
        return;
    }

    public final void J1(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.manifestVersionCode = r10;
    }

    public final void K1(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.minorStatus = r10;
    }

    public final void L1(int r1) {
        this.isNotch = r1;
    }

    public final void M1(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.oaid = r10;
    }

    public final void N1(int r1) {
        this.offline = r1;
    }

    public final void O1(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.openUDid = r10;
    }

    public final void P1(int r10) {
        this.orientation = r10;
        if (r10 == 0) goto L11;
        if (r10 == 1) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(this.screenOrientation, "landscape") == true) goto L14;
        f2("landscape");
        return;
    L14:
        return;
    L11:
        if (Intrinsics.areEqual(this.screenOrientation, "portrait") == true) goto L16;
        f2("portrait");
        return;
    }

    public final void Q0(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.abParams = r10;
    }

    public final void Q1(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.osApi = r10;
    }

    public final void R0(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f15ac = r10;
    }

    public final void R1(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        this.osVersion = r10;
        if (Intrinsics.areEqual(r10, this.os_version) == true) goto L8;
        String r11 = this.osVersion;
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        this.os_version = r11;
        if (Intrinsics.areEqual(r11, this.osVersion) == true) goto L9;
        R1(this.os_version);
        return;
    L9:
        return;
    }

    public final void S0(int r10) {
        this.isAccessible = r10;
        if (r10 != 0) goto L10;
        if (this.accessible == false) goto L15;
        this.accessible = false;
        if (r10 == 0) goto L16;
        S0(0);
        return;
    L16:
        return;
    L15:
        return;
    L10:
        if (this.accessible == true) goto L18;
        this.accessible = true;
        if (r10 != 0) goto L19;
        S0(1);
        return;
    L19:
        return;
    }

    public final void S1(int r1) {
        this.isOversea = r1;
    }

    public final void T0(JsonObject r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.activitySettings = r10;
    }

    public final void T1(int r1) {
        this.isPad = r1;
    }

    public final void U0(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.addressBookAccess = r10;
    }

    public final void U1(int r1) {
        this.padOptType = r1;
    }

    public final void V0(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        this.aid = r10;
        if (Intrinsics.areEqual(r10, this.appID) == true) goto L8;
        String r11 = this.aid;
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        this.appID = r11;
        if (Intrinsics.areEqual(r11, this.aid) == true) goto L9;
        V0(this.appID);
        return;
    L9:
        return;
    }

    public final void V1(int r1) {
        this.perf = r1;
    }

    public final void W0(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.anchorID = r10;
    }

    public final void W1(int r1) {
        this.isPrerender = r1;
    }

    public final void X0(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.isAndroidPad = r10;
    }

    public final void X1(Map<String, String> r1) {
        this.queryItems = r1;
    }

    public final void Y0(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        this.appLanguage = r10;
        if (Intrinsics.areEqual(r10, this.language) == true) goto L6;
        F1(this.appLanguage);
        return;
    }

    public final void Y1(float r1) {
        this.realScreenHeight = r1;
    }

    public final void Z0(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        this.appName = r10;
        if (Intrinsics.areEqual(r10, this.app_name) == true) goto L8;
        String r11 = this.appName;
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        this.app_name = r11;
        if (Intrinsics.areEqual(r11, this.appName) == true) goto L9;
        Z0(this.app_name);
        return;
    L9:
        return;
    }

    public final void Z1(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.resolution = r10;
    }

    public final void a1(Map<String, ? extends Object> r1) {
        this.appRunTimeInfo = r1;
    }

    public final void a2(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.roomID = r10;
    }

    public final void b1(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.appTheme = r10;
    }

    public final void b2(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.rticket = r10;
    }

    public final void c1(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.appType = r10;
    }

    public final void c2(GetAppInfoResultModel.GetAppInfoSafeArea r1) {
        this.safeArea = r1;
    }

    public final void d1(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        this.appVersion = r10;
        if (Intrinsics.areEqual(r10, this.versionName) == true) goto L6;
        u2(this.appVersion);
        return;
    }

    public final void d2(float r1) {
        this.screenHeight = r1;
    }

    public final void e1(Map<String, ? extends Object> r1) {
        this.businessData = r1;
    }

    public final void e2(int r1) {
        this.screenHeightPx = r1;
    }

    public final void f1(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.cdid = r10;
    }

    public final void f2(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        this.screenOrientation = r10;
        if (Intrinsics.areEqual(r10, "portrait") == false) goto L8;
        if (this.orientation == 0) goto L13;
        P1(0);
        return;
    L13:
        return;
    L8:
        if (Intrinsics.areEqual(r10, "landscape") == true) goto L10;
        return;
    L10:
        if (this.orientation == 1) goto L16;
        P1(1);
        return;
    }

    public final void g1(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.channel = r10;
    }

    public final void g2(float r1) {
        this.screenWidth = r1;
    }

    public final void h1(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.containerID = r10;
    }

    public final void h2(int r1) {
        this.screenWidthPx = r1;
    }

    public final void i1(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.containerInitTime = r10;
    }

    public final void i2(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.secAnchorID = r10;
    }

    public final void j1(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.cpuSupport64 = r10;
    }

    public final void j2(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.secUserID = r10;
    }

    public final void k1(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.currentNetworkQualityInfo = r10;
    }

    public final void k2(JsonObject r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.settings = r10;
    }

    public final void l1(long r1) {
        this.currentTime = r1;
    }

    public final void l2(float r10) {
        this.statusBarHeight = r10;
        boolean r1 = true;
        if (r10 != this.status_bar_height) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L14;
        this.status_bar_height = r10;
        if (r10 == r10) goto L11;
        r1 = false;
    L11:
        if (r1 == true) goto L15;
        l2(r10);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void m1(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        this.deviceBrand = r10;
        if (Intrinsics.areEqual(r10, this.device_brand) == true) goto L8;
        String r11 = this.deviceBrand;
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        this.device_brand = r11;
        if (Intrinsics.areEqual(r11, this.deviceBrand) == true) goto L9;
        m1(this.device_brand);
        return;
    L9:
        return;
    }

    public final void m2(float r10) {
        this.systemFontScale = r10;
        if (r10 != this.fontScale) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        x1(r10);
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void n1(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        this.deviceID = r10;
        if (Intrinsics.areEqual(r10, this.deviceId) == true) goto L6;
        o1(this.deviceID);
        return;
    }

    public final void n2(float r1) {
        this.systemViewZoom = r1;
    }

    public final void o1(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        this.deviceId = r10;
        if (Intrinsics.areEqual(r10, this.deviceID) == true) goto L6;
        n1(this.deviceId);
        return;
    }

    public final void o2(int r1) {
        this.isTeenMode = r1;
    }

    public final void p1(float r10) {
        this.deviceScore = r10;
        if (r10 != CastFloatProtector.parseFloat(this.device_score)) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == true) goto L9;
        r1(String.valueOf(this.deviceScore));
        return;
    L9:
        return;
    L5:
        r11 = false;
        goto L6
    }

    public final void p2(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.ts = r10;
    }

    public final void q1(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.deviceType = r10;
    }

    public final void q2(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        this.updateVersionCode = r10;
        if (Intrinsics.areEqual(r10, this.update_version_code) == true) goto L8;
        String r11 = this.updateVersionCode;
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        this.update_version_code = r11;
        if (Intrinsics.areEqual(r11, this.updateVersionCode) == true) goto L9;
        q2(this.update_version_code);
        return;
    L9:
        return;
    }

    public final void r1(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        this.device_score = r10;
        if (CastFloatProtector.parseFloat(r10) != this.deviceScore) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == true) goto L9;
        p1(CastFloatProtector.parseFloat(this.device_score));
        return;
    L9:
        return;
    L5:
        r11 = false;
        goto L6
    }

    public final void r2(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.userID = r10;
    }

    public final void s1(boolean r1) {
        this.isDouyinSeries = r1;
    }

    public final void s2(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.veDeviceScore = r10;
    }

    public final void t1(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.dpi = r10;
    }

    public final void t2(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.versionCode = r10;
    }

    public final void u1(JsonObject r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.dynamicSettings = r10;
    }

    public final void u2(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        this.versionName = r10;
        if (Intrinsics.areEqual(r10, this.appVersion) == true) goto L6;
        d1(this.versionName);
        return;
    }

    public final void v1(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.effectChannel = r10;
    }

    public final void v2(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.webcastGpsAccess = r10;
    }

    public final void w1(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.fakeRegion = r10;
    }

    public final void w2(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.webcastLanguage = r10;
    }

    public final void x1(float r10) {
        this.fontScale = r10;
        if (r10 != this.systemFontScale) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        m2(r10);
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void x2(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.webcastLocale = r10;
    }

    public final void y1(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.forestSessionId = r10;
    }

    public final void y2(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.webcastSdkVersion = r10;
    }

    public final void z1(int r1) {
        this.glEsVersion = r1;
    }

    public final void z2(int r1) {
        this.webcastVersion = r1;
    }
}
