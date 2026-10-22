package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000f\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001aJ\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\bø\u0001\u0000\u001a$\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u001aJ\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\bø\u0001\u0000\u001a9\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\n\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004H\u0087\b\u001a6\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u001a'\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004H\u0087\b\u001aJ\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\bø\u0001\u0000\u001a[\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0010*\u00020\u0011*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a]\u0010\u0014\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0010*\u00020\u0011*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a\\\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0016\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\n0\u0006H\u0086\bø\u0001\u0000\u001aa\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0016\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\f0\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0017\u001au\u0010\u0018\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010\"\u0010\b\u0003\u0010\u0019*\n\u0012\u0006\b\u0000\u0012\u0002H\u00100\u001a*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u001b\u001a\u0002H\u00192$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\n0\u0006H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001aw\u0010\u0018\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010\"\u0010\b\u0003\u0010\u0019*\n\u0012\u0006\b\u0000\u0012\u0002H\u00100\u001a*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u001b\u001a\u0002H\u00192$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\f0\u0006H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001c\u001aJ\u0010\u001e\u001a\u00020\u001f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010 \u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u001f0\u0006H\u0087\bø\u0001\u0000\u001aV\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0016\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0012\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0086\bø\u0001\u0000\u001a\\\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0016\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0010*\u00020\u0011*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\u0006H\u0086\bø\u0001\u0000\u001au\u0010#\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0010*\u00020\u0011\"\u0010\b\u0003\u0010\u0019*\n\u0012\u0006\b\u0000\u0012\u0002H\u00100\u001a*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u001b\u001a\u0002H\u00192 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\u0006H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001ao\u0010$\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010\"\u0010\b\u0003\u0010\u0019*\n\u0012\u0006\b\u0000\u0012\u0002H\u00100\u001a*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u001b\u001a\u0002H\u00192\u001e\u0010\u0012\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001ak\u0010%\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b(\u001ah\u0010)\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000\u001a_\u0010*\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010+\u001aJ\u0010*\u001a\u00020,\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020,0\u0006H\u0087\bø\u0001\u0000\u001aJ\u0010*\u001a\u00020-\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020-0\u0006H\u0087\bø\u0001\u0000\u001aa\u0010.\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010+\u001aQ\u0010.\u001a\u0004\u0018\u00010,\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020,0\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010/\u001aQ\u0010.\u001a\u0004\u0018\u00010-\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020-0\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u00100\u001aq\u00101\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u00102\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u001003j\n\u0012\u0006\b\u0000\u0012\u0002H\u0010`42\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u00105\u001as\u00106\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u00102\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u001003j\n\u0012\u0006\b\u0000\u0012\u0002H\u0010`42\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u00105\u001al\u00107\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u00102\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000703j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`4H\u0087\b¢\u0006\u0002\b8\u001ai\u00109\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u00102\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000703j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`4H\u0087\b\u001ak\u0010:\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b;\u001ah\u0010<\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000\u001a_\u0010=\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010+\u001aJ\u0010=\u001a\u00020,\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020,0\u0006H\u0087\bø\u0001\u0000\u001aJ\u0010=\u001a\u00020-\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020-0\u0006H\u0087\bø\u0001\u0000\u001aa\u0010>\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010+\u001aQ\u0010>\u001a\u0004\u0018\u00010,\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020,0\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010/\u001aQ\u0010>\u001a\u0004\u0018\u00010-\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020-0\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u00100\u001aq\u0010?\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u00102\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u001003j\n\u0012\u0006\b\u0000\u0012\u0002H\u0010`42\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u00105\u001as\u0010@\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u00102\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u001003j\n\u0012\u0006\b\u0000\u0012\u0002H\u0010`42\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u00105\u001al\u0010A\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u00102\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000703j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`4H\u0087\b¢\u0006\u0002\bB\u001ai\u0010C\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u00102\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000703j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`4H\u0087\b\u001a$\u0010D\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u001aJ\u0010D\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\bø\u0001\u0000\u001aY\u0010E\u001a\u0002HF\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0016\b\u0002\u0010F*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004*\u0002HF2\u001e\u0010 \u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u001f0\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010G\u001an\u0010H\u001a\u0002HF\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0016\b\u0002\u0010F*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004*\u0002HF23\u0010 \u001a/\u0012\u0013\u0012\u00110\u000e¢\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(L\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u001f0IH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010M\u001a6\u0010N\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030O0\u0016\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006P"}, d2 = {LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL, "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "predicate", "Lkotlin/Function1;", "", "any", "asIterable", "", "asSequence", "Lkotlin/sequences/Sequence;", CommonConsts.COUNT_TYPE, "", "firstNotNullOf", "R", "", "transform", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "firstNotNullOfOrNull", "flatMap", "", "flatMapSequence", "flatMapTo", "C", "", "destination", "(Ljava/util/Map;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "flatMapSequenceTo", "forEach", "", "action", "map", "mapNotNull", "mapNotNullTo", "mapTo", "maxBy", "", "selector", "maxByOrThrow", "maxByOrNull", "maxOf", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", "", "", "maxOfOrNull", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Double;", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Float;", "maxOfWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/Map;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "maxOfWithOrNull", "maxWith", "maxWithOrThrow", "maxWithOrNull", "minBy", "minByOrThrow", "minByOrNull", "minOf", "minOfOrNull", "minOfWith", "minOfWithOrNull", "minWith", "minWithOrThrow", "minWithOrNull", "none", "onEach", "M", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "onEachIndexed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "index", "(Ljava/util/Map;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "toList", "Lkotlin/Pair;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/MapsKt")
class MapsKt___MapsKt extends MapsKt___MapsJvmKt {
    public MapsKt___MapsKt() {
    }

