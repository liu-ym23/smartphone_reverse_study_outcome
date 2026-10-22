package com.larus.platform.spi;

import android.view.View;
import androidx.collection.LruCache;
import androidx.fragment.app.Fragment;
import by7.e;
import com.larus.bmhome.chat.api.SelectionRangeType;
import com.larus.bmhome.chat.trace.m;
import com.larus.bmhome.chat.trace.p0;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SlashMentionConfig;
import com.tencent.open.log.TraceLevel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kr8.r;
import lw8.l;
import org.json.JSONObject;
import ow8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b*\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010A\u001a\u00020\u0006H\u0016J)\u0010B\u001a\u00020\u00062\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010E\u001a\u0004\u0018\u00010D2\u0006\u0010F\u001a\u00020=H\u0016¢\u0006\u0002\u0010GJ\u0010\u0010B\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u000bH\u0016J\u0010\u0010I\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u000bH\u0016J\u0010\u0010J\u001a\u00020\u00062\u0006\u0010K\u001a\u00020\u0006H\u0016J<\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u00062\u0006\u0010O\u001a\u0002032\b\u0010P\u001a\u0004\u0018\u00010\u00062\b\u0010Q\u001a\u0004\u0018\u00010\u00062\b\u0010R\u001a\u0004\u0018\u00010%H\u0096@¢\u0006\u0002\u0010SJ\u0010\u0010T\u001a\u00020M2\u0006\u0010N\u001a\u00020\u0006H\u0016J\u0018\u0010U\u001a\u00020M2\u0006\u0010V\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u0006H\u0016J\"\u0010W\u001a\u00020M2\u0006\u0010N\u001a\u00020\u00062\u0006\u0010O\u001a\u0002032\b\u0010P\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010X\u001a\u00020M2\b\u0010Y\u001a\u0004\u0018\u00010\u00062\b\u0010Z\u001a\u0004\u0018\u00010\u00062\u0006\u0010H\u001a\u00020\u000bH\u0016J\"\u0010[\u001a\u00020M2\u0006\u0010\\\u001a\u00020D2\b\u0010Z\u001a\u0004\u0018\u00010\u00062\u0006\u0010H\u001a\u00020\u000bH\u0016J5\u0010]\u001a\u00020M2\b\u0010Q\u001a\u0004\u0018\u00010\u00062\b\u0010Z\u001a\u0004\u0018\u00010\u00062\b\u0010^\u001a\u0004\u0018\u00010D2\b\u0010_\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010`J]\u0010a\u001a\u00020M2\b\u0010Q\u001a\u0004\u0018\u00010\u00062\b\u0010Z\u001a\u0004\u0018\u00010\u00062\b\u0010^\u001a\u0004\u0018\u00010D2\b\u0010_\u001a\u0004\u0018\u00010\u00062\b\u0010b\u001a\u0004\u0018\u00010\u00062\b\u0010c\u001a\u0004\u0018\u00010\u00062\b\u0010d\u001a\u0004\u0018\u00010\u00062\b\u0010e\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010fJX\u0010g\u001a\u00020M2\b\u0010h\u001a\u0004\u0018\u00010\u00062\b\u0010Q\u001a\u0004\u0018\u00010\u00062\b\u0010Z\u001a\u0004\u0018\u00010\u00062\b\u0010_\u001a\u0004\u0018\u00010\u00062\b\u0010i\u001a\u0004\u0018\u00010\u00062\b\u0010j\u001a\u0004\u0018\u00010\u00062\b\u0010d\u001a\u0004\u0018\u00010\u00062\b\u0010e\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010k\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u000bH\u0016J\u0018\u0010l\u001a\u00020M2\u0006\u0010m\u001a\u00020\u00062\u0006\u0010n\u001a\u00020\u0006H\u0016J3\u0010o\u001a\u00020M2\u0006\u0010p\u001a\u00020\u00062\b\u0010q\u001a\u0004\u0018\u00010D2\b\u0010r\u001a\u0004\u0018\u00010D2\b\u0010s\u001a\u0004\u0018\u00010DH\u0016¢\u0006\u0002\u0010tJ\b\u0010u\u001a\u00020MH\u0016J\u001e\u0010v\u001a\u00020M2\u0014\u0010w\u001a\u0010\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020=\u0018\u00010xH\u0016J\u0010\u0010o\u001a\u00020M2\u0006\u0010p\u001a\u00020\u0006H\u0016J\u0018\u0010y\u001a\u00020M2\u0006\u0010z\u001a\u00020\u00062\u0006\u0010{\u001a\u00020\u0006H\u0016J\u0010\u0010|\u001a\u00020\u00062\u0006\u0010{\u001a\u00020\u0006H\u0016J\"\u0010}\u001a\u00020M2\u0006\u0010O\u001a\u0002032\b\u0010p\u001a\u0004\u0018\u00010\u00062\u0006\u0010H\u001a\u00020\u000bH\u0016J6\u0010~\u001a\u00020M2\u0006\u0010\u007f\u001a\u00020\u00062\u0007\u0010\u0080\u0001\u001a\u00020=2\u0007\u0010\u0081\u0001\u001a\u00020\u000b2\u0007\u0010\u0082\u0001\u001a\u00020\u000b2\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0084\u0001\u001a\u0004\u0018\u00010\t2\u0006\u0010{\u001a\u00020\u00062\u0007\u0010\u0085\u0001\u001a\u00020=H\u0016J\u0012\u0010\u0086\u0001\u001a\u00020M2\u0007\u0010\u0087\u0001\u001a\u00020=H\u0016J\u001c\u0010\u0088\u0001\u001a\u00020M2\u0006\u0010\u007f\u001a\u00020\u00062\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u008a\u0001\u001a\u00020M2\u0006\u0010\u007f\u001a\u00020\u00062\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u008c\u0001\u001a\u00020M2\u0006\u0010\u007f\u001a\u00020\u00062\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u00012\u0006\u0010H\u001a\u00020\u000bH\u0016J/\u0010\u0090\u0001\u001a\u00020M2\u0006\u0010Z\u001a\u00020\u00062\b\u0010O\u001a\u0004\u0018\u0001032\n\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u00012\u0006\u0010H\u001a\u00020\u000bH\u0016J\u001b\u0010\u0093\u0001\u001a\u00020M2\u0006\u0010O\u001a\u0002032\b\u0010p\u001a\u0004\u0018\u00010\u0006H\u0016J%\u0010\u0094\u0001\u001a\u00020M2\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010=2\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010=H\u0016¢\u0006\u0003\u0010\u0097\u0001J\t\u0010\u0096\u0001\u001a\u00020=H\u0016J-\u0010\u0098\u0001\u001a\u00020M2\u0006\u0010Z\u001a\u00020\u00062\u0006\u0010O\u001a\u0002032\n\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u00012\u0006\u0010H\u001a\u00020\u000bH\u0016J-\u0010\u0099\u0001\u001a\u00020M2\u0006\u0010Z\u001a\u00020\u00062\u0006\u0010O\u001a\u0002032\n\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u00012\u0006\u0010H\u001a\u00020\u000bH\u0016J:\u0010\u009a\u0001\u001a\u00020M2\u0007\u0010\u009b\u0001\u001a\u00020=2\b\u0010Q\u001a\u0004\u0018\u00010\u00062\b\u0010_\u001a\u0004\u0018\u00010\u00062\b\u0010d\u001a\u0004\u0018\u00010\u00062\b\u0010e\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u009c\u0001\u001a\u00020M2\u0006\u0010H\u001a\u00020\u000b2\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\fH\u0016J\u0011\u0010\u009e\u0001\u001a\u00020M2\u0006\u0010H\u001a\u00020\u000bH\u0016J#\u0010\u009f\u0001\u001a\u00020M2\u0006\u0010O\u001a\u0002032\u0006\u0010H\u001a\u00020\u000b2\b\u0010n\u001a\u0004\u0018\u00010\u0006H\u0016JA\u0010 \u0001\u001a\u00020M2\u0007\u0010¡\u0001\u001a\u00020\u00062\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\f2\u0006\u0010H\u001a\u00020\u000b2\t\u0010¢\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010£\u0001\u001a\u0004\u0018\u00010=H\u0016¢\u0006\u0003\u0010¤\u0001J.\u0010¥\u0001\u001a\u00020M2\u0007\u0010¦\u0001\u001a\u00020\u00062\u0007\u0010§\u0001\u001a\u00020=2\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\f2\u0006\u0010Q\u001a\u00020\u0006H\u0016J\u0016\u0010¨\u0001\u001a\u00030©\u00012\n\u0010ª\u0001\u001a\u0005\u0018\u00010«\u0001H\u0016J \u0010¬\u0001\u001a\u00020=2\u0015\u0010\u00ad\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u000106H\u0016J\u0019\u0010®\u0001\u001a\u0004\u0018\u00010D2\u0006\u0010O\u001a\u000203H\u0016¢\u0006\u0003\u0010¯\u0001J\u0013\u0010°\u0001\u001a\u00020M2\b\u0010±\u0001\u001a\u00030²\u0001H\u0016J3\u0010³\u0001\u001a\u00020M2\t\u0010´\u0001\u001a\u0004\u0018\u00010\u00062\b\u0010Q\u001a\u0004\u0018\u00010\u00062\u0013\u0010µ\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000606H\u0016J\u001e\u0010¶\u0001\u001a\u00020M2\t\u0010·\u0001\u001a\u0004\u0018\u00010\u00062\b\u0010Q\u001a\u0004\u0018\u00010\u0006H\u0016J,\u0010¸\u0001\u001a\u0004\u0018\u00010%2\t\u0010¹\u0001\u001a\u0004\u0018\u00010\u00062\u0014\u0010º\u0001\u001a\u000f\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020=0»\u0001H\u0016J\t\u0010¼\u0001\u001a\u00020\u000bH\u0016J*\u0010½\u0001\u001a\u00020M2\u0006\u0010O\u001a\u0002032\u0006\u0010p\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u000b2\u0007\u0010¾\u0001\u001a\u00020=H\u0016J\u001e\u0010¿\u0001\u001a\u00020M2\b\u0010h\u001a\u0004\u0018\u00010\u00062\t\u0010À\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J\u0089\u0001\u0010Á\u0001\u001a\u00020M2\b\u0010\u007f\u001a\u0004\u0018\u00010\u00062\t\u0010Â\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010Ã\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010Ä\u0001\u001a\u0004\u0018\u00010D2\u0007\u0010Å\u0001\u001a\u00020=2\u0007\u0010Æ\u0001\u001a\u00020=2\u0007\u0010Ç\u0001\u001a\u00020=2\u0006\u0010H\u001a\u00020\u000b2\t\u0010È\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010É\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010Ê\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010Ë\u0001\u001a\u0004\u0018\u00010DH\u0016¢\u0006\u0003\u0010Ì\u0001J\u0017\u0010Í\u0001\u001a\u0005\u0018\u00010©\u00012\t\u0010Î\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J#\u0010Ï\u0001\u001a\u0005\u0018\u00010©\u00012\t\u0010Ð\u0001\u001a\u0004\u0018\u00010\u00062\n\u0010µ\u0001\u001a\u0005\u0018\u00010©\u0001H\u0016J#\u0010Ñ\u0001\u001a\u0005\u0018\u00010©\u00012\t\u0010Ò\u0001\u001a\u0004\u0018\u0001032\n\u0010µ\u0001\u001a\u0005\u0018\u00010©\u0001H\u0016J\u0016\u0010Ó\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010Ò\u0001\u001a\u0004\u0018\u000103H\u0016J\u0016\u0010Ô\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010Ò\u0001\u001a\u0004\u0018\u000103H\u0016J\u0016\u0010Õ\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010Ò\u0001\u001a\u0004\u0018\u000103H\u0016J\u0017\u0010Ö\u0001\u001a\u0004\u0018\u00010\u00062\n\u0010×\u0001\u001a\u0005\u0018\u00010©\u0001H\u0016J\u0017\u0010Ø\u0001\u001a\u0004\u0018\u00010\u00062\n\u0010×\u0001\u001a\u0005\u0018\u00010©\u0001H\u0016JP\u0010Ù\u0001\u001a\u00020M2\b\u0010R\u001a\u0004\u0018\u00010%2\u0006\u0010N\u001a\u00020\u00062\u0006\u0010O\u001a\u0002032\b\u0010P\u001a\u0004\u0018\u00010\u00062\u0006\u0010Q\u001a\u00020\u00062\t\u0010Ú\u0001\u001a\u0004\u0018\u00010D2\u0007\u0010Û\u0001\u001a\u00020\u000bH\u0096@¢\u0006\u0003\u0010Ü\u0001J\u0015\u0010Ý\u0001\u001a\u00020\u00062\n\u0010±\u0001\u001a\u0005\u0018\u00010Þ\u0001H\u0016J\u0011\u0010ß\u0001\u001a\u00020M2\u0006\u0010N\u001a\u00020\u0006H\u0016JW\u0010à\u0001\u001a\u00020M2\u000f\u0010á\u0001\u001a\n\u0012\u0005\u0012\u00030ã\u00010â\u00012\u0007\u0010Ò\u0001\u001a\u0002032\n\u0010ä\u0001\u001a\u0005\u0018\u00010å\u00012\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\f2\b\u0010_\u001a\u0004\u0018\u00010\u00062\u0007\u0010æ\u0001\u001a\u00020\u00062\b\u0010ç\u0001\u001a\u00030©\u0001H\u0016J#\u0010è\u0001\u001a\u00020M2\u0007\u0010Ò\u0001\u001a\u0002032\u0006\u0010H\u001a\u00020\u000b2\u0007\u0010é\u0001\u001a\u00020\u0006H\u0016J>\u0010ê\u0001\u001a\u00020M2\u0007\u0010Ò\u0001\u001a\u0002032\u0006\u0010H\u001a\u00020\u000b2\u0007\u0010é\u0001\u001a\u00020\u00062\b\u0010j\u001a\u0004\u0018\u00010\u00062\t\u0010ë\u0001\u001a\u0004\u0018\u00010DH\u0016¢\u0006\u0003\u0010ì\u0001J\u0084\u0001\u0010í\u0001\u001a\u00020M2\u0006\u0010Z\u001a\u00020\u00062\u0006\u0010O\u001a\u0002032\t\u0010î\u0001\u001a\u0004\u0018\u00010\f2\u0006\u0010H\u001a\u00020\u000b2\u0011\u0010ï\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010ð\u00010â\u00012\n\u0010±\u0001\u001a\u0005\u0018\u00010Þ\u00012\t\u0010ñ\u0001\u001a\u0004\u0018\u00010\u00062\n\u0010ò\u0001\u001a\u0005\u0018\u00010ó\u00012\t\u0010Ä\u0001\u001a\u0004\u0018\u00010\u00062\u0015\u0010ç\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020D\u0018\u000106H\u0016J\u0013\u0010ô\u0001\u001a\u0004\u0018\u00010\f2\u0006\u0010H\u001a\u00020\u000bH\u0016J\u0080\u0001\u0010õ\u0001\u001a\u00020M2\u0007\u0010ö\u0001\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u000b2\t\u0010÷\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010ø\u0001\u001a\u0004\u0018\u00010D2\t\u0010ñ\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010ù\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010ú\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010¢\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\f2\t\u0010û\u0001\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0003\u0010ü\u0001J*\u0010ý\u0001\u001a\u00020M2\u0006\u0010Z\u001a\u00020\u00062\u0006\u0010{\u001a\u00020\u00062\u0007\u0010ö\u0001\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u000bH\u0016J0\u0010þ\u0001\u001a\u00020M2\u0007\u0010ö\u0001\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u000b2\t\u0010¢\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010û\u0001\u001a\u0004\u0018\u00010\u0006H\u0016Jc\u0010ÿ\u0001\u001a\u00020M2\u0007\u0010û\u0001\u001a\u00020\u00062\u0007\u0010\u0080\u0002\u001a\u00020\u00062\u0007\u0010ö\u0001\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u000b2\t\u0010ñ\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010ù\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010ú\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010¢\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\fH\u0016J'\u0010\u0081\u0002\u001a\u00020M2\u0007\u0010\u0082\u0002\u001a\u0002032\b\u0010Q\u001a\u0004\u0018\u00010\u00062\t\u0010\u0083\u0002\u001a\u0004\u0018\u00010\u0006H\u0016J:\u0010\u0084\u0002\u001a\u00020M2\u0007\u0010\u0085\u0002\u001a\u00020\u00062\u0007\u0010\u0082\u0002\u001a\u0002032\b\u0010Q\u001a\u0004\u0018\u00010\u00062\t\u0010\u0083\u0002\u001a\u0004\u0018\u00010\u00062\b\u0010Z\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0086\u0002\u001a\u00020M2\u0007\u0010\u0087\u0002\u001a\u00020\u00062\b\u0010\u0088\u0002\u001a\u00030\u0089\u0002H\u0016J$\u0010\u008a\u0002\u001a\u00030©\u00012\u0006\u0010h\u001a\u00020\u00062\t\u0010\u008b\u0002\u001a\u0004\u0018\u000103H\u0096@¢\u0006\u0003\u0010\u008c\u0002J)\u0010\u008d\u0002\u001a\u00020M2\b\u0010Q\u001a\u0004\u0018\u00010\u00062\t\u0010\u008e\u0002\u001a\u0004\u0018\u00010\u00062\t\u0010\u008f\u0002\u001a\u0004\u0018\u00010\u0006H\u0016JÑ\u0002\u0010\u0090\u0002\u001a\u00020M2\b\u0010Q\u001a\u0004\u0018\u00010\u00062\u0007\u0010¢\u0001\u001a\u00020\u00062\u0007\u0010\u0091\u0002\u001a\u00020=2\t\u0010\u0092\u0002\u001a\u0004\u0018\u00010\u00062\u0007\u0010\u0093\u0002\u001a\u00020=2\u0007\u0010\u0094\u0002\u001a\u00020=2\u0007\u0010\u0095\u0002\u001a\u00020=2\u0007\u0010\u008f\u0002\u001a\u00020=2\t\u0010\u008e\u0002\u001a\u0004\u0018\u00010\u00062\t\u0010\u0096\u0002\u001a\u0004\u0018\u00010\u00062\b\u0010Z\u001a\u0004\u0018\u00010\u00062\t\u0010\u0097\u0002\u001a\u0004\u0018\u00010\u00062\t\u0010\u0098\u0002\u001a\u0004\u0018\u00010\u00062\b\u0010j\u001a\u0004\u0018\u00010\u00062\b\u0010i\u001a\u0004\u0018\u00010\u00062\t\u0010\u0099\u0002\u001a\u0004\u0018\u00010\u00062\t\u0010\u009a\u0002\u001a\u0004\u0018\u00010\u00062\t\u0010\u009b\u0002\u001a\u0004\u0018\u00010=2\t\u0010\u009c\u0002\u001a\u0004\u0018\u00010=2\b\u0010d\u001a\u0004\u0018\u00010\u00062\b\u0010e\u001a\u0004\u0018\u00010\u00062\t\u0010\u009d\u0002\u001a\u0004\u0018\u00010\u00062\t\u0010\u009e\u0002\u001a\u0004\u0018\u00010\u00062\b\u0010{\u001a\u0004\u0018\u00010\u00062\t\u0010\u009f\u0002\u001a\u0004\u0018\u00010\u00062\t\u0010 \u0002\u001a\u0004\u0018\u00010\u00062\t\u0010¡\u0002\u001a\u0004\u0018\u00010\u00062\t\u0010Û\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010¢\u0002\u001a\u0004\u0018\u00010\u00062\t\u0010£\u0002\u001a\u0004\u0018\u00010\u00062\t\u0010¤\u0002\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0003\u0010¥\u0002Jy\u0010¦\u0002\u001a\u00020M2\b\u0010Q\u001a\u0004\u0018\u00010\u00062\u0007\u0010\u0093\u0002\u001a\u00020=2\u0007\u0010\u0091\u0002\u001a\u00020=2\t\u0010\u0096\u0002\u001a\u0004\u0018\u00010\u00062\t\u0010§\u0002\u001a\u0004\u0018\u00010\u00062\t\u0010¨\u0002\u001a\u0004\u0018\u00010\u00062\u0007\u0010©\u0002\u001a\u00020\u000b2\t\u0010ª\u0002\u001a\u0004\u0018\u00010\u00062\u0007\u0010«\u0002\u001a\u00020\u000b2\t\u0010¬\u0002\u001a\u0004\u0018\u00010\u00062\t\u0010\u00ad\u0002\u001a\u0004\u0018\u00010\u0006H\u0016Jd\u0010®\u0002\u001a\u00020M2\b\u0010Q\u001a\u0004\u0018\u00010\u00062\t\u0010¯\u0002\u001a\u0004\u0018\u00010D2\t\u0010°\u0002\u001a\u0004\u0018\u00010D2\t\u0010\u0091\u0002\u001a\u0004\u0018\u00010D2\b\u0010_\u001a\u0004\u0018\u00010\u00062\b\u0010h\u001a\u0004\u0018\u00010\u00062\t\u0010±\u0002\u001a\u0004\u0018\u00010\u00062\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0003\u0010²\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR \u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020%0\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0014R\u0016\u0010'\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019R\u0016\u0010)\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0019R\u0016\u0010+\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0019R\u001c\u0010-\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0019\"\u0004\b/\u0010\u001bR \u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0014R \u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002030\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0014R.\u00105\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006060\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0014R \u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0014R\u0016\u0010:\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0019R\u001a\u0010<\u001a\u00020=X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010>\"\u0004\b?\u0010@¨\u0006³\u0002"}, d2 = {"Lcom/larus/platform/spi/AIChatControlTraceServiceNoop;", "Lcom/larus/platform/spi/IAIChatControlTraceService;", "<init>", "()V", "sceneMap", "", "", "originalContentSourceMap", "speakInfoMap", "Lcom/larus/bmhome/chat/trace/SpeakInfo;", "trackNodeMap", "", "Lcom/ixigua/lib/track/ITrackNode;", "traceInfo", "Lcom/larus/bmhome/chat/trace/ChatControlTraceInfo;", "getTraceInfo", "()Lcom/larus/bmhome/chat/trace/ChatControlTraceInfo;", "enterMethodCacheForCvsId", "Landroidx/collection/LruCache;", "getEnterMethodCacheForCvsId", "()Landroidx/collection/LruCache;", "deepThinkMessageFoldStatus", "getDeepThinkMessageFoldStatus", "lyricCreateType", "getLyricCreateType", "()Ljava/lang/String;", "setLyricCreateType", "(Ljava/lang/String;)V", "topResumedChatKey", "getTopResumedChatKey", "()J", "setTopResumedChatKey", "(J)V", "musicCreateModel", "getMusicCreateModel", "setMusicCreateModel", "cvsCache", "Lcom/larus/im/bean/conversation/Conversation;", "getCvsCache", "caseId", "getCaseId", "caseRequestId", "getCaseRequestId", "caseRecommendFrom", "getCaseRecommendFrom", "modifyMessageId", "getModifyMessageId", "setModifyMessageId", "imageFromCache", "getImageFromCache", "sendingMessageCache", "Lcom/larus/im/bean/message/Message;", "getSendingMessageCache", "sendMessageTrackExtMapForMsgId", "", "getSendMessageTrackExtMapForMsgId", "enterMethodCacheForMsgId", "getEnterMethodCacheForMsgId", "sendMsgSceneSecond", "getSendMsgSceneSecond", "isUseReceiveServiceScene", "", "()Z", "setUseReceiveServiceScene", "(Z)V", "sceneOther", "getChatType", "botConversationType", "", "botSourceType", "isOwnBot", "(Ljava/lang/Integer;Ljava/lang/Integer;Z)Ljava/lang/String;", "chatKey", "getBotId", "getScene", "localMsgId", "onAnswerResult", "", "token", "msg", "errResult", "botId", SlashMentionConfig.MENTION_CONTENT_CONVERSATION, "(Ljava/lang/String;Lcom/larus/im/bean/message/Message;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/conversation/Conversation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onWaitAnswer", "onWaitPrompt", "replyToken", "onPromptResult", "onDiyActionClick", "buttonType", "clickFrom", "onAsrFeedbackClick", "feedbackType", "clickBottomMenuCamera", "isOCR", "chatType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "clickBottomMenuUploadImgEntrance", "templateId", "templateName", "referenceFromType", "referenceMessageId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "clickBottomMenuUploadFileEntrance", "conversationId", "previousPage", "actionBarTemplateName", "getPreviousPage", "setScene", "taskId", "scene", "onMessageEditing", "type", "fileCount", "imageCount", "audioCount", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "onInputSend", "cacheMemorizedOptions", "memorizedOptions", "Lkotlin/Pair;", "setOriginalContentSource", "originalSource", "messageId", "getOriginalContentSource", "onInputModifySend", "setSpeakInfo", "msgId", "isSpeakHandsFree", "speakDuration", "handsfreeSpeakDuration", "handsfreeEnterMethod", "getSpeakInfo", "remove", "setIsUnlimitedFlowFullScreen", "isUnlimitedFlowFullScreen", "setItemIdMap", "itemId", "setItemTypeMap", "itemType", "setRecoRequestIdMap", "recoRequestId", "getChatBaseMessage", "Lcom/larus/bmhome/chat/trace/ChatBaseData;", "onClickSearch", "fragment", "Landroidx/fragment/app/Fragment;", "onInputModifyCancel", "setIsShowFullInputBox", "isShowFullInputBox", "isUseFullInputBox", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "onClickDislike", "onClickLike", "clickBottomMenuEntrance", "showMenu", "registerTrackNode", "trackNode", "unregisterTrackNode", "onCompleteDislikeReason", "onInputFunctionSwitch", "toStatus", "currentPage", "isKeyboardPop", "(Ljava/lang/String;Lcom/ixigua/lib/track/ITrackNode;JLjava/lang/String;Ljava/lang/Boolean;)V", "onRealtimeEntranceShow", "position", "hasRedDot", "getRecommendBotBaseJson", "Lorg/json/JSONObject;", "recommendFrom", "Lcom/larus/platform/model/RecommendFrom;", "hasReferenceImage", "msgExt", "paresImageEditType", "(Lcom/larus/im/bean/message/Message;)Ljava/lang/Integer;", "markThinkingArea", "markdownView", "Lcom/larus/business/markdown/api/view/text/IMarkdownTextView;", "onClickFullInputBoxButton", "action", "params", "onShowFullInputBoxButton", "inputType", "tryGetCacheConv", "convId", "filter", "Lkotlin/Function1;", "getImplTopResumedChatKey", "onModify", "isLatestUserMsg", "setPicSourceEntrance", "entrance", "onDevShowOnBoardingCard", "senderId", "onBoardingType", "contentType", "isEmpty", "isFromPush", "isHighlight", "timeAfterPrevMessage", "timeAfterEnterForeground", "timeAfterCreate", "nextPulseType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZZZJLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;)V", "getReferenceExtJson", "ext", "getTraceInfoWithFpaPrefix", "uriStr", "getTraceInfoWithFpaPrefixFromMsg", "message", "getLinkType", "getAgentId", "getAgentTool", "getBcmId", "jsonObject", "getEntityId", "onStreamResult", "botType", "duration", "(Lcom/larus/im/bean/conversation/Conversation;Ljava/lang/String;Lcom/larus/im/bean/message/Message;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getClickModule", "Landroid/view/View;", "onStreamStart", "trackLongPressMenuItemsShow", "menuItems", "", "Lcom/larus/bmhome/view/screenmenu/abs/IMenuItem;", "bot", "Lcom/larus/im/bean/bot/BotModel;", "triggerFrom", "extParams", "showRegenInstruction", "regenInstruction", "clickRegenInstruction", "actionBarTemplateType", "(Lcom/larus/im/bean/message/Message;JLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "onCopy", "traceNode", "markdownContentList", "Lcom/larus/business/markdown/api/model/MarkdownContent;", "clickModule", "selectRange", "Lcom/larus/bmhome/chat/api/SelectionRangeType;", "getTrackNode", "exportPanelElementClick", "exportActionId", "fileType", "exportMsgCnt", "messageIdList", "mobDeepResearchId", "showFrom", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ixigua/lib/track/ITrackNode;Ljava/lang/String;)V", "exportFiles", "exportPanelShow", "exportPanelElementShow", "filType", "sendPromptSurveyShow", "data", "messageIdString", "sendPromptSurveyClick", "result", "addAdditionalTraceListener", "key", "listener", "Lcom/larus/bmhome/chat/trace/IMessageTraceListener;", "getChatLastLogParams", "lastShownMsg", "(Ljava/lang/String;Lcom/larus/im/bean/message/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clickAttachmentDelete", "uri", "success", "uploadAttachmentStatus", "isMultiFile", "errorMessage", "isImg", "isAudio", "isVideo", "fileName", "enterMethod", "isMultiChooseMode", "contentSource", "ifEduIntention", "isImageMarked", "isImageCropped", "uploadFrom", "uploadWay", "clarifyId", "messageTypeOverride", "messageTypeDetailOverride", "uploadFileSize", "displayType", "agentType", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "uploadAttachmentSingleCost", "conversationID", "localMsgID", "cost", "md5", "fileSize", "fileExt", "uploadStatus", "onPasteImgContent", "fileCnt", "picCnt", "messageType", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ixigua/lib/track/ITrackNode;)V", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class AIChatControlTraceServiceNoop implements IAIChatControlTraceService {
    public final Map<String, String> b;
    public final Map<String, String> c;
    public final Map<String, p0> d;
    public final Map<Long, e> e;
    public final m f;
    public final LruCache<String, String> g;
    public final LruCache<String, String> h;
    public String i;
    public final LruCache<String, wc9.e> j;
    public final LruCache<String, String> k;
    public final LruCache<String, Message> l;
    public final LruCache<String, Map<String, String>> m;
    public final LruCache<String, String> n;

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void Ba(Message r1, long r2, String r4, String r5, Integer r6) {
        Intrinsics.checkNotNullParameter(r1, "message");
        Intrinsics.checkNotNullParameter(r4, "regenInstruction");
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void Bb(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8) {
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void Ca(Boolean r1, Boolean r2) {
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void Cb() {
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void Da(String r1, String r2, long r3, String r5, Integer r6, String r7, String r8, String r9, String r10, e r11, String r12) {
        Intrinsics.checkNotNullParameter(r1, "exportActionId");
        Intrinsics.checkNotNullParameter(r2, "clickFrom");
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final String Db() {
        return null;
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void Ea(String r1, String r2, String r3, long r4, String r6, String r7, String r8, String r9, e r10) {
        Intrinsics.checkNotNullParameter(r1, "showFrom");
        Intrinsics.checkNotNullParameter(r2, "filType");
        Intrinsics.checkNotNullParameter(r3, "exportActionId");
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void Eb(String r1, Message r2, e r3, long r4, List<? extends l> r6, View r7, String r8, SelectionRangeType r9, String r10, Map<String, Integer> r11) {
        Intrinsics.checkNotNullParameter(r1, "clickFrom");
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r6, "markdownContentList");
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void Fa(Message r1, String r2, long r3) {
        Intrinsics.checkNotNullParameter(r1, "msg");
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void Fb(String r1, String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void Ga(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "msgId");
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void Ha(String r1, Message r2, Fragment r3, long r4) {
        Intrinsics.checkNotNullParameter("answer", "clickFrom");
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final String Hb() {
        return null;
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void Ib(Message r1, long r2, String r4) {
        Intrinsics.checkNotNullParameter(r1, "message");
        Intrinsics.checkNotNullParameter(r4, "regenInstruction");
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void Ja(String r1) {
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void Jb(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "replyToken");
        Intrinsics.checkNotNullParameter(r3, "token");
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final String Kb(Message r1) {
        return null;
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void La(String r1, String r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r1, "clickFrom");
        Intrinsics.checkNotNullParameter(r2, "messageId");
        Intrinsics.checkNotNullParameter(r3, "exportActionId");
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void Lb(String r1, String r2, String r3, Integer r4, boolean r5, boolean r6, boolean r7, long r8, Long r10, Long r11, Long r12, Integer r13) {
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final boolean Mb() {
        return false;
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final long Na() {
        return 0;
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void Oa(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "msgId");
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void Pa(Pair<Boolean, Boolean> r1) {
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void Pb(Message r1, String r2, long r3, boolean r5) {
        Intrinsics.checkNotNullParameter(r1, "msg");
        Intrinsics.checkNotNullParameter(r2, "type");
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void Qa(String r1, Message r2, Fragment r3, long r4) {
        Intrinsics.checkNotNullParameter("answer", "clickFrom");
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void Ra(String r1, boolean r2, e r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "position");
        Intrinsics.checkNotNullParameter(r4, "botId");
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final String Rb() {
        return null;
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void Sb() {
        Intrinsics.checkNotNullParameter("text", "type");
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final JSONObject Ta(String r1) {
        return null;
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void Tb(String r3, String r4, boolean r5, String r6, boolean r7, boolean r8, boolean r9, boolean r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, Boolean r20, Boolean r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, Long r30, String r31, String r32, String r33) {
        Intrinsics.checkNotNullParameter(r4, "currentPage");
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void Ub(String r1, Integer r2, Integer r3, Integer r4, String r5, String r6, e r7) {
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void Va(int r1, long r2) {
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void Wa(String r1, String r2, long r3) {
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final Integer Wb(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        return null;
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void Xa(String r1, long r2, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r1, "exportActionId");
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final String Ya(JSONObject r1) {
        return null;
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void Yb(r r3) {
        Intrinsics.checkNotNullParameter("MusicCreateMob", "key");
        Intrinsics.checkNotNullParameter(r3, "listener");
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final String Za(Message r1) {
        return null;
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void Zb(String r1, e r2, long r3, String r5, Boolean r6) {
        Intrinsics.checkNotNullParameter(r1, "toStatus");
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void ab(String r2) {
        Intrinsics.checkNotNullParameter(r2, "token");
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final String bb(long r1) {
        return "";
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void bc(boolean r1) {
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void cb(String r2) {
        Intrinsics.checkNotNullParameter(r2, "token");
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void cc(a r2) {
        Intrinsics.checkNotNullParameter(r2, "markdownView");
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void db(String r1, Message r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "token");
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void ec(String r1, String r2, Integer r3, String r4, String r5, String r6, String r7, String r8) {
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void fb() {
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void fc(String r1, Integer r2, Integer r3, Integer r4) {
        Intrinsics.checkNotNullParameter("audio", "type");
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final String g(Integer r1, Integer r2, boolean r3) {
        return "";
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final long gb() {
        return 0;
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final com.larus.bmhome.chat.trace.a gc(long r1) {
        return null;
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final String getBotId(long r1) {
        return "";
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final String h(long r1) {
        return "";
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void hb(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void hc(String r1, Message r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r1, "result");
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final boolean ib(Map<String, String> r1) {
        return false;
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void ic(String r1, boolean r2, String r3, String r4, String r5, long r6, String r8, long r9, String r11, String r12) {
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final String jb(View r1) {
        return "";
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void jc(List<? extends ot8.a> r1, Message r2, BotModel r3, e r4, String r5, String r6, JSONObject r7) {
        Intrinsics.checkNotNullParameter(r1, "menuItems");
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r6, "triggerFrom");
        Intrinsics.checkNotNullParameter(r7, "extParams");
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void lb(Message r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "msg");
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final String pb(JSONObject r1) {
        return null;
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void qb(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "msgId");
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void rb(String r1, String r2) {
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void sb(String r1, String r2) {
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final String tb(Message r1) {
        return null;
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final String vb() {
        return "other";
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void yb(Message r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "data");
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void zb(boolean r1, String r2, String r3, String r4, String r5) {
    }

    public AIChatControlTraceServiceNoop() {
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
        this.f = new m(0);
        this.g = new LruCache(20);
        this.h = new LruCache(20);
        this.i = "";
        this.j = new LruCache(20);
        this.k = new LruCache(20);
        this.l = new LruCache(20);
        this.m = new LruCache(20);
        this.n = new LruCache(20);
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final LruCache<String, String> Nb() {
        return this.h;
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final LruCache<String, wc9.e> ac() {
        return this.j;
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final LruCache<String, Map<String, String>> dc() {
        return this.m;
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final LruCache<String, String> eb() {
        return this.k;
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final m getTraceInfo() {
        return this.f;
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final LruCache<String, String> kb() {
        return this.n;
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final LruCache<String, Message> mb() {
        return this.l;
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final String nb() {
        return this.i;
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final LruCache<String, String> xb() {
        return this.g;
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final String Ia(String r2) {
        Intrinsics.checkNotNullParameter(r2, "localMsgId");
        String r3 = (String) ((LinkedHashMap) this.b).get(r2);
        if (r3 != null) goto L6;
        return "other";
    L6:
        return r3;
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void Ka(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final String Sa(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        String r3 = (String) ((LinkedHashMap) this.c).get(r2);
        if (r3 != null) goto L6;
        return "";
    L6:
        return r3;
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final JSONObject Xb(RecommendFrom r1) {
        return new JSONObject();
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final e ob(long r2) {
        Map<Long, e> r0 = this.e;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        return (e) r1.get(Long.valueOf(r2));
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void wb(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.i = r2;
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void Ab(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "originalSource");
        Intrinsics.checkNotNullParameter(r3, "messageId");
        this.c.put(r3, r2);
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final JSONObject Gb(String r1, JSONObject r2) {
        if (r2 == null) goto L4;
        return r2;
    L4:
        return new JSONObject();
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void Ma(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "scene");
        this.b.put(r2, r3);
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final wc9.e Qb(String r2, Function1<? super wc9.e, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r3, "filter");
        if (r2 == null) goto L9;
        wc9.e r4 = (wc9.e) this.j.get(r2);
        if (r4 == null) goto L9;
        if (((Boolean) r3.invoke(r4)).booleanValue() == false) goto L9;
        return r4;
    L9:
        return null;
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final JSONObject Ua(Message r1, JSONObject r2) {
        if (r2 == null) goto L4;
        return r2;
    L4:
        return new JSONObject();
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final Object Ob(String r1, Message r2, Continuation<? super JSONObject> r3) {
        return new JSONObject();
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final void ub(String r12, boolean r13, long r14, long r16, String r18) {
        Intrinsics.checkNotNullParameter(r12, "msgId");
        this.d.put(r12, new p0(r13, r14, r16, r18));
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final Object Vb(String r1, Message r2, String r3, String r4, wc9.e r5, Continuation<? super Unit> r6) {
        return Unit.INSTANCE;
    }

    @Override // com.larus.platform.spi.IAIChatControlTraceService
    public final Object Aa(wc9.e r1, String r2, Message r3, String r4, String r5, Integer r6, long r7, Continuation<? super Unit> r9) {
        return Unit.INSTANCE;
    }
}
