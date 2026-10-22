package com.larus.bmhome;

import android.os.SystemClock;
import android.view.View;
import androidx.collection.LruCache;
import androidx.fragment.app.Fragment;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.api.SelectionRangeType;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.markdown.memory.MemoryActionTag;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kr8.r;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bJ\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b.\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J)\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J<\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\u0018\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\"\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010 \u001a\u00020\u00132\b\u0010!\u001a\u0004\u0018\u00010\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J\"\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J5\u0010%\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u00052\b\u0010&\u001a\u0004\u0018\u00010\b2\b\u0010'\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010(J]\u0010)\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u00052\b\u0010&\u001a\u0004\u0018\u00010\b2\b\u0010'\u001a\u0004\u0018\u00010\u00052\b\u0010*\u001a\u0004\u0018\u00010\u00052\b\u0010+\u001a\u0004\u0018\u00010\u00052\b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010-\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010.JX\u0010/\u001a\u00020\u00132\b\u00100\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00052\b\u00101\u001a\u0004\u0018\u00010\u00052\b\u00102\u001a\u0004\u0018\u00010\u00052\b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010-\u001a\u0004\u0018\u00010\u0005H\u0016J3\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u00020\u00052\b\u00105\u001a\u0004\u0018\u00010\b2\b\u00106\u001a\u0004\u0018\u00010\b2\b\u00107\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u00108J\u0018\u00109\u001a\u00020\u00132\u0006\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u0005H\u0016J\b\u0010<\u001a\u00020\u0013H\u0016J\u001e\u0010=\u001a\u00020\u00132\u0014\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010?H\u0016J\u0010\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u00020\u0005H\u0016J\u0018\u0010@\u001a\u00020\u00132\u0006\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0005H\u0016J\u0010\u0010C\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0005H\u0016J\"\u0010D\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\b\u00104\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J2\u0010E\u001a\u00020\u00132\u0006\u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020\u000e2\b\u0010J\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010B\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u000bH\u0016J\u0010\u0010N\u001a\u00020\u00132\u0006\u0010O\u001a\u00020\u000bH\u0016J\u001a\u0010P\u001a\u00020\u00132\u0006\u0010F\u001a\u00020\u00052\b\u0010Q\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010R\u001a\u00020\u00132\u0006\u0010F\u001a\u00020\u00052\b\u0010S\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010T\u001a\u00020\u00132\u0006\u0010F\u001a\u00020\u00052\b\u0010U\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010V\u001a\u0004\u0018\u00010W2\u0006\u0010\r\u001a\u00020\u000eH\u0016J,\u0010X\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010Y\u001a\u0004\u0018\u00010Z2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010[\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\b\u00104\u001a\u0004\u0018\u00010\u0005H\u0016J!\u0010\\\u001a\u00020\u00132\b\u0010]\u001a\u0004\u0018\u00010\u000b2\b\u0010^\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010_J\b\u0010^\u001a\u00020\u000bH\u0016J*\u0010`\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010Y\u001a\u0004\u0018\u00010Z2\u0006\u0010\r\u001a\u00020\u000eH\u0016J*\u0010a\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010Y\u001a\u0004\u0018\u00010Z2\u0006\u0010\r\u001a\u00020\u000eH\u0016J8\u0010b\u001a\u00020\u00132\u0006\u0010c\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00052\b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010-\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010d\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\b\u0010e\u001a\u0004\u0018\u00010fH\u0016J\u0010\u0010g\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0016J\"\u0010h\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000e2\b\u0010;\u001a\u0004\u0018\u00010\u0005H\u0016J;\u0010i\u001a\u00020\u00132\u0006\u0010j\u001a\u00020\u00052\b\u0010e\u001a\u0004\u0018\u00010f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010k\u001a\u0004\u0018\u00010\u00052\b\u0010l\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010mJ*\u0010n\u001a\u00020\u00132\u0006\u0010o\u001a\u00020\u00052\u0006\u0010p\u001a\u00020\u000b2\b\u0010e\u001a\u0004\u0018\u00010f2\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\u0012\u0010q\u001a\u00020r2\b\u0010s\u001a\u0004\u0018\u00010tH\u0016J\u001e\u0010u\u001a\u00020\u000b2\u0014\u0010v\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010wH\u0016J\u0017\u0010x\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0002\u0010yJ(\u0010z\u001a\u0004\u0018\u00010\u001a2\b\u0010{\u001a\u0004\u0018\u00010\u00052\u0012\u0010|\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000b0}H\u0016J\u0011\u0010~\u001a\u00020\u00132\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0016J3\u0010\u0081\u0001\u001a\u00020\u00132\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0013\u0010\u0083\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050wH\u0016J\u001e\u0010\u0084\u0001\u001a\u00020\u00132\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0016J\t\u0010¯\u0001\u001a\u00020\u000eH\u0016J*\u0010°\u0001\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u00104\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0007\u0010±\u0001\u001a\u00020\u000bH\u0016J\u0011\u0010¶\u0001\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0016\u0010·\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u0016H\u0016J\u001e\u0010¹\u0001\u001a\u00020\u00132\b\u00100\u001a\u0004\u0018\u00010\u00052\t\u0010º\u0001\u001a\u0004\u0018\u00010\u0005H\u0016J\u0089\u0001\u0010»\u0001\u001a\u00020\u00132\b\u0010F\u001a\u0004\u0018\u00010\u00052\t\u0010¼\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010½\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010¾\u0001\u001a\u0004\u0018\u00010\b2\u0007\u0010¿\u0001\u001a\u00020\u000b2\u0007\u0010À\u0001\u001a\u00020\u000b2\u0007\u0010Á\u0001\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\t\u0010Â\u0001\u001a\u0004\u0018\u00010\u000e2\t\u0010Ã\u0001\u001a\u0004\u0018\u00010\u000e2\t\u0010Ä\u0001\u001a\u0004\u0018\u00010\u000e2\t\u0010Å\u0001\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0003\u0010Æ\u0001J\u0016\u0010Ç\u0001\u001a\u0004\u0018\u00010r2\t\u0010È\u0001\u001a\u0004\u0018\u00010\u0005H\u0016J!\u0010É\u0001\u001a\u0004\u0018\u00010r2\t\u0010Ê\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010rH\u0016J!\u0010Ë\u0001\u001a\u0004\u0018\u00010r2\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u00162\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010rH\u0016J\u0016\u0010Ì\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u0016H\u0016J\u0016\u0010Í\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u0016H\u0016J\u0016\u0010Î\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010Ï\u0001\u001a\u0004\u0018\u00010rH\u0016J\u0016\u0010Ð\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010Ï\u0001\u001a\u0004\u0018\u00010rH\u0016JP\u0010Ñ\u0001\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u00052\t\u0010Ò\u0001\u001a\u0004\u0018\u00010\b2\u0007\u0010Ó\u0001\u001a\u00020\u000eH\u0096@¢\u0006\u0003\u0010Ô\u0001J\u0014\u0010Õ\u0001\u001a\u00020\u00052\t\u0010\u007f\u001a\u0005\u0018\u00010Ö\u0001H\u0016J\u0011\u0010×\u0001\u001a\u00020\u00132\u0006\u0010B\u001a\u00020\u0005H\u0016J\u0011\u0010Ø\u0001\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0016JU\u0010Ù\u0001\u001a\u00020\u00132\u000f\u0010Ú\u0001\u001a\n\u0012\u0005\u0012\u00030Ü\u00010Û\u00012\u0007\u0010¸\u0001\u001a\u00020\u00162\n\u0010Ý\u0001\u001a\u0005\u0018\u00010Þ\u00012\b\u0010e\u001a\u0004\u0018\u00010f2\b\u0010'\u001a\u0004\u0018\u00010\u00052\u0007\u0010ß\u0001\u001a\u00020\u00052\u0007\u0010à\u0001\u001a\u00020rH\u0016J#\u0010á\u0001\u001a\u00020\u00132\u0007\u0010¸\u0001\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000e2\u0007\u0010â\u0001\u001a\u00020\u0005H\u0016J>\u0010ã\u0001\u001a\u00020\u00132\u0007\u0010¸\u0001\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000e2\u0007\u0010â\u0001\u001a\u00020\u00052\b\u00102\u001a\u0004\u0018\u00010\u00052\t\u0010ä\u0001\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0003\u0010å\u0001J\u0083\u0001\u0010æ\u0001\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\t\u0010ç\u0001\u001a\u0004\u0018\u00010f2\u0006\u0010\r\u001a\u00020\u000e2\u0011\u0010è\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010é\u00010Û\u00012\t\u0010\u007f\u001a\u0005\u0018\u00010Ö\u00012\t\u0010ê\u0001\u001a\u0004\u0018\u00010\u00052\n\u0010ë\u0001\u001a\u0005\u0018\u00010ì\u00012\t\u0010¾\u0001\u001a\u0004\u0018\u00010\u00052\u0015\u0010í\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010wH\u0016J\u0013\u0010î\u0001\u001a\u0004\u0018\u00010f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J~\u0010ï\u0001\u001a\u00020\u00132\u0007\u0010ð\u0001\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\t\u0010ñ\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010ò\u0001\u001a\u0004\u0018\u00010\b2\t\u0010ê\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010ó\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010ô\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010k\u001a\u0004\u0018\u00010\u00052\b\u0010e\u001a\u0004\u0018\u00010f2\t\u0010õ\u0001\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0003\u0010ö\u0001J*\u0010÷\u0001\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u00052\u0007\u0010ð\u0001\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J/\u0010ø\u0001\u001a\u00020\u00132\u0007\u0010ð\u0001\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\b\u0010k\u001a\u0004\u0018\u00010\u00052\t\u0010õ\u0001\u001a\u0004\u0018\u00010\u0005H\u0016Ja\u0010ù\u0001\u001a\u00020\u00132\u0007\u0010õ\u0001\u001a\u00020\u00052\u0007\u0010ñ\u0001\u001a\u00020\u00052\u0007\u0010ð\u0001\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\t\u0010ê\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010ó\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010ô\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010k\u001a\u0004\u0018\u00010\u00052\b\u0010e\u001a\u0004\u0018\u00010fH\u0016J'\u0010ú\u0001\u001a\u00020\u00132\u0007\u0010û\u0001\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\t\u0010ü\u0001\u001a\u0004\u0018\u00010\u0005H\u0016J:\u0010ý\u0001\u001a\u00020\u00132\u0007\u0010þ\u0001\u001a\u00020\u00052\u0007\u0010û\u0001\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\t\u0010ü\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010ÿ\u0001\u001a\u00020\u00132\u0007\u0010\u0080\u0002\u001a\u00020\u00052\b\u0010\u0081\u0002\u001a\u00030\u0082\u0002H\u0016J#\u0010\u0083\u0002\u001a\u00020r2\u0006\u00100\u001a\u00020\u00052\t\u0010\u0084\u0002\u001a\u0004\u0018\u00010\u0016H\u0096@¢\u0006\u0003\u0010\u0085\u0002J)\u0010\u0086\u0002\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\t\u0010\u0087\u0002\u001a\u0004\u0018\u00010\u00052\t\u0010\u0088\u0002\u001a\u0004\u0018\u00010\u0005H\u0016JÐ\u0002\u0010\u0089\u0002\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010k\u001a\u00020\u00052\u0007\u0010\u008a\u0002\u001a\u00020\u000b2\t\u0010\u008b\u0002\u001a\u0004\u0018\u00010\u00052\u0007\u0010\u008c\u0002\u001a\u00020\u000b2\u0007\u0010\u008d\u0002\u001a\u00020\u000b2\u0007\u0010\u008e\u0002\u001a\u00020\u000b2\u0007\u0010\u0088\u0002\u001a\u00020\u000b2\t\u0010\u0087\u0002\u001a\u0004\u0018\u00010\u00052\t\u0010\u008f\u0002\u001a\u0004\u0018\u00010\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u00052\t\u0010\u0090\u0002\u001a\u0004\u0018\u00010\u00052\t\u0010\u0091\u0002\u001a\u0004\u0018\u00010\u00052\b\u00102\u001a\u0004\u0018\u00010\u00052\b\u00101\u001a\u0004\u0018\u00010\u00052\t\u0010\u0092\u0002\u001a\u0004\u0018\u00010\u00052\t\u0010\u0093\u0002\u001a\u0004\u0018\u00010\u00052\t\u0010\u0094\u0002\u001a\u0004\u0018\u00010\u000b2\t\u0010\u0095\u0002\u001a\u0004\u0018\u00010\u000b2\b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010-\u001a\u0004\u0018\u00010\u00052\t\u0010\u0096\u0002\u001a\u0004\u0018\u00010\u00052\t\u0010\u0097\u0002\u001a\u0004\u0018\u00010\u00052\b\u0010B\u001a\u0004\u0018\u00010\u00052\t\u0010\u0098\u0002\u001a\u0004\u0018\u00010\u00052\t\u0010\u0099\u0002\u001a\u0004\u0018\u00010\u00052\t\u0010\u009a\u0002\u001a\u0004\u0018\u00010\u00052\t\u0010Ó\u0001\u001a\u0004\u0018\u00010\u000e2\t\u0010\u009b\u0002\u001a\u0004\u0018\u00010\u00052\t\u0010\u009c\u0002\u001a\u0004\u0018\u00010\u00052\t\u0010\u009d\u0002\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0003\u0010\u009e\u0002Jy\u0010\u009f\u0002\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0007\u0010\u008c\u0002\u001a\u00020\u000b2\u0007\u0010\u008a\u0002\u001a\u00020\u000b2\t\u0010\u008f\u0002\u001a\u0004\u0018\u00010\u00052\t\u0010 \u0002\u001a\u0004\u0018\u00010\u00052\t\u0010¡\u0002\u001a\u0004\u0018\u00010\u00052\u0007\u0010¢\u0002\u001a\u00020\u000e2\t\u0010£\u0002\u001a\u0004\u0018\u00010\u00052\u0007\u0010¤\u0002\u001a\u00020\u000e2\t\u0010¥\u0002\u001a\u0004\u0018\u00010\u00052\t\u0010¦\u0002\u001a\u0004\u0018\u00010\u0005H\u0016Jc\u0010§\u0002\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\t\u0010¨\u0002\u001a\u0004\u0018\u00010\b2\t\u0010©\u0002\u001a\u0004\u0018\u00010\b2\t\u0010\u008a\u0002\u001a\u0004\u0018\u00010\b2\b\u0010'\u001a\u0004\u0018\u00010\u00052\b\u00100\u001a\u0004\u0018\u00010\u00052\t\u0010ª\u0002\u001a\u0004\u0018\u00010\u00052\b\u0010e\u001a\u0004\u0018\u00010fH\u0016¢\u0006\u0003\u0010«\u0002R\u0018\u0010\u0086\u0001\u001a\u00030\u0087\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R$\u0010\u008a\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u008b\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R$\u0010\u008e\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u008b\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u008f\u0001\u0010\u008d\u0001R*\u0010\u0091\u0001\u001a\u00020\u00052\u0007\u0010\u0090\u0001\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R*\u0010\u0096\u0001\u001a\u00020\u000e2\u0007\u0010\u0090\u0001\u001a\u00020\u000e8V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001R*\u0010\u009b\u0001\u001a\u00020\u00052\u0007\u0010\u0090\u0001\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u009c\u0001\u0010\u0093\u0001\"\u0006\b\u009d\u0001\u0010\u0095\u0001R$\u0010\u009e\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001a0\u008b\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u009f\u0001\u0010\u008d\u0001R\u0019\u0010 \u0001\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\b\u001a\u0006\b¡\u0001\u0010\u0093\u0001R\u0019\u0010¢\u0001\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\b\u001a\u0006\b£\u0001\u0010\u0093\u0001R\u0019\u0010¤\u0001\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\b\u001a\u0006\b¥\u0001\u0010\u0093\u0001R.\u0010¦\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u00058V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b§\u0001\u0010\u0093\u0001\"\u0006\b¨\u0001\u0010\u0095\u0001R$\u0010©\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u008b\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bª\u0001\u0010\u008d\u0001R$\u0010«\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160\u008b\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b¬\u0001\u0010\u008d\u0001R2\u0010\u00ad\u0001\u001a\u001d\u0012\u0004\u0012\u00020\u0005\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050w0\u008b\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b®\u0001\u0010\u008d\u0001R$\u0010²\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u008b\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b³\u0001\u0010\u008d\u0001R\u0019\u0010´\u0001\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\b\u001a\u0006\bµ\u0001\u0010\u0093\u0001R*\u0010¬\u0002\u001a\u00020\u000b2\u0007\u0010\u0090\u0001\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b¬\u0002\u0010\u00ad\u0002\"\u0006\b®\u0002\u0010¯\u0002¨\u0006°\u0002"}, d2 = {"Lcom/larus/bmhome/AIChatControlTraceServiceImpl;", "Lcom/larus/platform/spi/IAIChatControlTraceService;", "<init>", "()V", "sceneOther", "", "getChatType", "botConversationType", "", "botSourceType", "isOwnBot", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Z)Ljava/lang/String;", "chatKey", "", "getBotId", "getScene", "localMsgId", "onAnswerResult", "", "token", "msg", "Lcom/larus/im/bean/message/Message;", "errResult", "botId", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "(Ljava/lang/String;Lcom/larus/im/bean/message/Message;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/conversation/Conversation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onWaitAnswer", "onWaitPrompt", "replyToken", "onPromptResult", "onDiyActionClick", "buttonType", "clickFrom", "onAsrFeedbackClick", "feedbackType", "clickBottomMenuCamera", "isOCR", "chatType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "clickBottomMenuUploadImgEntrance", "templateId", "templateName", "referenceFromType", "referenceMessageId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "clickBottomMenuUploadFileEntrance", "conversationId", "previousPage", "actionBarTemplateName", "onMessageEditing", "type", "fileCount", "imageCount", "audioCount", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "setScene", "taskId", "scene", "onInputSend", "cacheMemorizedOptions", "memorizedOptions", "Lkotlin/Pair;", "setOriginalContentSource", "originalSource", "messageId", "getOriginalContentSource", "onInputModifySend", "setSpeakInfo", "msgId", "isSpeakHandsFree", "speakDuration", "handsfreeSpeakDuration", "handsfreeEnterMethod", "getSpeakInfo", "Lcom/larus/bmhome/chat/trace/SpeakInfo;", MemoryActionTag.MEMORY_ACTION_TAG_REMOVE, "setIsUnlimitedFlowFullScreen", "isUnlimitedFlowFullScreen", "setItemIdMap", "itemId", "setItemTypeMap", "itemType", "setRecoRequestIdMap", "recoRequestId", "getChatBaseMessage", "Lcom/larus/bmhome/chat/trace/ChatBaseData;", "onClickSearch", "fragment", "Landroidx/fragment/app/Fragment;", "onInputModifyCancel", "setIsShowFullInputBox", "isShowFullInputBox", "isUseFullInputBox", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "onClickDislike", "onClickLike", "clickBottomMenuEntrance", "showMenu", "registerTrackNode", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "unregisterTrackNode", "onCompleteDislikeReason", "onInputFunctionSwitch", "toStatus", "currentPage", "isKeyboardPop", "(Ljava/lang/String;Lcom/ixigua/lib/track/ITrackNode;JLjava/lang/String;Ljava/lang/Boolean;)V", "onRealtimeEntranceShow", "position", "hasRedDot", "getRecommendBotBaseJson", "Lorg/json/JSONObject;", "recommendFrom", "Lcom/larus/platform/model/RecommendFrom;", "hasReferenceImage", "msgExt", "", "paresImageEditType", "(Lcom/larus/im/bean/message/Message;)Ljava/lang/Integer;", "tryGetCacheConv", "convId", "filter", "Lkotlin/Function1;", "markThinkingArea", "markdownView", "Lcom/larus/business/markdown/api/view/text/IMarkdownTextView;", "onClickFullInputBoxButton", "action", "params", "onShowFullInputBoxButton", "inputType", "traceInfo", "Lcom/larus/bmhome/chat/trace/ChatControlTraceInfo;", "getTraceInfo", "()Lcom/larus/bmhome/chat/trace/ChatControlTraceInfo;", "enterMethodCacheForCvsId", "Landroidx/collection/LruCache;", "getEnterMethodCacheForCvsId", "()Landroidx/collection/LruCache;", "deepThinkMessageFoldStatus", "getDeepThinkMessageFoldStatus", "value", "lyricCreateType", "getLyricCreateType", "()Ljava/lang/String;", "setLyricCreateType", "(Ljava/lang/String;)V", "topResumedChatKey", "getTopResumedChatKey", "()J", "setTopResumedChatKey", "(J)V", "musicCreateModel", "getMusicCreateModel", "setMusicCreateModel", "cvsCache", "getCvsCache", "caseId", "getCaseId", "caseRequestId", "getCaseRequestId", "caseRecommendFrom", "getCaseRecommendFrom", "modifyMessageId", "getModifyMessageId", "setModifyMessageId", "imageFromCache", "getImageFromCache", "sendingMessageCache", "getSendingMessageCache", "sendMessageTrackExtMapForMsgId", "getSendMessageTrackExtMapForMsgId", "getImplTopResumedChatKey", "onModify", "isLatestUserMsg", "enterMethodCacheForMsgId", "getEnterMethodCacheForMsgId", "sendMsgSceneSecond", "getSendMsgSceneSecond", "getPreviousPage", "getAgentTool", "message", "setPicSourceEntrance", "entrance", "onDevShowOnBoardingCard", "senderId", "onBoardingType", "contentType", "isEmpty", "isFromPush", "isHighlight", "timeAfterPrevMessage", "timeAfterEnterForeground", "timeAfterCreate", "nextPulseType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZZZJLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;)V", "getReferenceExtJson", "ext", "getTraceInfoWithFpaPrefix", "uriStr", "getTraceInfoWithFpaPrefixFromMsg", "getLinkType", "getAgentId", "getBcmId", "jsonObject", "getEntityId", "onStreamResult", "botType", "duration", "(Lcom/larus/im/bean/conversation/Conversation;Ljava/lang/String;Lcom/larus/im/bean/message/Message;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getClickModule", "Landroid/view/View;", "logSendRender", "onStreamStart", "trackLongPressMenuItemsShow", "menuItems", "", "Lcom/larus/bmhome/view/screenmenu/abs/IMenuItem;", "bot", "Lcom/larus/im/bean/bot/BotModel;", "triggerFrom", "extParams", "showRegenInstruction", "regenInstruction", "clickRegenInstruction", "actionBarTemplateType", "(Lcom/larus/im/bean/message/Message;JLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "onCopy", "traceNode", "markdownContentList", "Lcom/larus/business/markdown/api/model/MarkdownContent;", "clickModule", "selectRange", "Lcom/larus/bmhome/chat/api/SelectionRangeType;", "extParam", "getTrackNode", "exportPanelElementClick", "exportActionId", "fileType", "exportMsgCnt", "messageIdList", "mobDeepResearchId", "showFrom", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ixigua/lib/track/ITrackNode;Ljava/lang/String;)V", "exportFiles", "exportPanelShow", "exportPanelElementShow", "sendPromptSurveyShow", "data", "messageIdString", "sendPromptSurveyClick", "result", "addAdditionalTraceListener", "key", "listener", "Lcom/larus/bmhome/chat/trace/IMessageTraceListener;", "getChatLastLogParams", "lastShownMsg", "(Ljava/lang/String;Lcom/larus/im/bean/message/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clickAttachmentDelete", "uri", "success", "uploadAttachmentStatus", "isMultiFile", "errorMessage", "isImg", "isAudio", "isVideo", "fileName", "enterMethod", "isMultiChooseMode", "contentSource", "ifEduIntention", "isImageMarked", "isImageCropped", "uploadFrom", "uploadWay", "clarifyId", "messageTypeOverride", "messageTypeDetailOverride", "uploadFileSize", "displayType", "agentType", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "uploadAttachmentSingleCost", "conversationID", "localMsgID", "cost", "md5", "fileSize", "fileExt", "uploadStatus", "onPasteImgContent", "fileCnt", "picCnt", "messageType", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ixigua/lib/track/ITrackNode;)V", "isUseReceiveServiceScene", "()Z", "setUseReceiveServiceScene", "(Z)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class AIChatControlTraceServiceImpl implements IAIChatControlTraceService {
    public AIChatControlTraceServiceImpl() {
    }

    public final String vb() {
        return "other";
    }

    public final void Cb() {
        ChatControlTrace.b.getClass();
        ChatControlTrace.A = false;
    }

    public final String Db() {
        ChatControlTrace.b.getClass();
        return ChatControlTrace.P;
    }

    public final String Hb() {
        ChatControlTrace.b.getClass();
        return ChatControlTrace.L;
    }

    public final boolean Mb() {
        return ChatControlTrace.b.Mb();
    }

    public final long Na() {
        ChatControlTrace.b.getClass();
        return ChatControlTrace.y;
    }

    public final LruCache<String, String> Nb() {
        ChatControlTrace.b.getClass();
        return ChatControlTrace.J;
    }

    public final String Rb() {
        ChatControlTrace.b.getClass();
        return ChatControlTrace.M;
    }

    public final LruCache<String, wc9.e> ac() {
        ChatControlTrace.b.getClass();
        return ChatControlTrace.o;
    }

    public final LruCache<String, Map<String, String>> dc() {
        ChatControlTrace.b.getClass();
        return ChatControlTrace.H;
    }

    public final LruCache<String, String> eb() {
        ChatControlTrace.b.getClass();
        return ChatControlTrace.p;
    }

    public final void fb() {
        ChatControlTrace.b.fb();
    }

    public final long gb() {
        ChatControlTrace.b.getClass();
        return ChatControlTrace.y;
    }

    public final com.larus.bmhome.chat.trace.m getTraceInfo() {
        ChatControlTrace.b.getClass();
        return ChatControlTrace.x;
    }

    public final LruCache<String, String> kb() {
        ChatControlTrace.b.getClass();
        return ChatControlTrace.G;
    }

    public final LruCache<String, Message> mb() {
        ChatControlTrace.b.getClass();
        return ChatControlTrace.q;
    }

    public final String nb() {
        ChatControlTrace.b.getClass();
        return ChatControlTrace.z;
    }

    public final LruCache<String, String> xb() {
        ChatControlTrace.b.getClass();
        return ChatControlTrace.I;
    }

    public final void Sb() {
        Intrinsics.checkNotNullParameter(ChatDraftItem.TYPE_TEXT, "type");
        ChatControlTrace.b.Sb();
    }

    public final String Ia(String r2) {
        Intrinsics.checkNotNullParameter(r2, "localMsgId");
        return ChatControlTrace.b.Ia(r2);
    }

    public final void Ja(String r2) {
        ChatControlTrace.b.getClass();
        ChatControlTrace.r = r2;
    }

    public final void Ka(String r10) {
        Intrinsics.checkNotNullParameter(r10, "messageId");
        com.larus.bmhome.chat.trace.z r1 = com.larus.bmhome.chat.trace.z.a;
        Intrinsics.checkNotNullParameter(r10, "messageId");
        CopyOnWriteArraySet r0 = com.larus.bmhome.chat.trace.z.b;
        if (r0.isEmpty() == true) goto L40;
        Iterator r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        Object r3 = r2.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.chat.trace.z.a) r3).c, r10) == false) goto L7;
    L12:
        com.larus.bmhome.chat.trace.z.a r4 = (com.larus.bmhome.chat.trace.z.a) r3;
        if (r4 != null) goto L15;
        return;
    L15:
        if (r4.b > 0) goto L18;
        return;
    L18:
        if (com.larus.bmhome.chat.trace.z.b.remove(r4) == false) goto L31;
        long r5 = SystemClock.elapsedRealtime() - r4.b;
        String r11 = r4.a;
        String r6 = r4.c;
        Long r7 = Long.valueOf(r5);
        JSONObject r8 = new JSONObject();
        Intrinsics.checkNotNullParameter(r8, "params");
        if (r11 != null) goto L33;
    L24:
        if (r6 == null) goto L26;
        r8.put("local_message_id", r6);     // Catch: JSONException -> L22
    L26:
        if (r7 == null) goto L30;
        r8.put("duration", r7.longValue());     // Catch: JSONException -> L22
    L22:
        e = move-exception;
        FLogger.a.e("DevEventHelper", "error in DevEventHelper devSendMessage " + e.getLocalizedMessage());
    L30:
        TrackParams r12 = new TrackParams().merge(r8);
        by7.a r9 = new by7.a("dev_send_message");
        r9.a.merge(r12);
        r9.b();
        FLogger.a.d("ChatSendTrace", "render message: " + r4.c + ", cost: " + r5 + ", traceId: " + r4.a);
        return;
    L33:
        r8.put("trace_id", r11);     // Catch: JSONException -> L22
        goto L24
    L31:
        FLogger.a.d("ChatSendTrace", "render message: " + r4.c + ", duplicate");
        return;
    L11:
        r3 = null;
        goto L12
    }

    public final String Kb(Message r2) {
        return ChatControlTrace.b.Kb(r2);
    }

    public final void Pa(Pair<Boolean, Boolean> r2) {
        ChatControlTrace.b.getClass();
        ChatControlTrace.F = r2;
    }

    public final String Sa(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        return ChatControlTrace.b.Sa(r2);
    }

    public final JSONObject Ta(String r2) {
        return ChatControlTrace.b.Ta(r2);
    }

    public final Integer Wb(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        return ChatControlTrace.b.Wb(r2);
    }

    public final JSONObject Xb(RecommendFrom r2) {
        return ChatControlTrace.b.Xb(r2);
    }

    public final String Ya(JSONObject r2) {
        return ChatControlTrace.b.Ya(r2);
    }

    public final void Yb(r r3) {
        Intrinsics.checkNotNullParameter("MusicCreateMob", "key");
        Intrinsics.checkNotNullParameter(r3, "listener");
        ChatControlTrace.b.Yb(r3);
    }

    public final String Za(Message r2) {
        return ChatControlTrace.b.Za(r2);
    }

    public final void ab(String r2) {
        Intrinsics.checkNotNullParameter(r2, "token");
        ChatControlTrace.b.ab(r2);
    }

    public final String bb(long r2) {
        return ChatControlTrace.b.bb(r2);
    }

    public final void bc(boolean r2) {
        ChatControlTrace.b.getClass();
        ChatControlTrace.Y = r2;
    }

    public final void cb(String r2) {
        Intrinsics.checkNotNullParameter(r2, "token");
        ChatControlTrace.b.cb(r2);
    }

    public final void cc(ow8.a r2) {
        Intrinsics.checkNotNullParameter(r2, "markdownView");
        ChatControlTrace.b.cc(r2);
    }

    public final com.larus.bmhome.chat.trace.a gc(long r2) {
        return ChatControlTrace.b.gc(r2);
    }

    public final String getBotId(long r2) {
        return ChatControlTrace.b.getBotId(r2);
    }

    public final String h(long r2) {
        return ChatControlTrace.b.h(r2);
    }

    public final void hb(String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        ChatControlTrace.b.getClass();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
    }

    public final boolean ib(Map<String, String> r2) {
        return ChatControlTrace.b.ib(r2);
    }

    public final String jb(View r2) {
        return ChatControlTrace.b.jb(r2);
    }

    public final by7.e ob(long r2) {
        return ChatControlTrace.b.ob(r2);
    }

    public final String pb(JSONObject r2) {
        return ChatControlTrace.b.pb(r2);
    }

    public final String tb(Message r2) {
        return ChatControlTrace.b.tb(r2);
    }

    public final void wb(String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        ChatControlTrace.b.getClass();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        ChatControlTrace.z = r2;
    }

    public final void Ab(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "originalSource");
        Intrinsics.checkNotNullParameter(r3, "messageId");
        ChatControlTrace.b.Ab(r2, r3);
    }

    public final void Ca(Boolean r2, Boolean r3) {
        ChatControlTrace.b.Ca(r2, r3);
    }

    public final void Ga(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
        ChatControlTrace.b.Ga(r2, r3);
    }

    public final JSONObject Gb(String r2, JSONObject r3) {
        return ChatControlTrace.b.Gb(r2, r3);
    }

    public final void Jb(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "replyToken");
        Intrinsics.checkNotNullParameter(r3, "token");
        ChatControlTrace.b.Jb(r2, r3);
    }

    public final void Ma(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "scene");
        ChatControlTrace.b.Ma(r2, r3);
    }

    public final void Oa(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
        ChatControlTrace.b.Oa(r2, r3);
    }

    public final wc9.e Qb(String r2, Function1<? super wc9.e, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r3, "filter");
        if (r2 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L13;
        return null;
    L13:
        return ChatControlTrace.b.Qb(r2, r3);
    L5:
        if (StringsKt.isBlank(r2) == true) goto L8;
        r0 = false;
        goto L9
    }

    public final JSONObject Ua(Message r2, JSONObject r3) {
        return ChatControlTrace.b.Ua(r2, r3);
    }

    public final void Va(int r2, long r3) {
        ChatControlTrace.b.Va(r2, r3);
    }

    public final void lb(Message r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        ChatControlTrace.b.lb(r2, r3);
    }

    public final void qb(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
        ChatControlTrace.b.qb(r2, r3);
    }

    public final void rb(String r2, String r3) {
        ChatControlTrace.b.rb(r2, r3);
    }

    public final void sb(String r2, String r3) {
        ChatControlTrace.b.sb(r2, r3);
    }

    public final void Fa(Message r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        ChatControlTrace.b.Fa(r2, r3, r4);
    }

    public final void Fb(String r2, String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        ChatControlTrace.b.Fb("open", r3, r4);
    }

    public final void Ib(Message r2, long r3, String r5) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r5, "regenInstruction");
        ChatControlTrace.b.Ib(r2, r3, r5);
    }

    public final Object Ob(String r2, Message r3, Continuation<? super JSONObject> r4) {
        return ChatControlTrace.b.Ob(r2, r3, r4);
    }

    public final void Wa(String r2, String r3, long r4) {
        ChatControlTrace.b.Wa(r2, "answer", r4);
    }

    public final void db(String r2, Message r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "token");
        Intrinsics.checkNotNullParameter(r3, "msg");
        ChatControlTrace.b.db(r2, r3, r4);
    }

    public final String g(Integer r2, Integer r3, boolean r4) {
        return ChatControlTrace.b.g(r2, r3, r4);
    }

    public final void yb(Message r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "data");
        ChatControlTrace.b.yb(r2, r3, r4);
    }

    public final void Ha(String r7, Message r8, Fragment r9, long r10) {
        Intrinsics.checkNotNullParameter("answer", "clickFrom");
        Intrinsics.checkNotNullParameter(r8, "msg");
        ChatControlTrace.b.Ha("answer", r8, r9, r10);
    }

    public final void La(String r8, String r9, String r10, long r11) {
        Intrinsics.checkNotNullParameter(r8, "clickFrom");
        Intrinsics.checkNotNullParameter(r9, "messageId");
        Intrinsics.checkNotNullParameter(r10, "exportActionId");
        ChatControlTrace.b.La(r8, r9, r10, r11);
    }

    public final void Pb(Message r8, String r9, long r10, boolean r12) {
        Intrinsics.checkNotNullParameter(r8, "msg");
        Intrinsics.checkNotNullParameter(r9, "type");
        ChatControlTrace.b.Pb(r8, r9, r10, r12);
    }

    public final void Qa(String r7, Message r8, Fragment r9, long r10) {
        Intrinsics.checkNotNullParameter("answer", "clickFrom");
        Intrinsics.checkNotNullParameter(r8, "msg");
        ChatControlTrace.b.Qa("answer", r8, r9, r10);
    }

    public final void Ra(String r2, boolean r3, by7.e r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "position");
        Intrinsics.checkNotNullParameter(r5, "botId");
        ChatControlTrace.b.Ra(r2, r3, r4, r5);
    }

    public final void Xa(String r8, long r9, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "exportActionId");
        ChatControlTrace.b.Xa(r8, r9, r11, r12);
    }

    public final void fc(String r2, Integer r3, Integer r4, Integer r5) {
        Intrinsics.checkNotNullParameter("audio", "type");
        ChatControlTrace.b.fc("audio", r3, r4, r5);
    }

    public final void Ba(Message r9, long r10, String r12, String r13, Integer r14) {
        Intrinsics.checkNotNullParameter(r9, "message");
        Intrinsics.checkNotNullParameter(r12, "regenInstruction");
        ChatControlTrace.b.Ba(r9, r10, r12, r13, r14);
    }

    public final void Zb(String r9, by7.e r10, long r11, String r13, Boolean r14) {
        Intrinsics.checkNotNullParameter(r9, "toStatus");
        ChatControlTrace.b.Zb(r9, r10, r11, r13, r14);
    }

    public final void hc(String r8, Message r9, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "result");
        Intrinsics.checkNotNullParameter(r9, "data");
        ChatControlTrace.b.hc(r8, r9, r10, r11, r12);
    }

    public final void ub(String r10, boolean r11, long r12, long r14, String r16) {
        Intrinsics.checkNotNullParameter(r10, "msgId");
        ChatControlTrace.b.ub(r10, r11, r12, r14, r16);
    }

    public final void zb(boolean r7, String r8, String r9, String r10, String r11) {
        ChatControlTrace.b.zb(r7, r8, r9, r10, r11);
    }

    public final Object Vb(String r8, Message r9, String r10, String r11, wc9.e r12, Continuation<? super Unit> r13) {
        Object r14 = ChatControlTrace.b.Vb(r8, r9, r10, r11, r12, r13);
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r14;
    L6:
        return Unit.INSTANCE;
    }

    public final void Ub(String r9, Integer r10, Integer r11, Integer r12, String r13, String r14, by7.e r15) {
        ChatControlTrace.b.Ub(r9, r10, r11, r12, r13, r14, r15);
    }

    public final void jc(List<? extends ot8.a> r10, Message r11, BotModel r12, by7.e r13, String r14, String r15, JSONObject r16) {
        Intrinsics.checkNotNullParameter(r10, "menuItems");
        Intrinsics.checkNotNullParameter(r11, "message");
        Intrinsics.checkNotNullParameter(r15, "triggerFrom");
        Intrinsics.checkNotNullParameter(r16, "extParams");
        ChatControlTrace.b.jc(r10, r11, r12, r13, r14, r15, r16);
    }

    public final Object Aa(wc9.e r11, String r12, Message r13, String r14, String r15, Integer r16, long r17, Continuation<? super Unit> r19) {
        Object r0 = ChatControlTrace.b.Aa(r11, r12, r13, r14, r15, r16, r17, r19);
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r0;
    L6:
        return Unit.INSTANCE;
    }

    public final void Bb(String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17) {
        ChatControlTrace.b.Bb(r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public final void ec(String r10, String r11, Integer r12, String r13, String r14, String r15, String r16, String r17) {
        ChatControlTrace.b.ec(r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public final void Ea(String r13, String r14, String r15, long r16, String r18, String r19, String r20, String r21, by7.e r22) {
        Intrinsics.checkNotNullParameter(r13, "showFrom");
        Intrinsics.checkNotNullParameter(r14, "fileType");
        Intrinsics.checkNotNullParameter(r15, "exportActionId");
        ChatControlTrace.b.Ea(r13, r14, r15, r16, r18, r19, r20, r21, r22);
    }

    public final void Eb(String r15, Message r16, by7.e r17, long r18, List<? extends lw8.l> r20, View r21, String r22, SelectionRangeType r23, String r24, Map<String, Integer> r25) {
        Intrinsics.checkNotNullParameter(r15, "clickFrom");
        Intrinsics.checkNotNullParameter(r16, "msg");
        Intrinsics.checkNotNullParameter(r20, "markdownContentList");
        IAIChatControlTraceService.a.d(ChatControlTrace.b, r15, r16, r17, r18, r20, r21, r22, r23, r24, null, 512);
    }

    public final void ic(String r14, boolean r15, String r16, String r17, String r18, long r19, String r21, long r22, String r24, String r25) {
        ChatControlTrace.b.ic(r14, r15, r16, r17, r18, r19, r21, r22, r24, r25);
    }

    public final void Da(String r15, String r16, long r17, String r19, Integer r20, String r21, String r22, String r23, String r24, by7.e r25, String r26) {
        Intrinsics.checkNotNullParameter(r15, "exportActionId");
        Intrinsics.checkNotNullParameter(r16, "clickFrom");
        ChatControlTrace.b.Da(r15, r16, r17, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public final void Lb(String r15, String r16, String r17, Integer r18, boolean r19, boolean r20, boolean r21, long r22, Long r24, Long r25, Long r26, Integer r27) {
        ChatControlTrace.b.Lb(r15, r16, r17, r18, r19, r20, r21, r22, r24, r25, r26, r27);
    }

    public final void Tb(String r33, String r34, boolean r35, String r36, boolean r37, boolean r38, boolean r39, boolean r40, String r41, String r42, String r43, String r44, String r45, String r46, String r47, String r48, String r49, Boolean r50, Boolean r51, String r52, String r53, String r54, String r55, String r56, String r57, String r58, String r59, Long r60, String r61, String r62, String r63) {
        Intrinsics.checkNotNullParameter(r34, "currentPage");
        ChatControlTrace.b.Tb(r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63);
    }
}
