package com.bytedance.android.live.base.model.shopping;

import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0006\n\u0002\b/\n\u0002\u0010 \n\u0002\bc\n\u0002\u0010\u0002\n\u0002\bV\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0004J\u0007\u0010\u0097\u0001\u001a\u00020\u0010J\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0004J\t\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0004J\u0007\u0010\u009a\u0001\u001a\u00020\u001fJ\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0004J\u0007\u0010\u009c\u0001\u001a\u00020\u0010J\u0007\u0010\u009d\u0001\u001a\u00020.J\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0004J\t\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0004J\u0007\u0010 \u0001\u001a\u00020\u0010J\u0007\u0010¡\u0001\u001a\u00020\u0010J\u0007\u0010¢\u0001\u001a\u00020\u0010J\u0007\u0010£\u0001\u001a\u00020\u0010J\u0007\u0010¤\u0001\u001a\u00020\u0010J\u0007\u0010¥\u0001\u001a\u00020\u001fJ\u0007\u0010¦\u0001\u001a\u00020\u0010J\u0007\u0010§\u0001\u001a\u00020\u0010J\u0007\u0010¨\u0001\u001a\u00020\u0010J\u0007\u0010©\u0001\u001a\u00020\u0010J\u0007\u0010ª\u0001\u001a\u00020\u0010J\u000f\u0010«\u0001\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010^J\t\u0010¬\u0001\u001a\u0004\u0018\u00010\u0004J\t\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u0004J\t\u0010®\u0001\u001a\u0004\u0018\u00010\u0004J\t\u0010¯\u0001\u001a\u0004\u0018\u00010\u0004J\t\u0010°\u0001\u001a\u0004\u0018\u00010\u0004J\u0007\u0010±\u0001\u001a\u00020\u0010J\u0007\u0010²\u0001\u001a\u00020\u0010J\u0007\u0010³\u0001\u001a\u00020\u0010J\u0007\u0010´\u0001\u001a\u00020\u0010J\u0007\u0010µ\u0001\u001a\u00020\u0010J\t\u0010¶\u0001\u001a\u0004\u0018\u00010\u0004J\t\u0010·\u0001\u001a\u0004\u0018\u00010\u0004J\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u0004J\t\u0010¹\u0001\u001a\u0004\u0018\u00010\u0004J\u0007\u0010º\u0001\u001a\u00020\u0010J\u0007\u0010»\u0001\u001a\u00020\u0010J\t\u0010¼\u0001\u001a\u0004\u0018\u00010\u0004J\u0007\u0010½\u0001\u001a\u00020\nJ\u0007\u0010¾\u0001\u001a\u00020\nJ\u0007\u0010¿\u0001\u001a\u00020\nJ\u0007\u0010À\u0001\u001a\u00020\nJ\u0013\u0010Á\u0001\u001a\u00030Â\u00012\t\u0010Ã\u0001\u001a\u0004\u0018\u00010\u0004J\u0011\u0010Ä\u0001\u001a\u00030Â\u00012\u0007\u0010Å\u0001\u001a\u00020\nJ\u0011\u0010Æ\u0001\u001a\u00030Â\u00012\u0007\u0010Ç\u0001\u001a\u00020\u0010J\u0013\u0010È\u0001\u001a\u00030Â\u00012\t\u0010É\u0001\u001a\u0004\u0018\u00010\u0004J\u0013\u0010Ê\u0001\u001a\u00030Â\u00012\t\u0010Ë\u0001\u001a\u0004\u0018\u00010\u0004J\u0011\u0010Ì\u0001\u001a\u00030Â\u00012\u0007\u0010Í\u0001\u001a\u00020\nJ\u0011\u0010Î\u0001\u001a\u00030Â\u00012\u0007\u0010Ï\u0001\u001a\u00020\u001fJ\u0011\u0010Ð\u0001\u001a\u00030Â\u00012\u0007\u0010Ñ\u0001\u001a\u00020\nJ\u0013\u0010Ò\u0001\u001a\u00030Â\u00012\t\u0010Ó\u0001\u001a\u0004\u0018\u00010\u0004J\u0011\u0010Ô\u0001\u001a\u00030Â\u00012\u0007\u0010Õ\u0001\u001a\u00020\u0010J\u0011\u0010Ö\u0001\u001a\u00030Â\u00012\u0007\u0010×\u0001\u001a\u00020.J\u0013\u0010Ø\u0001\u001a\u00030Â\u00012\t\u0010Ù\u0001\u001a\u0004\u0018\u00010\u0004J\u0013\u0010Ú\u0001\u001a\u00030Â\u00012\t\u0010Û\u0001\u001a\u0004\u0018\u00010\u0004J\u0011\u0010Ü\u0001\u001a\u00030Â\u00012\u0007\u0010Ý\u0001\u001a\u00020\u0010J\u0011\u0010Þ\u0001\u001a\u00030Â\u00012\u0007\u0010ß\u0001\u001a\u00020\u0010J\u0011\u0010à\u0001\u001a\u00030Â\u00012\u0007\u0010á\u0001\u001a\u00020\nJ\u0011\u0010â\u0001\u001a\u00030Â\u00012\u0007\u0010ã\u0001\u001a\u00020\u0010J\u0011\u0010ä\u0001\u001a\u00030Â\u00012\u0007\u0010å\u0001\u001a\u00020\u0010J\u0011\u0010æ\u0001\u001a\u00030Â\u00012\u0007\u0010ç\u0001\u001a\u00020\u0010J\u0011\u0010è\u0001\u001a\u00030Â\u00012\u0007\u0010é\u0001\u001a\u00020\u001fJ\u0011\u0010ê\u0001\u001a\u00030Â\u00012\u0007\u0010ë\u0001\u001a\u00020\u0010J\u0011\u0010ì\u0001\u001a\u00030Â\u00012\u0007\u0010í\u0001\u001a\u00020\u0010J\u0011\u0010î\u0001\u001a\u00030Â\u00012\u0007\u0010ï\u0001\u001a\u00020\u0010J\u0011\u0010ð\u0001\u001a\u00030Â\u00012\u0007\u0010ñ\u0001\u001a\u00020\u0010J\u0011\u0010ò\u0001\u001a\u00030Â\u00012\u0007\u0010ó\u0001\u001a\u00020\u0010J\u0019\u0010ô\u0001\u001a\u00030Â\u00012\u000f\u0010õ\u0001\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010^J\u0013\u0010ö\u0001\u001a\u00030Â\u00012\t\u0010÷\u0001\u001a\u0004\u0018\u00010\u0004J\u0013\u0010ø\u0001\u001a\u00030Â\u00012\t\u0010ù\u0001\u001a\u0004\u0018\u00010\u0004J\u0013\u0010ú\u0001\u001a\u00030Â\u00012\t\u0010û\u0001\u001a\u0004\u0018\u00010\u0004J\u0013\u0010ü\u0001\u001a\u00030Â\u00012\t\u0010ý\u0001\u001a\u0004\u0018\u00010\u0004J\u0013\u0010þ\u0001\u001a\u00030Â\u00012\t\u0010ÿ\u0001\u001a\u0004\u0018\u00010\u0004J\u0011\u0010\u0080\u0002\u001a\u00030Â\u00012\u0007\u0010\u0081\u0002\u001a\u00020\u0010J\u0011\u0010\u0082\u0002\u001a\u00030Â\u00012\u0007\u0010\u0083\u0002\u001a\u00020\u0010J\u0011\u0010\u0084\u0002\u001a\u00030Â\u00012\u0007\u0010\u0085\u0002\u001a\u00020\u0010J\u0011\u0010\u0086\u0002\u001a\u00030Â\u00012\u0007\u0010\u0087\u0002\u001a\u00020\u0010J\u0011\u0010\u0088\u0002\u001a\u00030Â\u00012\u0007\u0010\u0089\u0002\u001a\u00020\u0010J\u0013\u0010\u008a\u0002\u001a\u00030Â\u00012\t\u0010\u008b\u0002\u001a\u0004\u0018\u00010\u0004J\u0013\u0010\u008c\u0002\u001a\u00030Â\u00012\t\u0010\u008d\u0002\u001a\u0004\u0018\u00010\u0004J\u0013\u0010\u008e\u0002\u001a\u00030Â\u00012\t\u0010\u008f\u0002\u001a\u0004\u0018\u00010\u0004J\u0013\u0010\u0090\u0002\u001a\u00030Â\u00012\t\u0010\u0091\u0002\u001a\u0004\u0018\u00010\u0004J\u0011\u0010\u0092\u0002\u001a\u00030Â\u00012\u0007\u0010\u0093\u0002\u001a\u00020\u0010J\u0011\u0010\u0094\u0002\u001a\u00030Â\u00012\u0007\u0010\u0095\u0002\u001a\u00020\u0010J\u0013\u0010\u0096\u0002\u001a\u00030Â\u00012\t\u0010\u0097\u0002\u001a\u0004\u0018\u00010\u0004R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR \u0010'\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001e\u0010*\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014R\u001e\u0010-\u001a\u00020.8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R \u00103\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR \u00106\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR\u001e\u00109\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0012\"\u0004\b;\u0010\u0014R\u001e\u0010<\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0012\"\u0004\b>\u0010\u0014R\u001e\u0010?\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\f\"\u0004\bA\u0010\u000eR\u001e\u0010B\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0012\"\u0004\bD\u0010\u0014R\u001e\u0010E\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0012\"\u0004\bG\u0010\u0014R\u001e\u0010H\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0012\"\u0004\bJ\u0010\u0014R\u001e\u0010K\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010!\"\u0004\bM\u0010#R\u001e\u0010N\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0012\"\u0004\bP\u0010\u0014R\u001e\u0010Q\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0012\"\u0004\bS\u0010\u0014R\u001e\u0010T\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0012\"\u0004\bV\u0010\u0014R\u001e\u0010W\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u0012\"\u0004\bY\u0010\u0014R\u001e\u0010Z\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u0012\"\u0004\b\\\u0010\u0014R&\u0010]\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010^8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR \u0010c\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\u0006\"\u0004\be\u0010\bR \u0010f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u0006\"\u0004\bh\u0010\bR \u0010i\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\u0006\"\u0004\bk\u0010\bR \u0010l\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\u0006\"\u0004\bn\u0010\bR \u0010o\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010\u0006\"\u0004\bq\u0010\bR\u001e\u0010r\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\u0012\"\u0004\bt\u0010\u0014R\u001e\u0010u\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010\u0012\"\u0004\bw\u0010\u0014R\u001e\u0010x\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010\u0012\"\u0004\bz\u0010\u0014R\u001e\u0010{\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010\u0012\"\u0004\b}\u0010\u0014R\u001f\u0010~\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010\u0012\"\u0005\b\u0080\u0001\u0010\u0014R#\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010\u0006\"\u0005\b\u0083\u0001\u0010\bR#\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u0010\u0006\"\u0005\b\u0086\u0001\u0010\bR#\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u0010\u0006\"\u0005\b\u0089\u0001\u0010\bR#\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008b\u0001\u0010\u0006\"\u0005\b\u008c\u0001\u0010\bR!\u0010\u008d\u0001\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u0010\u0012\"\u0005\b\u008f\u0001\u0010\u0014R!\u0010\u0090\u0001\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010\u0012\"\u0005\b\u0092\u0001\u0010\u0014R#\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010\u0006\"\u0005\b\u0095\u0001\u0010\b¨\u0006\u0098\u0002"}, d2 = {"Lcom/bytedance/android/live/base/model/shopping/LiveCouponMeta;", "", "()V", "_avatar", "", "get_avatar", "()Ljava/lang/String;", "set_avatar", "(Ljava/lang/String;)V", "_canContinueApply", "", "get_canContinueApply", "()Z", "set_canContinueApply", "(Z)V", "_channelId", "", "get_channelId", "()J", "set_channelId", "(J)V", "_couponMetaId", "get_couponMetaId", "set_couponMetaId", "_couponName", "get_couponName", "set_couponName", "_couponReset", "get_couponReset", "set_couponReset", "_couponSource", "", "get_couponSource", "()I", "set_couponSource", "(I)V", "_couponStatus", "get_couponStatus", "set_couponStatus", "_couponString", "get_couponString", "set_couponString", "_credit", "get_credit", "set_credit", "_discount", "", "get_discount", "()D", "set_discount", "(D)V", "_endApplyTime", "get_endApplyTime", "set_endApplyTime", "_expireTime", "get_expireTime", "set_expireTime", "_expireTimeStamp", "get_expireTimeStamp", "set_expireTimeStamp", "_hasApplied", "get_hasApplied", "set_hasApplied", "_hasAvailableGoods", "get_hasAvailableGoods", "set_hasAvailableGoods", "_isShow", "get_isShow", "set_isShow", "_kolUid", "get_kolUid", "set_kolUid", "_leftAmount", "get_leftAmount", "set_leftAmount", "_liveCouponStatus", "get_liveCouponStatus", "set_liveCouponStatus", "_maxApplyTimes", "get_maxApplyTimes", "set_maxApplyTimes", "_maxDiscountLimit", "get_maxDiscountLimit", "set_maxDiscountLimit", "_payType", "get_payType", "set_payType", "_periodType", "get_periodType", "set_periodType", "_platformSubType", "get_platformSubType", "set_platformSubType", "_productIds", "", "get_productIds", "()Ljava/util/List;", "set_productIds", "(Ljava/util/List;)V", "_shopId", "get_shopId", "set_shopId", "_shopLogo", "get_shopLogo", "set_shopLogo", "_shopName", "get_shopName", "set_shopName", "_startApplyTime", "get_startApplyTime", "set_startApplyTime", "_startTime", "get_startTime", "set_startTime", "_startTimeStamp", "get_startTimeStamp", "set_startTimeStamp", "_status", "get_status", "set_status", "_threshold", "get_threshold", "set_threshold", "_totalAmount", "get_totalAmount", "set_totalAmount", "_type", "get_type", "set_type", "_typeDetail", "get_typeDetail", "set_typeDetail", "_typeString", "get_typeString", "set_typeString", "_typeTitle", "get_typeTitle", "set_typeTitle", "_url", "get_url", "set_url", "_userApplyTimes", "get_userApplyTimes", "set_userApplyTimes", "_validPeriod", "get_validPeriod", "set_validPeriod", "_whatCoupon", "get_whatCoupon", "set_whatCoupon", "getAvatar", "getChannelId", "getCouponMetaId", "getCouponName", "getCouponSource", "getCouponString", "getCredit", "getDiscount", "getEndApplyTime", "getExpireTime", "getExpireTimeStamp", "getHasApplied", "getIsShow", "getKolUid", "getLeftAmount", "getLiveCouponStatus", "getMaxApplyTimes", "getMaxDiscountLimit", "getPayType", "getPeriodType", "getPlatformSubType", "getProductIds", "getShopId", "getShopLogo", "getShopName", "getStartApplyTime", "getStartTime", "getStartTimeStamp", "getStatus", "getThreshold", "getTotalAmount", "getType", "getTypeDetail", "getTypeString", "getTypeTitle", "getUrl", "getUserApplyTimes", "getValidPeriod", "getWhatCoupon", "isCanContinueApply", "isCouponReset", "isCouponStatus", "isHasAvailableGoods", "setAvatar", "", "avatar", "setCanContinueApply", "canContinueApply", "setChannelId", "channelId", "setCouponMetaId", "couponMetaId", "setCouponName", "couponName", "setCouponReset", "couponReset", "setCouponSource", "couponSource", "setCouponStatus", "couponStatus", "setCouponString", "couponString", "setCredit", "credit", "setDiscount", "discount", "setEndApplyTime", "endApplyTime", "setExpireTime", "expireTime", "setExpireTimeStamp", "expireTimeStamp", "setHasApplied", "hasApplied", "setHasAvailableGoods", "hasAvailableGoods", "setIsShow", "isShow", "setKolUid", "kolUid", "setLeftAmount", "leftAmount", "setLiveCouponStatus", "liveCouponStatus", "setMaxApplyTimes", "maxApplyTimes", "setMaxDiscountLimit", "maxDiscountLimit", "setPayType", "payType", "setPeriodType", "periodType", "setPlatformSubType", "platformSubType", "setProductIds", "productIds", "setShopId", "shopId", "setShopLogo", "shopLogo", "setShopName", "shopName", "setStartApplyTime", "startApplyTime", "setStartTime", "startTime", "setStartTimeStamp", "startTimeStamp", "setStatus", "status", "setThreshold", "threshold", "setTotalAmount", "totalAmount", "setType", "type", "setTypeDetail", "typeDetail", "setTypeString", "typeString", "setTypeTitle", "typeTitle", "setUrl", LiveSlardarConstants.EXTRA_KEY_URL, "setUserApplyTimes", "userApplyTimes", "setValidPeriod", "validPeriod", "setWhatCoupon", "whatCoupon", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCouponMeta {

    @SerializedName("avatar")
    private String _avatar;

    @SerializedName("can_continue_apply")
    private boolean _canContinueApply;

    @SerializedName("channel_id")
    private long _channelId;

    @SerializedName("coupon_meta_id")
    private String _couponMetaId;

    @SerializedName("coupon_name")
    private String _couponName;

    @SerializedName("coupon_reset")
    private boolean _couponReset;

    @SerializedName("coupon_source")
    private int _couponSource;

    @SerializedName("coupon_status")
    private boolean _couponStatus;

    @SerializedName("coupon_string")
    private String _couponString;

    @SerializedName("credit")
    private long _credit;

    @SerializedName("discount")
    private double _discount;

    @SerializedName("end_apply_time")
    private String _endApplyTime;

    @SerializedName("expire_time")
    private String _expireTime;

    @SerializedName("expire_time_timestamp")
    private long _expireTimeStamp;

    @SerializedName("has_applied")
    private long _hasApplied;

    @SerializedName("has_available_goods")
    private boolean _hasAvailableGoods;

    @SerializedName("is_show")
    private long _isShow;

    @SerializedName("kol_uid")
    private long _kolUid;

    @SerializedName("left_amount")
    private long _leftAmount;

    @SerializedName("live_coupon_status")
    private int _liveCouponStatus;

    @SerializedName("max_apply_times")
    private long _maxApplyTimes;

    @SerializedName("max_discount_limit")
    private long _maxDiscountLimit;

    @SerializedName("pay_type")
    private long _payType;

    @SerializedName("period_type")
    private long _periodType;

    @SerializedName("platform_sub_type")
    private long _platformSubType;

    @SerializedName("product_ids")
    private List<Long> _productIds;

    @SerializedName("shop_id")
    private String _shopId;

    @SerializedName("shop_logo")
    private String _shopLogo;

    @SerializedName("shop_name")
    private String _shopName;

    @SerializedName("start_apply_time")
    private String _startApplyTime;

    @SerializedName("start_time")
    private String _startTime;

    @SerializedName("start_time_timestamp")
    private long _startTimeStamp;

    @SerializedName("status")
    private long _status;

    @SerializedName("threshold")
    private long _threshold;

    @SerializedName("total_amount")
    private long _totalAmount;

    @SerializedName("type")
    private long _type;

    @SerializedName("type_detail")
    private String _typeDetail;

    @SerializedName("type_string")
    private String _typeString;

    @SerializedName("type_title")
    private String _typeTitle;

    @SerializedName(LiveSlardarConstants.EXTRA_KEY_URL)
    private String _url;

    @SerializedName("user_apply_times")
    private long _userApplyTimes;

    @SerializedName("valid_period")
    private long _validPeriod;

    @SerializedName("what_coupon")
    private String _whatCoupon;

    public LiveCouponMeta() {
    }

    public final String getAvatar() {
        return this._avatar;
    }

    public final long getChannelId() {
        return this._channelId;
    }

    public final String getCouponMetaId() {
        return this._couponMetaId;
    }

    public final String getCouponName() {
        return this._couponName;
    }

    public final int getCouponSource() {
        return this._couponSource;
    }

    public final String getCouponString() {
        return this._couponString;
    }

    public final long getCredit() {
        return this._credit;
    }

    public final double getDiscount() {
        return this._discount;
    }

    public final String getEndApplyTime() {
        return this._endApplyTime;
    }

    public final String getExpireTime() {
        return this._expireTime;
    }

    public final long getExpireTimeStamp() {
        return this._expireTimeStamp;
    }

    public final long getHasApplied() {
        return this._hasApplied;
    }

    public final long getIsShow() {
        return this._isShow;
    }

    public final long getKolUid() {
        return this._kolUid;
    }

    public final long getLeftAmount() {
        return this._leftAmount;
    }

    public final int getLiveCouponStatus() {
        return this._liveCouponStatus;
    }

    public final long getMaxApplyTimes() {
        return this._maxApplyTimes;
    }

    public final long getMaxDiscountLimit() {
        return this._maxDiscountLimit;
    }

    public final long getPayType() {
        return this._payType;
    }

    public final long getPeriodType() {
        return this._periodType;
    }

    public final long getPlatformSubType() {
        return this._platformSubType;
    }

    public final List<Long> getProductIds() {
        return this._productIds;
    }

    public final String getShopId() {
        return this._shopId;
    }

    public final String getShopLogo() {
        return this._shopLogo;
    }

    public final String getShopName() {
        return this._shopName;
    }

    public final String getStartApplyTime() {
        return this._startApplyTime;
    }

    public final String getStartTime() {
        return this._startTime;
    }

    public final long getStartTimeStamp() {
        return this._startTimeStamp;
    }

    public final long getStatus() {
        return this._status;
    }

    public final long getThreshold() {
        return this._threshold;
    }

    public final long getTotalAmount() {
        return this._totalAmount;
    }

    public final long getType() {
        return this._type;
    }

    public final String getTypeDetail() {
        return this._typeDetail;
    }

    public final String getTypeString() {
        return this._typeString;
    }

    public final String getTypeTitle() {
        return this._typeTitle;
    }

    public final String getUrl() {
        return this._url;
    }

    public final long getUserApplyTimes() {
        return this._userApplyTimes;
    }

    public final long getValidPeriod() {
        return this._validPeriod;
    }

    public final String getWhatCoupon() {
        return this._whatCoupon;
    }

    public final String get_avatar() {
        return this._avatar;
    }

    public final boolean get_canContinueApply() {
        return this._canContinueApply;
    }

    public final long get_channelId() {
        return this._channelId;
    }

    public final String get_couponMetaId() {
        return this._couponMetaId;
    }

    public final String get_couponName() {
        return this._couponName;
    }

    public final boolean get_couponReset() {
        return this._couponReset;
    }

    public final int get_couponSource() {
        return this._couponSource;
    }

    public final boolean get_couponStatus() {
        return this._couponStatus;
    }

    public final String get_couponString() {
        return this._couponString;
    }

    public final long get_credit() {
        return this._credit;
    }

    public final double get_discount() {
        return this._discount;
    }

    public final String get_endApplyTime() {
        return this._endApplyTime;
    }

    public final String get_expireTime() {
        return this._expireTime;
    }

    public final long get_expireTimeStamp() {
        return this._expireTimeStamp;
    }

    public final long get_hasApplied() {
        return this._hasApplied;
    }

    public final boolean get_hasAvailableGoods() {
        return this._hasAvailableGoods;
    }

    public final long get_isShow() {
        return this._isShow;
    }

    public final long get_kolUid() {
        return this._kolUid;
    }

    public final long get_leftAmount() {
        return this._leftAmount;
    }

    public final int get_liveCouponStatus() {
        return this._liveCouponStatus;
    }

    public final long get_maxApplyTimes() {
        return this._maxApplyTimes;
    }

    public final long get_maxDiscountLimit() {
        return this._maxDiscountLimit;
    }

    public final long get_payType() {
        return this._payType;
    }

    public final long get_periodType() {
        return this._periodType;
    }

    public final long get_platformSubType() {
        return this._platformSubType;
    }

    public final List<Long> get_productIds() {
        return this._productIds;
    }

    public final String get_shopId() {
        return this._shopId;
    }

    public final String get_shopLogo() {
        return this._shopLogo;
    }

    public final String get_shopName() {
        return this._shopName;
    }

    public final String get_startApplyTime() {
        return this._startApplyTime;
    }

    public final String get_startTime() {
        return this._startTime;
    }

    public final long get_startTimeStamp() {
        return this._startTimeStamp;
    }

    public final long get_status() {
        return this._status;
    }

    public final long get_threshold() {
        return this._threshold;
    }

    public final long get_totalAmount() {
        return this._totalAmount;
    }

    public final long get_type() {
        return this._type;
    }

    public final String get_typeDetail() {
        return this._typeDetail;
    }

    public final String get_typeString() {
        return this._typeString;
    }

    public final String get_typeTitle() {
        return this._typeTitle;
    }

    public final String get_url() {
        return this._url;
    }

    public final long get_userApplyTimes() {
        return this._userApplyTimes;
    }

    public final long get_validPeriod() {
        return this._validPeriod;
    }

    public final String get_whatCoupon() {
        return this._whatCoupon;
    }

    public final boolean isCanContinueApply() {
        return this._canContinueApply;
    }

    public final boolean isCouponReset() {
        return this._couponReset;
    }

    public final boolean isCouponStatus() {
        return this._couponStatus;
    }

    public final boolean isHasAvailableGoods() {
        return this._hasAvailableGoods;
    }

    public final void setAvatar(String r1) {
        this._avatar = r1;
    }

    public final void setCanContinueApply(boolean r1) {
        this._canContinueApply = r1;
    }

    public final void setChannelId(long r1) {
        this._channelId = r1;
    }

    public final void setCouponMetaId(String r1) {
        this._couponMetaId = r1;
    }

    public final void setCouponName(String r1) {
        this._couponName = r1;
    }

    public final void setCouponReset(boolean r1) {
        this._couponReset = r1;
    }

    public final void setCouponSource(int r1) {
        this._couponSource = r1;
    }

    public final void setCouponStatus(boolean r1) {
        this._couponStatus = r1;
    }

    public final void setCouponString(String r1) {
        this._couponString = r1;
    }

    public final void setCredit(long r1) {
        this._credit = r1;
    }

    public final void setDiscount(double r1) {
        this._discount = r1;
    }

    public final void setEndApplyTime(String r1) {
        this._endApplyTime = r1;
    }

    public final void setExpireTime(String r1) {
        this._expireTime = r1;
    }

    public final void setExpireTimeStamp(long r1) {
        this._expireTimeStamp = r1;
    }

    public final void setHasApplied(long r1) {
        this._hasApplied = r1;
    }

    public final void setHasAvailableGoods(boolean r1) {
        this._hasAvailableGoods = r1;
    }

    public final void setIsShow(long r1) {
        this._isShow = r1;
    }

    public final void setKolUid(long r1) {
        this._kolUid = r1;
    }

    public final void setLeftAmount(long r1) {
        this._leftAmount = r1;
    }

    public final void setLiveCouponStatus(int r1) {
        this._liveCouponStatus = r1;
    }

    public final void setMaxApplyTimes(long r1) {
        this._maxApplyTimes = r1;
    }

    public final void setMaxDiscountLimit(long r1) {
        this._maxDiscountLimit = r1;
    }

    public final void setPayType(long r1) {
        this._payType = r1;
    }

    public final void setPeriodType(long r1) {
        this._periodType = r1;
    }

    public final void setPlatformSubType(long r1) {
        this._platformSubType = r1;
    }

    public final void setProductIds(List<Long> r1) {
        this._productIds = r1;
    }

    public final void setShopId(String r1) {
        this._shopId = r1;
    }

    public final void setShopLogo(String r1) {
        this._shopLogo = r1;
    }

    public final void setShopName(String r1) {
        this._shopName = r1;
    }

    public final void setStartApplyTime(String r1) {
        this._startApplyTime = r1;
    }

    public final void setStartTime(String r1) {
        this._startTime = r1;
    }

    public final void setStartTimeStamp(long r1) {
        this._startTimeStamp = r1;
    }

    public final void setStatus(long r1) {
        this._status = r1;
    }

    public final void setThreshold(long r1) {
        this._threshold = r1;
    }

    public final void setTotalAmount(long r1) {
        this._totalAmount = r1;
    }

    public final void setType(long r1) {
        this._type = r1;
    }

    public final void setTypeDetail(String r1) {
        this._typeDetail = r1;
    }

    public final void setTypeString(String r1) {
        this._typeString = r1;
    }

    public final void setTypeTitle(String r1) {
        this._typeTitle = r1;
    }

    public final void setUrl(String r1) {
        this._url = r1;
    }

    public final void setUserApplyTimes(long r1) {
        this._userApplyTimes = r1;
    }

    public final void setValidPeriod(long r1) {
        this._validPeriod = r1;
    }

    public final void setWhatCoupon(String r1) {
        this._whatCoupon = r1;
    }

    public final void set_avatar(String r1) {
        this._avatar = r1;
    }

    public final void set_canContinueApply(boolean r1) {
        this._canContinueApply = r1;
    }

    public final void set_channelId(long r1) {
        this._channelId = r1;
    }

    public final void set_couponMetaId(String r1) {
        this._couponMetaId = r1;
    }

    public final void set_couponName(String r1) {
        this._couponName = r1;
    }

    public final void set_couponReset(boolean r1) {
        this._couponReset = r1;
    }

    public final void set_couponSource(int r1) {
        this._couponSource = r1;
    }

    public final void set_couponStatus(boolean r1) {
        this._couponStatus = r1;
    }

    public final void set_couponString(String r1) {
        this._couponString = r1;
    }

    public final void set_credit(long r1) {
        this._credit = r1;
    }

    public final void set_discount(double r1) {
        this._discount = r1;
    }

    public final void set_endApplyTime(String r1) {
        this._endApplyTime = r1;
    }

    public final void set_expireTime(String r1) {
        this._expireTime = r1;
    }

    public final void set_expireTimeStamp(long r1) {
        this._expireTimeStamp = r1;
    }

    public final void set_hasApplied(long r1) {
        this._hasApplied = r1;
    }

    public final void set_hasAvailableGoods(boolean r1) {
        this._hasAvailableGoods = r1;
    }

    public final void set_isShow(long r1) {
        this._isShow = r1;
    }

    public final void set_kolUid(long r1) {
        this._kolUid = r1;
    }

    public final void set_leftAmount(long r1) {
        this._leftAmount = r1;
    }

    public final void set_liveCouponStatus(int r1) {
        this._liveCouponStatus = r1;
    }

    public final void set_maxApplyTimes(long r1) {
        this._maxApplyTimes = r1;
    }

    public final void set_maxDiscountLimit(long r1) {
        this._maxDiscountLimit = r1;
    }

    public final void set_payType(long r1) {
        this._payType = r1;
    }

    public final void set_periodType(long r1) {
        this._periodType = r1;
    }

    public final void set_platformSubType(long r1) {
        this._platformSubType = r1;
    }

    public final void set_productIds(List<Long> r1) {
        this._productIds = r1;
    }

    public final void set_shopId(String r1) {
        this._shopId = r1;
    }

    public final void set_shopLogo(String r1) {
        this._shopLogo = r1;
    }

    public final void set_shopName(String r1) {
        this._shopName = r1;
    }

    public final void set_startApplyTime(String r1) {
        this._startApplyTime = r1;
    }

    public final void set_startTime(String r1) {
        this._startTime = r1;
    }

    public final void set_startTimeStamp(long r1) {
        this._startTimeStamp = r1;
    }

    public final void set_status(long r1) {
        this._status = r1;
    }

    public final void set_threshold(long r1) {
        this._threshold = r1;
    }

    public final void set_totalAmount(long r1) {
        this._totalAmount = r1;
    }

    public final void set_type(long r1) {
        this._type = r1;
    }

    public final void set_typeDetail(String r1) {
        this._typeDetail = r1;
    }

    public final void set_typeString(String r1) {
        this._typeString = r1;
    }

    public final void set_typeTitle(String r1) {
        this._typeTitle = r1;
    }

    public final void set_url(String r1) {
        this._url = r1;
    }

    public final void set_userApplyTimes(long r1) {
        this._userApplyTimes = r1;
    }

    public final void set_validPeriod(long r1) {
        this._validPeriod = r1;
    }

    public final void set_whatCoupon(String r1) {
        this._whatCoupon = r1;
    }
}