    public static final <K, V> boolean all(Map<? extends K, ? extends V> r4, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "predicate");
        if (r6.isEmpty() == false) goto L5;
        return true;
    L5:
        Iterator<Map.Entry<K, V>> r8 = r6.entrySet().iterator();
    L7:
        if (r8.hasNext() == false) goto L12;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r7.invoke((Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin")), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L7;
        return false;
    L12:
        return true;
    }

    public static final <K, V> boolean any(Map<? extends K, ? extends V> r2) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return !r3.isEmpty();
    }

    public static final <K, V> boolean any(Map<? extends K, ? extends V> r4, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "predicate");
        if (r6.isEmpty() == false) goto L5;
        return false;
    L5:
        Iterator<Map.Entry<K, V>> r8 = r6.entrySet().iterator();
    L7:
        if (r8.hasNext() == false) goto L12;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r7.invoke((Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin")), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L7;
        return true;
    L12:
        return false;
    }

    private static final <K, V> Iterable<Map.Entry<K, V>> asIterable(Map<? extends K, ? extends V> r2) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return (Iterable) ZeusTransformUtils.preCheckCast(r3.entrySet(), Iterable.class, "com.obric.memorydata.plugin");
    }

    public static final <K, V> Sequence<Map.Entry<K, V>> asSequence(Map<? extends K, ? extends V> r2) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r3.entrySet(), Iterable.class, "com.obric.memorydata.plugin"));
    }

    private static final <K, V> int count(Map<? extends K, ? extends V> r2) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return r3.size();
    }

    public static final <K, V> int count(Map<? extends K, ? extends V> r4, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "predicate");
        int r2 = 0;
        if (r6.isEmpty() == false) goto L5;
        return 0;
    L5:
        Iterator<Map.Entry<K, V>> r8 = r6.entrySet().iterator();
    L7:
        if (r8.hasNext() == false) goto L11;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r7.invoke((Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin")), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L7;
        r2 = r2 + 1;
        goto L7
    L11:
        return r2;
    }

    private static final <K, V, R> R firstNotNullOf(Map<? extends K, ? extends V> r3, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "transform");
        Iterator<Map.Entry<K, V>> r7 = r5.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        R r0 = (R) r6.invoke((Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin"));
        if (r0 == null) goto L4;
    L9:
        if (r0 == null) goto L12;
        return r0;
    L12:
        throw new NoSuchElementException("No element of the map was transformed to a non-null value.");
    L8:
        r0 = null;
        goto L9
    }

    private static final <K, V, R> R firstNotNullOfOrNull(Map<? extends K, ? extends V> r3, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "transform");
        Iterator<Map.Entry<K, V>> r7 = r5.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        R r0 = (R) r6.invoke((Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin"));
        if (r0 == null) goto L4;
        return r0;
    L8:
        return null;
    }

    public static final <K, V, R> List<R> flatMap(Map<? extends K, ? extends V> r4, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "transform");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<K, V>> r8 = r6.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L7;
        CollectionsKt.addAll(r0, (Iterable) ZeusTransformUtils.preCheckCast(r7.invoke((Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));
        goto L4
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    public static final <K, V, R> List<R> flatMapSequence(Map<? extends K, ? extends V> r4, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Sequence<? extends R>> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "transform");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<K, V>> r8 = r6.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L7;
        CollectionsKt.addAll(r0, (Sequence) ZeusTransformUtils.preCheckCast(r7.invoke((Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin")), Sequence.class, "com.obric.memorydata.plugin"));
        goto L4
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    public static final <K, V, R, C extends Collection<? super R>> C flatMapSequenceTo(Map<? extends K, ? extends V> r3, C r4, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Sequence<? extends R>> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        C r7 = (C) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "destination");
        Intrinsics.checkNotNullParameter(r8, "transform");
        Iterator<Map.Entry<K, V>> r9 = r6.entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        CollectionsKt.addAll(r7, (Sequence) ZeusTransformUtils.preCheckCast(r8.invoke((Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin")), Sequence.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        return r7;
    }

    public static final <K, V, R, C extends Collection<? super R>> C flatMapTo(Map<? extends K, ? extends V> r3, C r4, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        C r7 = (C) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "destination");
        Intrinsics.checkNotNullParameter(r8, "transform");
        Iterator<Map.Entry<K, V>> r9 = r6.entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        CollectionsKt.addAll(r7, (Iterable) ZeusTransformUtils.preCheckCast(r8.invoke((Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        return r7;
    }

    public static final <K, V> void forEach(Map<? extends K, ? extends V> r3, Function1<? super Map.Entry<? extends K, ? extends V>, Unit> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "action");
        Iterator<Map.Entry<K, V>> r7 = r5.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r6.invoke((Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    public static final <K, V, R> List<R> map(Map<? extends K, ? extends V> r4, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "transform");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r6.size()), Collection.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<K, V>> r8 = r6.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L7;
        r0.add(r7.invoke((Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin")));
        goto L4
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    public static final <K, V, R> List<R> mapNotNull(Map<? extends K, ? extends V> r4, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "transform");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<K, V>> r8 = r6.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        Object r2 = r7.invoke((Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin"));
        if (r2 == null) goto L4;
        r0.add(r2);
        goto L4
    L9:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    public static final <K, V, R, C extends Collection<? super R>> C mapNotNullTo(Map<? extends K, ? extends V> r3, C r4, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        C r7 = (C) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "destination");
        Intrinsics.checkNotNullParameter(r8, "transform");
        Iterator<Map.Entry<K, V>> r9 = r6.entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L8;
        Object r0 = r8.invoke((Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin"));
        if (r0 == null) goto L4;
        r7.add(r0);
        goto L4
    L8:
        return r7;
    }

    public static final <K, V, R, C extends Collection<? super R>> C mapTo(Map<? extends K, ? extends V> r3, C r4, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        C r7 = (C) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "destination");
        Intrinsics.checkNotNullParameter(r8, "transform");
        Iterator<Map.Entry<K, V>> r9 = r6.entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        r7.add(r8.invoke((Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin")));
        goto L4
    L6:
        return r7;
    }

    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> maxByOrNull(Map<? extends K, ? extends V> r6, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "selector");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r8.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r10.hasNext() == true) goto L5;
        Object r11 = null;
    L16:
        return (Map.Entry) ZeusTransformUtils.preCheckCast(r11, Map.Entry.class, "com.obric.memorydata.plugin");
    L5:
        Object r0 = r10.next();
        if (r10.hasNext() == true) goto L8;
    L7:
        r11 = r0;
        goto L16
    L8:
        Comparable r2 = (Comparable) ZeusTransformUtils.preCheckCast(r9.invoke(r0), Comparable.class, "com.obric.memorydata.plugin");
    L9:
        Object r3 = r10.next();
        Comparable r4 = (Comparable) ZeusTransformUtils.preCheckCast(r9.invoke(r3), Comparable.class, "com.obric.memorydata.plugin");
        if (r2.compareTo(r4) >= 0) goto L13;
        r0 = r3;
        r2 = r4;
    L13:
        if (r10.hasNext() == true) goto L9;
        goto L7
    }

    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> maxByOrThrow(Map<? extends K, ? extends V> r6, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "selector");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r8.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r10.hasNext() == false) goto L16;
        Object r0 = r10.next();
        if (r10.hasNext() == false) goto L14;
        Comparable r2 = (Comparable) ZeusTransformUtils.preCheckCast(r9.invoke(r0), Comparable.class, "com.obric.memorydata.plugin");
    L8:
        Object r3 = r10.next();
        Comparable r4 = (Comparable) ZeusTransformUtils.preCheckCast(r9.invoke(r3), Comparable.class, "com.obric.memorydata.plugin");
        if (r2.compareTo(r4) >= 0) goto L12;
        r0 = r3;
        r2 = r4;
    L12:
        if (r10.hasNext() == true) goto L8;
    L14:
        return (Map.Entry) ZeusTransformUtils.preCheckCast(r0, Map.Entry.class, "com.obric.memorydata.plugin");
    L16:
        throw new NoSuchElementException();
    }

    private static final <K, V> double maxOf(Map<? extends K, ? extends V> r6, Function1<? super Map.Entry<? extends K, ? extends V>, Double> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "selector");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r8.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r10.hasNext() == false) goto L10;
        double r2 = ((Number) ZeusTransformUtils.preCheckCast(r9.invoke(r10.next()), Number.class, "com.obric.memorydata.plugin")).doubleValue();
    L6:
        if (r10.hasNext() == false) goto L8;
        r2 = Math.max(r2, ((Number) ZeusTransformUtils.preCheckCast(r9.invoke(r10.next()), Number.class, "com.obric.memorydata.plugin")).doubleValue());
        goto L6
    L8:
        return r2;
    L10:
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <K, V> float m1868maxOf(Map<? extends K, ? extends V> r4, Function1<? super Map.Entry<? extends K, ? extends V>, Float> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "selector");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r6.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r8.hasNext() == false) goto L10;
        float r0 = ((Number) ZeusTransformUtils.preCheckCast(r7.invoke(r8.next()), Number.class, "com.obric.memorydata.plugin")).floatValue();
    L6:
        if (r8.hasNext() == false) goto L8;
        r0 = Math.max(r0, ((Number) ZeusTransformUtils.preCheckCast(r7.invoke(r8.next()), Number.class, "com.obric.memorydata.plugin")).floatValue());
        goto L6
    L8:
        return r0;
    L10:
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <K, V, R extends Comparable<? super R>> R m1869maxOf(Map<? extends K, ? extends V> r4, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "selector");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r6.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r8.hasNext() == false) goto L12;
        R r0 = (R) ZeusTransformUtils.preCheckCast(r7.invoke(r8.next()), Comparable.class, "com.obric.memorydata.plugin");
    L6:
        if (r8.hasNext() == false) goto L10;
        Comparable r2 = (Comparable) ZeusTransformUtils.preCheckCast(r7.invoke(r8.next()), Comparable.class, "com.obric.memorydata.plugin");
        if (r0.compareTo(r2) >= 0) goto L6;
        r0 = (R) r2;
        goto L6
    L10:
        return r0;
    L12:
        throw new NoSuchElementException();
    }

    private static final <K, V, R extends Comparable<? super R>> R maxOfOrNull(Map<? extends K, ? extends V> r4, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "selector");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r6.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r8.hasNext() == true) goto L5;
        return null;
    L5:
        Comparable r0 = (Comparable) ZeusTransformUtils.preCheckCast(r7.invoke(r8.next()), Comparable.class, "com.obric.memorydata.plugin");
    L7:
        if (r8.hasNext() == false) goto L12;
        Comparable r2 = (Comparable) ZeusTransformUtils.preCheckCast(r7.invoke(r8.next()), Comparable.class, "com.obric.memorydata.plugin");
        if (r0.compareTo(r2) >= 0) goto L7;
        r0 = r2;
        goto L7
    L12:
        return (R) r0;
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final <K, V> Double m1870maxOfOrNull(Map<? extends K, ? extends V> r6, Function1<? super Map.Entry<? extends K, ? extends V>, Double> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "selector");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r8.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r10.hasNext() == true) goto L5;
        return null;
    L5:
        double r2 = ((Number) ZeusTransformUtils.preCheckCast(r9.invoke(r10.next()), Number.class, "com.obric.memorydata.plugin")).doubleValue();
    L7:
        if (r10.hasNext() == false) goto L10;
        r2 = Math.max(r2, ((Number) ZeusTransformUtils.preCheckCast(r9.invoke(r10.next()), Number.class, "com.obric.memorydata.plugin")).doubleValue());
        goto L7
    L10:
        return Double.valueOf(r2);
    }

    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final <K, V> Float m1871maxOfOrNull(Map<? extends K, ? extends V> r4, Function1<? super Map.Entry<? extends K, ? extends V>, Float> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "selector");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r6.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r8.hasNext() == true) goto L5;
        return null;
    L5:
        float r0 = ((Number) ZeusTransformUtils.preCheckCast(r7.invoke(r8.next()), Number.class, "com.obric.memorydata.plugin")).floatValue();
    L7:
        if (r8.hasNext() == false) goto L10;
        r0 = Math.max(r0, ((Number) ZeusTransformUtils.preCheckCast(r7.invoke(r8.next()), Number.class, "com.obric.memorydata.plugin")).floatValue());
        goto L7
    L10:
        return Float.valueOf(r0);
    }

    private static final <K, V, R> R maxOfWith(Map<? extends K, ? extends V> r3, Comparator<? super R> r4, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Comparator r7 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r4, Comparator.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "comparator");
        Intrinsics.checkNotNullParameter(r8, "selector");
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r6.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r9.hasNext() == false) goto L12;
        R r0 = (R) r8.invoke(r9.next());
    L6:
        if (r9.hasNext() == false) goto L10;
        Object r1 = r8.invoke(r9.next());
        if (r7.compare(r0, r1) >= 0) goto L6;
        r0 = (R) r1;
        goto L6
    L10:
        return r0;
    L12:
        throw new NoSuchElementException();
    }

    private static final <K, V, R> R maxOfWithOrNull(Map<? extends K, ? extends V> r3, Comparator<? super R> r4, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Comparator r7 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r4, Comparator.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "comparator");
        Intrinsics.checkNotNullParameter(r8, "selector");
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r6.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r9.hasNext() == true) goto L5;
        return null;
    L5:
        Object r0 = r8.invoke(r9.next());
    L7:
        if (r9.hasNext() == false) goto L12;
        Object r1 = r8.invoke(r9.next());
        if (r7.compare(r0, r1) >= 0) goto L7;
        r0 = r1;
        goto L7
    L12:
        return (R) r0;
    }

    private static final <K, V> Map.Entry<K, V> maxWithOrNull(Map<? extends K, ? extends V> r2, Comparator<? super Map.Entry<? extends K, ? extends V>> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Comparator r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "comparator");
        return (Map.Entry) ZeusTransformUtils.preCheckCast(CollectionsKt.maxWithOrNull((Iterable) ZeusTransformUtils.preCheckCast(r4.entrySet(), Iterable.class, "com.obric.memorydata.plugin"), r5), Map.Entry.class, "com.obric.memorydata.plugin");
    }

    private static final <K, V> Map.Entry<K, V> maxWithOrThrow(Map<? extends K, ? extends V> r2, Comparator<? super Map.Entry<? extends K, ? extends V>> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Comparator r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "comparator");
        return (Map.Entry) ZeusTransformUtils.preCheckCast(CollectionsKt.maxWithOrThrow((Iterable) ZeusTransformUtils.preCheckCast(r4.entrySet(), Iterable.class, "com.obric.memorydata.plugin"), r5), Map.Entry.class, "com.obric.memorydata.plugin");
    }

    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> minByOrNull(Map<? extends K, ? extends V> r6, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "selector");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r8.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r10.hasNext() == true) goto L5;
        Object r11 = null;
    L16:
        return (Map.Entry) ZeusTransformUtils.preCheckCast(r11, Map.Entry.class, "com.obric.memorydata.plugin");
    L5:
        Object r0 = r10.next();
        if (r10.hasNext() == true) goto L8;
    L7:
        r11 = r0;
        goto L16
    L8:
        Comparable r2 = (Comparable) ZeusTransformUtils.preCheckCast(r9.invoke(r0), Comparable.class, "com.obric.memorydata.plugin");
    L9:
        Object r3 = r10.next();
        Comparable r4 = (Comparable) ZeusTransformUtils.preCheckCast(r9.invoke(r3), Comparable.class, "com.obric.memorydata.plugin");
        if (r2.compareTo(r4) <= 0) goto L13;
        r0 = r3;
        r2 = r4;
    L13:
        if (r10.hasNext() == true) goto L9;
        goto L7
    }

    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> minByOrThrow(Map<? extends K, ? extends V> r6, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "selector");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r8.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r10.hasNext() == false) goto L16;
        Object r0 = r10.next();
        if (r10.hasNext() == false) goto L14;
        Comparable r2 = (Comparable) ZeusTransformUtils.preCheckCast(r9.invoke(r0), Comparable.class, "com.obric.memorydata.plugin");
    L8:
        Object r3 = r10.next();
        Comparable r4 = (Comparable) ZeusTransformUtils.preCheckCast(r9.invoke(r3), Comparable.class, "com.obric.memorydata.plugin");
        if (r2.compareTo(r4) <= 0) goto L12;
        r0 = r3;
        r2 = r4;
    L12:
        if (r10.hasNext() == true) goto L8;
    L14:
        return (Map.Entry) ZeusTransformUtils.preCheckCast(r0, Map.Entry.class, "com.obric.memorydata.plugin");
    L16:
        throw new NoSuchElementException();
    }

    private static final <K, V> double minOf(Map<? extends K, ? extends V> r6, Function1<? super Map.Entry<? extends K, ? extends V>, Double> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "selector");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r8.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r10.hasNext() == false) goto L10;
        double r2 = ((Number) ZeusTransformUtils.preCheckCast(r9.invoke(r10.next()), Number.class, "com.obric.memorydata.plugin")).doubleValue();
    L6:
        if (r10.hasNext() == false) goto L8;
        r2 = Math.min(r2, ((Number) ZeusTransformUtils.preCheckCast(r9.invoke(r10.next()), Number.class, "com.obric.memorydata.plugin")).doubleValue());
        goto L6
    L8:
        return r2;
    L10:
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <K, V> float m1872minOf(Map<? extends K, ? extends V> r4, Function1<? super Map.Entry<? extends K, ? extends V>, Float> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "selector");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r6.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r8.hasNext() == false) goto L10;
        float r0 = ((Number) ZeusTransformUtils.preCheckCast(r7.invoke(r8.next()), Number.class, "com.obric.memorydata.plugin")).floatValue();
    L6:
        if (r8.hasNext() == false) goto L8;
        r0 = Math.min(r0, ((Number) ZeusTransformUtils.preCheckCast(r7.invoke(r8.next()), Number.class, "com.obric.memorydata.plugin")).floatValue());
        goto L6
    L8:
        return r0;
    L10:
        throw new NoSuchElementException();
    }

    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <K, V, R extends Comparable<? super R>> R m1873minOf(Map<? extends K, ? extends V> r4, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "selector");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r6.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r8.hasNext() == false) goto L12;
        R r0 = (R) ZeusTransformUtils.preCheckCast(r7.invoke(r8.next()), Comparable.class, "com.obric.memorydata.plugin");
    L6:
        if (r8.hasNext() == false) goto L10;
        Comparable r2 = (Comparable) ZeusTransformUtils.preCheckCast(r7.invoke(r8.next()), Comparable.class, "com.obric.memorydata.plugin");
        if (r0.compareTo(r2) <= 0) goto L6;
        r0 = (R) r2;
        goto L6
    L10:
        return r0;
    L12:
        throw new NoSuchElementException();
    }

    private static final <K, V, R extends Comparable<? super R>> R minOfOrNull(Map<? extends K, ? extends V> r4, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "selector");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r6.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r8.hasNext() == true) goto L5;
        return null;
    L5:
        Comparable r0 = (Comparable) ZeusTransformUtils.preCheckCast(r7.invoke(r8.next()), Comparable.class, "com.obric.memorydata.plugin");
    L7:
        if (r8.hasNext() == false) goto L12;
        Comparable r2 = (Comparable) ZeusTransformUtils.preCheckCast(r7.invoke(r8.next()), Comparable.class, "com.obric.memorydata.plugin");
        if (r0.compareTo(r2) <= 0) goto L7;
        r0 = r2;
        goto L7
    L12:
        return (R) r0;
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final <K, V> Double m1874minOfOrNull(Map<? extends K, ? extends V> r6, Function1<? super Map.Entry<? extends K, ? extends V>, Double> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "selector");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r8.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r10.hasNext() == true) goto L5;
        return null;
    L5:
        double r2 = ((Number) ZeusTransformUtils.preCheckCast(r9.invoke(r10.next()), Number.class, "com.obric.memorydata.plugin")).doubleValue();
    L7:
        if (r10.hasNext() == false) goto L10;
        r2 = Math.min(r2, ((Number) ZeusTransformUtils.preCheckCast(r9.invoke(r10.next()), Number.class, "com.obric.memorydata.plugin")).doubleValue());
        goto L7
    L10:
        return Double.valueOf(r2);
    }

    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final <K, V> Float m1875minOfOrNull(Map<? extends K, ? extends V> r4, Function1<? super Map.Entry<? extends K, ? extends V>, Float> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "selector");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r6.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r8.hasNext() == true) goto L5;
        return null;
    L5:
        float r0 = ((Number) ZeusTransformUtils.preCheckCast(r7.invoke(r8.next()), Number.class, "com.obric.memorydata.plugin")).floatValue();
    L7:
        if (r8.hasNext() == false) goto L10;
        r0 = Math.min(r0, ((Number) ZeusTransformUtils.preCheckCast(r7.invoke(r8.next()), Number.class, "com.obric.memorydata.plugin")).floatValue());
        goto L7
    L10:
        return Float.valueOf(r0);
    }

    private static final <K, V, R> R minOfWith(Map<? extends K, ? extends V> r3, Comparator<? super R> r4, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Comparator r7 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r4, Comparator.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "comparator");
        Intrinsics.checkNotNullParameter(r8, "selector");
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r6.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r9.hasNext() == false) goto L12;
        R r0 = (R) r8.invoke(r9.next());
    L6:
        if (r9.hasNext() == false) goto L10;
        Object r1 = r8.invoke(r9.next());
        if (r7.compare(r0, r1) <= 0) goto L6;
        r0 = (R) r1;
        goto L6
    L10:
        return r0;
    L12:
        throw new NoSuchElementException();
    }

    private static final <K, V, R> R minOfWithOrNull(Map<? extends K, ? extends V> r3, Comparator<? super R> r4, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Comparator r7 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r4, Comparator.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "comparator");
        Intrinsics.checkNotNullParameter(r8, "selector");
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r6.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r9.hasNext() == true) goto L5;
        return null;
    L5:
        Object r0 = r8.invoke(r9.next());
    L7:
        if (r9.hasNext() == false) goto L12;
        Object r1 = r8.invoke(r9.next());
        if (r7.compare(r0, r1) <= 0) goto L7;
        r0 = r1;
        goto L7
    L12:
        return (R) r0;
    }

    private static final <K, V> Map.Entry<K, V> minWithOrNull(Map<? extends K, ? extends V> r2, Comparator<? super Map.Entry<? extends K, ? extends V>> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Comparator r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "comparator");
        return (Map.Entry) ZeusTransformUtils.preCheckCast(CollectionsKt.minWithOrNull((Iterable) ZeusTransformUtils.preCheckCast(r4.entrySet(), Iterable.class, "com.obric.memorydata.plugin"), r5), Map.Entry.class, "com.obric.memorydata.plugin");
    }

    private static final <K, V> Map.Entry<K, V> minWithOrThrow(Map<? extends K, ? extends V> r2, Comparator<? super Map.Entry<? extends K, ? extends V>> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Comparator r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "comparator");
        return (Map.Entry) ZeusTransformUtils.preCheckCast(CollectionsKt.minWithOrThrow((Iterable) ZeusTransformUtils.preCheckCast(r4.entrySet(), Iterable.class, "com.obric.memorydata.plugin"), r5), Map.Entry.class, "com.obric.memorydata.plugin");
    }

    public static final <K, V> boolean none(Map<? extends K, ? extends V> r2) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return r3.isEmpty();
    }

    public static final <K, V> boolean none(Map<? extends K, ? extends V> r4, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "predicate");
        if (r6.isEmpty() == false) goto L5;
        return true;
    L5:
        Iterator<Map.Entry<K, V>> r8 = r6.entrySet().iterator();
    L7:
        if (r8.hasNext() == false) goto L12;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r7.invoke((Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin")), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L7;
        return false;
    L12:
        return true;
    }

    public static final <K, V, M extends Map<? extends K, ? extends V>> M onEach(M r4, Function1<? super Map.Entry<? extends K, ? extends V>, Unit> r5) {
        M r6 = (M) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "action");
        Iterator<Map.Entry<K, V>> r0 = r6.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r7.invoke((Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        return r6;
    }

    public static final <K, V, M extends Map<? extends K, ? extends V>> M onEachIndexed(M r4, Function2<? super Integer, ? super Map.Entry<? extends K, ? extends V>, Unit> r5) {
        M r6 = (M) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Function2 r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "action");
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r6.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        Object r2 = r0.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r7.invoke(Integer.valueOf(r1), r2);
        r1 = r3;
        goto L4
    L9:
        return r6;
    }

    public static final <K, V> List<Pair<K, V>> toList(Map<? extends K, ? extends V> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        if (r6.size() == 0) goto L5;
        Iterator<Map.Entry<K, V>> r0 = r6.entrySet().iterator();
        if (r0.hasNext() == false) goto L9;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r0.hasNext() == false) goto L13;
        ArrayList r3 = new ArrayList(r6.size());
        r3.add(new Pair(r2.getKey(), r2.getValue()));
    L15:
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r3.add(new Pair(r7.getKey(), r7.getValue()));
        if (r0.hasNext() == true) goto L15;
        return (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
    L13:
        return CollectionsKt.listOf(new Pair(r2.getKey(), r2.getValue()));
    L9:
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.emptyList();
    }
}
