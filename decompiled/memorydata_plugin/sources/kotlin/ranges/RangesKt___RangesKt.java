package kotlin.ranges;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000t\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001d\u001a'\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005\u001a\u0012\u0010\u0000\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006\u001a\u0012\u0010\u0000\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0007\u001a\u0012\u0010\u0000\u001a\u00020\b*\u00020\b2\u0006\u0010\u0003\u001a\u00020\b\u001a\u0012\u0010\u0000\u001a\u00020\t*\u00020\t2\u0006\u0010\u0003\u001a\u00020\t\u001a\u0012\u0010\u0000\u001a\u00020\n*\u00020\n2\u0006\u0010\u0003\u001a\u00020\n\u001a'\u0010\u000b\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\u0006\u0010\f\u001a\u0002H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0012\u0010\u000b\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005\u001a\u0012\u0010\u000b\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006\u001a\u0012\u0010\u000b\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007\u001a\u0012\u0010\u000b\u001a\u00020\b*\u00020\b2\u0006\u0010\f\u001a\u00020\b\u001a\u0012\u0010\u000b\u001a\u00020\t*\u00020\t2\u0006\u0010\f\u001a\u00020\t\u001a\u0012\u0010\u000b\u001a\u00020\n*\u00020\n2\u0006\u0010\f\u001a\u00020\n\u001a3\u0010\r\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\b\u0010\u0003\u001a\u0004\u0018\u0001H\u00012\b\u0010\f\u001a\u0004\u0018\u0001H\u0001¢\u0006\u0002\u0010\u000e\u001a/\u0010\r\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001a-\u0010\r\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0012¢\u0006\u0002\u0010\u0013\u001a\u001a\u0010\r\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005\u001a\u001a\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006\u001a\u001a\u0010\r\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007\u001a\u001a\u0010\r\u001a\u00020\b*\u00020\b2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b\u001a\u0018\u0010\r\u001a\u00020\b*\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0012\u001a\u001a\u0010\r\u001a\u00020\t*\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t\u001a\u0018\u0010\r\u001a\u00020\t*\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0012\u001a\u001a\u0010\r\u001a\u00020\n*\u00020\n2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0087\n¢\u0006\u0002\u0010\u0019\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b \u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020!2\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\n\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020!2\b\u0010\u0017\u001a\u0004\u0018\u00010\bH\u0087\n¢\u0006\u0002\u0010\"\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020!2\u0006\u0010\u001a\u001a\u00020\tH\u0087\n\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020!2\u0006\u0010\u001a\u001a\u00020\nH\u0087\n\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020#2\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\n\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020#2\u0006\u0010\u001a\u001a\u00020\bH\u0087\n\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020#2\b\u0010\u0017\u001a\u0004\u0018\u00010\tH\u0087\n¢\u0006\u0002\u0010$\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020#2\u0006\u0010\u001a\u001a\u00020\nH\u0087\n\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060%2\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0%2\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0%2\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0%2\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0%2\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0%2\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0%2\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0%2\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0%2\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0%2\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b \u001a\u0015\u0010&\u001a\u00020'*\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\u00052\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\u00052\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\u00052\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020**\u00020\u00182\u0006\u0010(\u001a\u00020\u0018H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\b2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\b2\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\b2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\b2\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\t2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\t2\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\t2\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\n2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\n2\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\n2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\f\u0010+\u001a\u00020\u0018*\u00020*H\u0007\u001a\f\u0010+\u001a\u00020\b*\u00020'H\u0007\u001a\f\u0010+\u001a\u00020\t*\u00020)H\u0007\u001a\u0013\u0010,\u001a\u0004\u0018\u00010\u0018*\u00020*H\u0007¢\u0006\u0002\u0010-\u001a\u0013\u0010,\u001a\u0004\u0018\u00010\b*\u00020'H\u0007¢\u0006\u0002\u0010.\u001a\u0013\u0010,\u001a\u0004\u0018\u00010\t*\u00020)H\u0007¢\u0006\u0002\u0010/\u001a\f\u00100\u001a\u00020\u0018*\u00020*H\u0007\u001a\f\u00100\u001a\u00020\b*\u00020'H\u0007\u001a\f\u00100\u001a\u00020\t*\u00020)H\u0007\u001a\u0013\u00101\u001a\u0004\u0018\u00010\u0018*\u00020*H\u0007¢\u0006\u0002\u0010-\u001a\u0013\u00101\u001a\u0004\u0018\u00010\b*\u00020'H\u0007¢\u0006\u0002\u0010.\u001a\u0013\u00101\u001a\u0004\u0018\u00010\t*\u00020)H\u0007¢\u0006\u0002\u0010/\u001a\r\u00102\u001a\u00020\u0018*\u00020\u0016H\u0087\b\u001a\u0014\u00102\u001a\u00020\u0018*\u00020\u00162\u0006\u00102\u001a\u000203H\u0007\u001a\r\u00102\u001a\u00020\b*\u00020!H\u0087\b\u001a\u0014\u00102\u001a\u00020\b*\u00020!2\u0006\u00102\u001a\u000203H\u0007\u001a\r\u00102\u001a\u00020\t*\u00020#H\u0087\b\u001a\u0014\u00102\u001a\u00020\t*\u00020#2\u0006\u00102\u001a\u000203H\u0007\u001a\u0014\u00104\u001a\u0004\u0018\u00010\u0018*\u00020\u0016H\u0087\b¢\u0006\u0002\u00105\u001a\u001b\u00104\u001a\u0004\u0018\u00010\u0018*\u00020\u00162\u0006\u00102\u001a\u000203H\u0007¢\u0006\u0002\u00106\u001a\u0014\u00104\u001a\u0004\u0018\u00010\b*\u00020!H\u0087\b¢\u0006\u0002\u00107\u001a\u001b\u00104\u001a\u0004\u0018\u00010\b*\u00020!2\u0006\u00102\u001a\u000203H\u0007¢\u0006\u0002\u00108\u001a\u0014\u00104\u001a\u0004\u0018\u00010\t*\u00020#H\u0087\b¢\u0006\u0002\u00109\u001a\u001b\u00104\u001a\u0004\u0018\u00010\t*\u00020#2\u0006\u00102\u001a\u000203H\u0007¢\u0006\u0002\u0010:\u001a\n\u0010;\u001a\u00020**\u00020*\u001a\n\u0010;\u001a\u00020'*\u00020'\u001a\n\u0010;\u001a\u00020)*\u00020)\u001a\u0015\u0010<\u001a\u00020**\u00020*2\u0006\u0010<\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010<\u001a\u00020'*\u00020'2\u0006\u0010<\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010<\u001a\u00020)*\u00020)2\u0006\u0010<\u001a\u00020\tH\u0086\u0004\u001a\u0013\u0010=\u001a\u0004\u0018\u00010\u0005*\u00020\u0006H\u0000¢\u0006\u0002\u0010>\u001a\u0013\u0010=\u001a\u0004\u0018\u00010\u0005*\u00020\u0007H\u0000¢\u0006\u0002\u0010?\u001a\u0013\u0010=\u001a\u0004\u0018\u00010\u0005*\u00020\bH\u0000¢\u0006\u0002\u0010@\u001a\u0013\u0010=\u001a\u0004\u0018\u00010\u0005*\u00020\tH\u0000¢\u0006\u0002\u0010A\u001a\u0013\u0010=\u001a\u0004\u0018\u00010\u0005*\u00020\nH\u0000¢\u0006\u0002\u0010B\u001a\u0013\u0010C\u001a\u0004\u0018\u00010\b*\u00020\u0006H\u0000¢\u0006\u0002\u0010D\u001a\u0013\u0010C\u001a\u0004\u0018\u00010\b*\u00020\u0007H\u0000¢\u0006\u0002\u0010E\u001a\u0013\u0010C\u001a\u0004\u0018\u00010\b*\u00020\tH\u0000¢\u0006\u0002\u0010F\u001a\u0013\u0010G\u001a\u0004\u0018\u00010\t*\u00020\u0006H\u0000¢\u0006\u0002\u0010H\u001a\u0013\u0010G\u001a\u0004\u0018\u00010\t*\u00020\u0007H\u0000¢\u0006\u0002\u0010I\u001a\u0013\u0010J\u001a\u0004\u0018\u00010\n*\u00020\u0006H\u0000¢\u0006\u0002\u0010K\u001a\u0013\u0010J\u001a\u0004\u0018\u00010\n*\u00020\u0007H\u0000¢\u0006\u0002\u0010L\u001a\u0013\u0010J\u001a\u0004\u0018\u00010\n*\u00020\bH\u0000¢\u0006\u0002\u0010M\u001a\u0013\u0010J\u001a\u0004\u0018\u00010\n*\u00020\tH\u0000¢\u0006\u0002\u0010N\u001a\u0015\u0010O\u001a\u00020!*\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010O\u001a\u00020!*\u00020\u00052\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020#*\u00020\u00052\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020!*\u00020\u00052\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020\u0016*\u00020\u00182\u0006\u0010(\u001a\u00020\u0018H\u0086\u0004\u001a\u0015\u0010O\u001a\u00020!*\u00020\b2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010O\u001a\u00020!*\u00020\b2\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020#*\u00020\b2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020!*\u00020\b2\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010O\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020!*\u00020\n2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010O\u001a\u00020!*\u00020\n2\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020#*\u00020\n2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020!*\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0086\u0004¨\u0006P"}, d2 = {"coerceAtLeast", ExifInterface.GPS_DIRECTION_TRUE, "", "minimumValue", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "coerceAtMost", "maximumValue", "coerceIn", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "range", "Lkotlin/ranges/ClosedFloatingPointRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "Lkotlin/ranges/ClosedRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedRange;)Ljava/lang/Comparable;", "contains", "", "Lkotlin/ranges/CharRange;", "element", "", "(Lkotlin/ranges/CharRange;Ljava/lang/Character;)Z", EventBody.KEY_VALUE, "byteRangeContains", "doubleRangeContains", "floatRangeContains", "intRangeContains", "longRangeContains", "shortRangeContains", "Lkotlin/ranges/IntRange;", "(Lkotlin/ranges/IntRange;Ljava/lang/Integer;)Z", "Lkotlin/ranges/LongRange;", "(Lkotlin/ranges/LongRange;Ljava/lang/Long;)Z", "Lkotlin/ranges/OpenEndRange;", "downTo", "Lkotlin/ranges/IntProgression;", TypedValues.TransitionType.S_TO, "Lkotlin/ranges/LongProgression;", "Lkotlin/ranges/CharProgression;", "first", "firstOrNull", "(Lkotlin/ranges/CharProgression;)Ljava/lang/Character;", "(Lkotlin/ranges/IntProgression;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongProgression;)Ljava/lang/Long;", "last", "lastOrNull", "random", "Lkotlin/random/Random;", "randomOrNull", "(Lkotlin/ranges/CharRange;)Ljava/lang/Character;", "(Lkotlin/ranges/CharRange;Lkotlin/random/Random;)Ljava/lang/Character;", "(Lkotlin/ranges/IntRange;)Ljava/lang/Integer;", "(Lkotlin/ranges/IntRange;Lkotlin/random/Random;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongRange;)Ljava/lang/Long;", "(Lkotlin/ranges/LongRange;Lkotlin/random/Random;)Ljava/lang/Long;", "reversed", "step", "toByteExactOrNull", "(D)Ljava/lang/Byte;", "(F)Ljava/lang/Byte;", "(I)Ljava/lang/Byte;", "(J)Ljava/lang/Byte;", "(S)Ljava/lang/Byte;", "toIntExactOrNull", "(D)Ljava/lang/Integer;", "(F)Ljava/lang/Integer;", "(J)Ljava/lang/Integer;", "toLongExactOrNull", "(D)Ljava/lang/Long;", "(F)Ljava/lang/Long;", "toShortExactOrNull", "(D)Ljava/lang/Short;", "(F)Ljava/lang/Short;", "(I)Ljava/lang/Short;", "(J)Ljava/lang/Short;", "until", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/ranges/RangesKt")
class RangesKt___RangesKt extends RangesKt__RangesKt {
    public RangesKt___RangesKt() {
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean byteRangeContains(ClosedRange r2, double r3) {
        ClosedRange r4 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r2, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Byte r5 = RangesKt.toByteExactOrNull(r3);
        if (r5 != null) goto L7;
        return false;
    L7:
        return r4.contains((Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean byteRangeContains(ClosedRange r2, float r3) {
        ClosedRange r4 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r2, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Byte r5 = RangesKt.toByteExactOrNull(r3);
        if (r5 != null) goto L7;
        return false;
    L7:
        return r4.contains((Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin"));
    }

    public static final boolean byteRangeContains(ClosedRange<Byte> r2, int r3) {
        ClosedRange r4 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r2, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Byte r5 = RangesKt.toByteExactOrNull(r3);
        if (r5 != null) goto L7;
        return false;
    L7:
        return r4.contains((Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin"));
    }

    public static final boolean byteRangeContains(ClosedRange<Byte> r2, long r3) {
        ClosedRange r4 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r2, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Byte r5 = RangesKt.toByteExactOrNull(r3);
        if (r5 != null) goto L7;
        return false;
    L7:
        return r4.contains((Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin"));
    }

    public static final boolean byteRangeContains(ClosedRange<Byte> r2, short r3) {
        ClosedRange r4 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r2, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Byte r5 = RangesKt.toByteExactOrNull(r3);
        if (r5 != null) goto L7;
        return false;
    L7:
        return r4.contains((Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin"));
    }

    public static final boolean byteRangeContains(OpenEndRange<Byte> r2, int r3) {
        OpenEndRange r4 = (OpenEndRange) ZeusTransformUtils.wrapperContextForParams(r2, OpenEndRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Byte r5 = RangesKt.toByteExactOrNull(r3);
        if (r5 != null) goto L7;
        return false;
    L7:
        return r4.contains((Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin"));
    }

    public static final boolean byteRangeContains(OpenEndRange<Byte> r2, long r3) {
        OpenEndRange r4 = (OpenEndRange) ZeusTransformUtils.wrapperContextForParams(r2, OpenEndRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Byte r5 = RangesKt.toByteExactOrNull(r3);
        if (r5 != null) goto L7;
        return false;
    L7:
        return r4.contains((Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin"));
    }

    public static final boolean byteRangeContains(OpenEndRange<Byte> r2, short r3) {
        OpenEndRange r4 = (OpenEndRange) ZeusTransformUtils.wrapperContextForParams(r2, OpenEndRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Byte r5 = RangesKt.toByteExactOrNull(r3);
        if (r5 != null) goto L7;
        return false;
    L7:
        return r4.contains((Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin"));
    }

    public static final byte coerceAtLeast(byte r0, byte r1) {
        if (r0 < r1) goto L4;
        return r0;
    L4:
        return r1;
    }

    public static final double coerceAtLeast(double r1, double r3) {
        if (r1 < r3) goto L5;
        return r1;
    L5:
        return r3;
    }

    public static final float coerceAtLeast(float r1, float r2) {
        if (r1 < r2) goto L5;
        return r1;
    L5:
        return r2;
    }

    public static final int coerceAtLeast(int r0, int r1) {
        if (r0 < r1) goto L4;
        return r0;
    L4:
        return r1;
    }

    public static final long coerceAtLeast(long r1, long r3) {
        if (r1 < r3) goto L5;
        return r1;
    L5:
        return r3;
    }

    public static final <T extends Comparable<? super T>> T coerceAtLeast(T r2, T r3) {
        T r4 = (T) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
        T r5 = (T) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "minimumValue");
        if (r4.compareTo(r5) < 0) goto L5;
        return r4;
    L5:
        return r5;
    }

    public static final short coerceAtLeast(short r0, short r1) {
        if (r0 < r1) goto L4;
        return r0;
    L4:
        return r1;
    }

    public static final byte coerceAtMost(byte r0, byte r1) {
        if (r0 > r1) goto L4;
        return r0;
    L4:
        return r1;
    }

    public static final double coerceAtMost(double r1, double r3) {
        if (r1 > r3) goto L5;
        return r1;
    L5:
        return r3;
    }

    public static final float coerceAtMost(float r1, float r2) {
        if (r1 > r2) goto L5;
        return r1;
    L5:
        return r2;
    }

    public static final int coerceAtMost(int r0, int r1) {
        if (r0 > r1) goto L4;
        return r0;
    L4:
        return r1;
    }

    public static final long coerceAtMost(long r1, long r3) {
        if (r1 > r3) goto L5;
        return r1;
    L5:
        return r3;
    }

    public static final <T extends Comparable<? super T>> T coerceAtMost(T r2, T r3) {
        T r4 = (T) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
        T r5 = (T) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "maximumValue");
        if (r4.compareTo(r5) > 0) goto L5;
        return r4;
    L5:
        return r5;
    }

    public static final short coerceAtMost(short r0, short r1) {
        if (r0 > r1) goto L4;
        return r0;
    L4:
        return r1;
    }

    public static final byte coerceIn(byte r2, byte r3, byte r4) {
        if (r3 > r4) goto L9;
        if (r2 >= r3) goto L5;
        return r3;
    L5:
        if (r2 <= r4) goto L7;
        return r4;
    L7:
        return r2;
    L9:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r4 + " is less than minimum " + r3 + '.');
    }

    public static final double coerceIn(double r1, double r3, double r5) {
        if (r3 > r5) goto L12;
        if (r1 >= r3) goto L8;
        return r3;
    L8:
        if (r1 <= r5) goto L10;
        return r5;
    L10:
        return r1;
    L12:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r5 + " is less than minimum " + r3 + '.');
    }

    public static final float coerceIn(float r2, float r3, float r4) {
        if (r3 > r4) goto L12;
        if (r2 >= r3) goto L8;
        return r3;
    L8:
        if (r2 <= r4) goto L10;
        return r4;
    L10:
        return r2;
    L12:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r4 + " is less than minimum " + r3 + '.');
    }

    public static final int coerceIn(int r2, int r3, int r4) {
        if (r3 > r4) goto L9;
        if (r2 >= r3) goto L5;
        return r3;
    L5:
        if (r2 <= r4) goto L7;
        return r4;
    L7:
        return r2;
    L9:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r4 + " is less than minimum " + r3 + '.');
    }

    public static final int coerceIn(int r3, ClosedRange<Integer> r4) {
        ClosedRange r5 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r4, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "range");
        if (ZeusTransformUtils.instanceOf(r5, ClosedFloatingPointRange.class) == false) goto L7;
        return ((Number) ZeusTransformUtils.preCheckCast(RangesKt.coerceIn((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(r3), Comparable.class, "com.obric.memorydata.plugin"), (ClosedFloatingPointRange) ZeusTransformUtils.preCheckCast(r5, ClosedFloatingPointRange.class, "com.obric.memorydata.plugin")), Number.class, "com.obric.memorydata.plugin")).intValue();
    L7:
        if (r5.isEmpty() == true) goto L17;
        if (r3 >= ((Number) ZeusTransformUtils.preCheckCast(r5.getStart(), Number.class, "com.obric.memorydata.plugin")).intValue()) goto L13;
        Comparable r6 = r5.getStart();
    L15:
        return ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).intValue();
    L13:
        if (r3 <= ((Number) ZeusTransformUtils.preCheckCast(r5.getEndInclusive(), Number.class, "com.obric.memorydata.plugin")).intValue()) goto L18;
        r6 = r5.getEndInclusive();
        goto L15
    L18:
        return r3;
    L17:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + r5 + '.');
    }

    public static final long coerceIn(long r1, long r3, long r5) {
        if (r3 > r5) goto L12;
        if (r1 >= r3) goto L8;
        return r3;
    L8:
        if (r1 <= r5) goto L10;
        return r5;
    L10:
        return r1;
    L12:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r5 + " is less than minimum " + r3 + '.');
    }

    public static final long coerceIn(long r4, ClosedRange<Long> r6) {
        ClosedRange r7 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r6, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "range");
        if (ZeusTransformUtils.instanceOf(r7, ClosedFloatingPointRange.class) == false) goto L7;
        return ((Number) ZeusTransformUtils.preCheckCast(RangesKt.coerceIn((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(r4), Comparable.class, "com.obric.memorydata.plugin"), (ClosedFloatingPointRange) ZeusTransformUtils.preCheckCast(r7, ClosedFloatingPointRange.class, "com.obric.memorydata.plugin")), Number.class, "com.obric.memorydata.plugin")).longValue();
    L7:
        if (r7.isEmpty() == true) goto L17;
        if (r4 >= ((Number) ZeusTransformUtils.preCheckCast(r7.getStart(), Number.class, "com.obric.memorydata.plugin")).longValue()) goto L13;
        Comparable r5 = r7.getStart();
    L15:
        return ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).longValue();
    L13:
        if (r4 <= ((Number) ZeusTransformUtils.preCheckCast(r7.getEndInclusive(), Number.class, "com.obric.memorydata.plugin")).longValue()) goto L18;
        r5 = r7.getEndInclusive();
        goto L15
    L18:
        return r4;
    L17:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + r7 + '.');
    }

    public static final <T extends Comparable<? super T>> T coerceIn(T r2, T r3, T r4) {
        T r5 = (T) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
        T r6 = (T) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        T r7 = (T) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r6 == null) goto L15;
        if (r7 == null) goto L15;
        if (r6.compareTo(r7) > 0) goto L14;
        if (r5.compareTo(r6) >= 0) goto L11;
        return r6;
    L11:
        if (r5.compareTo(r7) <= 0) goto L23;
        return r7;
    L23:
        return r5;
    L14:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r7 + " is less than minimum " + r6 + '.');
    L15:
        if (r6 != null) goto L17;
    L19:
        if (r7 == null) goto L23;
        if (r5.compareTo(r7) <= 0) goto L23;
        return r7;
    L17:
        if (r5.compareTo(r6) >= 0) goto L19;
        return r6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T extends Comparable<? super T>> T coerceIn(T r2, ClosedFloatingPointRange<T> r3) {
        T r4 = (T) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
        ClosedFloatingPointRange r5 = (ClosedFloatingPointRange) ZeusTransformUtils.wrapperContextForParams(r3, ClosedFloatingPointRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "range");
        if (r5.isEmpty() == true) goto L16;
        if (r5.lessThanOrEquals(r4, r5.getStart()) == false) goto L10;
        if (r5.lessThanOrEquals(r5.getStart(), r4) == true) goto L10;
        return (T) r5.getStart();
    L10:
        if (r5.lessThanOrEquals(r5.getEndInclusive(), r4) == true) goto L12;
        return r4;
    L12:
        if (r5.lessThanOrEquals(r4, r5.getEndInclusive()) == false) goto L14;
        return r4;
    L14:
        return (T) r5.getEndInclusive();
    L16:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + r5 + '.');
    }

    public static final <T extends Comparable<? super T>> T coerceIn(T r2, ClosedRange<T> r3) {
        T r4 = (T) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
        ClosedRange r5 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r3, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "range");
        if (ZeusTransformUtils.instanceOf(r5, ClosedFloatingPointRange.class) == false) goto L7;
        return (T) RangesKt.coerceIn(r4, (ClosedFloatingPointRange) ZeusTransformUtils.preCheckCast(r5, ClosedFloatingPointRange.class, "com.obric.memorydata.plugin"));
    L7:
        if (r5.isEmpty() == true) goto L16;
        if (r4.compareTo(r5.getStart()) >= 0) goto L12;
        return (T) r5.getStart();
    L12:
        if (r4.compareTo(r5.getEndInclusive()) > 0) goto L14;
        return r4;
    L14:
        return (T) r5.getEndInclusive();
    L16:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + r5 + '.');
    }

    public static final short coerceIn(short r2, short r3, short r4) {
        if (r3 > r4) goto L9;
        if (r2 >= r3) goto L5;
        return r3;
    L5:
        if (r2 <= r4) goto L7;
        return r4;
    L7:
        return r2;
    L9:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r4 + " is less than minimum " + r3 + '.');
    }

    private static final boolean contains(CharRange r1, Character r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.contains(r2.charValue()) == false) goto L7;
        return true;
    }

    private static final boolean contains(IntRange r2, byte r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return RangesKt.intRangeContains((ClosedRange) ZeusTransformUtils.preCheckCast(r2, ClosedRange.class, "com.obric.memorydata.plugin"), r3);
    }

    private static final boolean contains(IntRange r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return RangesKt.intRangeContains((ClosedRange) ZeusTransformUtils.preCheckCast(r2, ClosedRange.class, "com.obric.memorydata.plugin"), r3);
    }

    private static final boolean contains(IntRange r1, Integer r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.contains(r2.intValue()) == false) goto L7;
        return true;
    }

    private static final boolean contains(IntRange r2, short r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return RangesKt.intRangeContains((ClosedRange) ZeusTransformUtils.preCheckCast(r2, ClosedRange.class, "com.obric.memorydata.plugin"), r3);
    }

    private static final boolean contains(LongRange r2, byte r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return RangesKt.longRangeContains((ClosedRange) ZeusTransformUtils.preCheckCast(r2, ClosedRange.class, "com.obric.memorydata.plugin"), r3);
    }

    private static final boolean contains(LongRange r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return RangesKt.longRangeContains((ClosedRange) ZeusTransformUtils.preCheckCast(r2, ClosedRange.class, "com.obric.memorydata.plugin"), r3);
    }

    private static final boolean contains(LongRange r2, Long r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.contains(r3.longValue()) == false) goto L7;
        return true;
    }

    private static final boolean contains(LongRange r2, short r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return RangesKt.longRangeContains((ClosedRange) ZeusTransformUtils.preCheckCast(r2, ClosedRange.class, "com.obric.memorydata.plugin"), r3);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean doubleRangeContains(ClosedRange r4, byte r5) {
        ClosedRange r6 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r4, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        return r6.contains((Comparable) ZeusTransformUtils.preCheckCast(Double.valueOf(r5), Comparable.class, "com.obric.memorydata.plugin"));
    }

    public static final boolean doubleRangeContains(ClosedRange<Double> r4, float r5) {
        ClosedRange r6 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r4, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        return r6.contains((Comparable) ZeusTransformUtils.preCheckCast(Double.valueOf(r5), Comparable.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean doubleRangeContains(ClosedRange r4, int r5) {
        ClosedRange r6 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r4, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        return r6.contains((Comparable) ZeusTransformUtils.preCheckCast(Double.valueOf(r5), Comparable.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean doubleRangeContains(ClosedRange r2, long r3) {
        ClosedRange r4 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r2, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return r4.contains((Comparable) ZeusTransformUtils.preCheckCast(Double.valueOf(r3), Comparable.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean doubleRangeContains(ClosedRange r4, short r5) {
        ClosedRange r6 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r4, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        return r6.contains((Comparable) ZeusTransformUtils.preCheckCast(Double.valueOf(r5), Comparable.class, "com.obric.memorydata.plugin"));
    }

    public static final boolean doubleRangeContains(OpenEndRange<Double> r4, float r5) {
        OpenEndRange r6 = (OpenEndRange) ZeusTransformUtils.wrapperContextForParams(r4, OpenEndRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        return r6.contains((Comparable) ZeusTransformUtils.preCheckCast(Double.valueOf(r5), Comparable.class, "com.obric.memorydata.plugin"));
    }

    public static final CharProgression downTo(char r2, char r3) {
        return CharProgression.Companion.fromClosedRange(r2, r3, -1);
    }

    public static final IntProgression downTo(byte r2, byte r3) {
        return IntProgression.Companion.fromClosedRange(r2, r3, -1);
    }

    public static final IntProgression downTo(byte r2, int r3) {
        return IntProgression.Companion.fromClosedRange(r2, r3, -1);
    }

    public static final IntProgression downTo(byte r2, short r3) {
        return IntProgression.Companion.fromClosedRange(r2, r3, -1);
    }

    public static final IntProgression downTo(int r2, byte r3) {
        return IntProgression.Companion.fromClosedRange(r2, r3, -1);
    }

    public static final IntProgression downTo(int r2, int r3) {
        return IntProgression.Companion.fromClosedRange(r2, r3, -1);
    }

    public static final IntProgression downTo(int r2, short r3) {
        return IntProgression.Companion.fromClosedRange(r2, r3, -1);
    }

    public static final IntProgression downTo(short r2, byte r3) {
        return IntProgression.Companion.fromClosedRange(r2, r3, -1);
    }

    public static final IntProgression downTo(short r2, int r3) {
        return IntProgression.Companion.fromClosedRange(r2, r3, -1);
    }

    public static final IntProgression downTo(short r2, short r3) {
        return IntProgression.Companion.fromClosedRange(r2, r3, -1);
    }

    public static final LongProgression downTo(byte r7, long r8) {
        return LongProgression.Companion.fromClosedRange(r7, r8, -1);
    }

    public static final LongProgression downTo(int r7, long r8) {
        return LongProgression.Companion.fromClosedRange(r7, r8, -1);
    }

    public static final LongProgression downTo(long r7, byte r9) {
        return LongProgression.Companion.fromClosedRange(r7, r9, -1);
    }

    public static final LongProgression downTo(long r7, int r9) {
        return LongProgression.Companion.fromClosedRange(r7, r9, -1);
    }

    public static final LongProgression downTo(long r7, long r9) {
        return LongProgression.Companion.fromClosedRange(r7, r9, -1);
    }

    public static final LongProgression downTo(long r7, short r9) {
        return LongProgression.Companion.fromClosedRange(r7, r9, -1);
    }

    public static final LongProgression downTo(short r7, long r8) {
        return LongProgression.Companion.fromClosedRange(r7, r8, -1);
    }

    public static final char first(CharProgression r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r3.isEmpty() == true) goto L7;
        return r3.getFirst();
    L7:
        throw new NoSuchElementException("Progression " + r3 + " is empty.");
    }

    public static final int first(IntProgression r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r3.isEmpty() == true) goto L7;
        return r3.getFirst();
    L7:
        throw new NoSuchElementException("Progression " + r3 + " is empty.");
    }

    public static final long first(LongProgression r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r3.isEmpty() == true) goto L7;
        return r3.getFirst();
    L7:
        throw new NoSuchElementException("Progression " + r3 + " is empty.");
    }

    public static final Character firstOrNull(CharProgression r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.isEmpty() == false) goto L6;
        return null;
    L6:
        return Character.valueOf(r1.getFirst());
    }

    public static final Integer firstOrNull(IntProgression r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.isEmpty() == false) goto L6;
        return null;
    L6:
        return Integer.valueOf(r1.getFirst());
    }

    public static final Long firstOrNull(LongProgression r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.isEmpty() == false) goto L6;
        return null;
    L6:
        return Long.valueOf(r2.getFirst());
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean floatRangeContains(ClosedRange r2, byte r3) {
        ClosedRange r4 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r2, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return r4.contains((Comparable) ZeusTransformUtils.preCheckCast(Float.valueOf(r3), Comparable.class, "com.obric.memorydata.plugin"));
    }

    public static final boolean floatRangeContains(ClosedRange<Float> r2, double r3) {
        ClosedRange r4 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r2, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return r4.contains((Comparable) ZeusTransformUtils.preCheckCast(Float.valueOf((float) r3), Comparable.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean floatRangeContains(ClosedRange r2, int r3) {
        ClosedRange r4 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r2, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return r4.contains((Comparable) ZeusTransformUtils.preCheckCast(Float.valueOf(r3), Comparable.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean floatRangeContains(ClosedRange r2, long r3) {
        ClosedRange r4 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r2, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return r4.contains((Comparable) ZeusTransformUtils.preCheckCast(Float.valueOf(r3), Comparable.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean floatRangeContains(ClosedRange r2, short r3) {
        ClosedRange r4 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r2, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return r4.contains((Comparable) ZeusTransformUtils.preCheckCast(Float.valueOf(r3), Comparable.class, "com.obric.memorydata.plugin"));
    }

    public static final boolean intRangeContains(ClosedRange<Integer> r2, byte r3) {
        ClosedRange r4 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r2, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return r4.contains((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(r3), Comparable.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean intRangeContains(ClosedRange r2, double r3) {
        ClosedRange r4 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r2, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Integer r5 = RangesKt.toIntExactOrNull(r3);
        if (r5 != null) goto L7;
        return false;
    L7:
        return r4.contains((Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean intRangeContains(ClosedRange r2, float r3) {
        ClosedRange r4 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r2, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Integer r5 = RangesKt.toIntExactOrNull(r3);
        if (r5 != null) goto L7;
        return false;
    L7:
        return r4.contains((Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin"));
    }

    public static final boolean intRangeContains(ClosedRange<Integer> r2, long r3) {
        ClosedRange r4 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r2, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Integer r5 = RangesKt.toIntExactOrNull(r3);
        if (r5 != null) goto L7;
        return false;
    L7:
        return r4.contains((Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin"));
    }

    public static final boolean intRangeContains(ClosedRange<Integer> r2, short r3) {
        ClosedRange r4 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r2, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return r4.contains((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(r3), Comparable.class, "com.obric.memorydata.plugin"));
    }

    public static final boolean intRangeContains(OpenEndRange<Integer> r2, byte r3) {
        OpenEndRange r4 = (OpenEndRange) ZeusTransformUtils.wrapperContextForParams(r2, OpenEndRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return r4.contains((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(r3), Comparable.class, "com.obric.memorydata.plugin"));
    }

    public static final boolean intRangeContains(OpenEndRange<Integer> r2, long r3) {
        OpenEndRange r4 = (OpenEndRange) ZeusTransformUtils.wrapperContextForParams(r2, OpenEndRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Integer r5 = RangesKt.toIntExactOrNull(r3);
        if (r5 != null) goto L7;
        return false;
    L7:
        return r4.contains((Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin"));
    }

    public static final boolean intRangeContains(OpenEndRange<Integer> r2, short r3) {
        OpenEndRange r4 = (OpenEndRange) ZeusTransformUtils.wrapperContextForParams(r2, OpenEndRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return r4.contains((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(r3), Comparable.class, "com.obric.memorydata.plugin"));
    }

    public static final char last(CharProgression r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r3.isEmpty() == true) goto L7;
        return r3.getLast();
    L7:
        throw new NoSuchElementException("Progression " + r3 + " is empty.");
    }

    public static final int last(IntProgression r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r3.isEmpty() == true) goto L7;
        return r3.getLast();
    L7:
        throw new NoSuchElementException("Progression " + r3 + " is empty.");
    }

    public static final long last(LongProgression r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r3.isEmpty() == true) goto L7;
        return r3.getLast();
    L7:
        throw new NoSuchElementException("Progression " + r3 + " is empty.");
    }

    public static final Character lastOrNull(CharProgression r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.isEmpty() == false) goto L6;
        return null;
    L6:
        return Character.valueOf(r1.getLast());
    }

    public static final Integer lastOrNull(IntProgression r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.isEmpty() == false) goto L6;
        return null;
    L6:
        return Integer.valueOf(r1.getLast());
    }

    public static final Long lastOrNull(LongProgression r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.isEmpty() == false) goto L6;
        return null;
    L6:
        return Long.valueOf(r2.getLast());
    }

    public static final boolean longRangeContains(ClosedRange<Long> r4, byte r5) {
        ClosedRange r6 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r4, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        return r6.contains((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(r5), Comparable.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean longRangeContains(ClosedRange r2, double r3) {
        ClosedRange r4 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r2, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Long r5 = RangesKt.toLongExactOrNull(r3);
        if (r5 != null) goto L7;
        return false;
    L7:
        return r4.contains((Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean longRangeContains(ClosedRange r2, float r3) {
        ClosedRange r4 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r2, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Long r5 = RangesKt.toLongExactOrNull(r3);
        if (r5 != null) goto L7;
        return false;
    L7:
        return r4.contains((Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin"));
    }

    public static final boolean longRangeContains(ClosedRange<Long> r4, int r5) {
        ClosedRange r6 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r4, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        return r6.contains((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(r5), Comparable.class, "com.obric.memorydata.plugin"));
    }

    public static final boolean longRangeContains(ClosedRange<Long> r4, short r5) {
        ClosedRange r6 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r4, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        return r6.contains((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(r5), Comparable.class, "com.obric.memorydata.plugin"));
    }

    public static final boolean longRangeContains(OpenEndRange<Long> r4, byte r5) {
        OpenEndRange r6 = (OpenEndRange) ZeusTransformUtils.wrapperContextForParams(r4, OpenEndRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        return r6.contains((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(r5), Comparable.class, "com.obric.memorydata.plugin"));
    }

    public static final boolean longRangeContains(OpenEndRange<Long> r4, int r5) {
        OpenEndRange r6 = (OpenEndRange) ZeusTransformUtils.wrapperContextForParams(r4, OpenEndRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        return r6.contains((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(r5), Comparable.class, "com.obric.memorydata.plugin"));
    }

    public static final boolean longRangeContains(OpenEndRange<Long> r4, short r5) {
        OpenEndRange r6 = (OpenEndRange) ZeusTransformUtils.wrapperContextForParams(r4, OpenEndRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        return r6.contains((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(r5), Comparable.class, "com.obric.memorydata.plugin"));
    }

    private static final char random(CharRange r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return RangesKt.random(r3, (Random) ZeusTransformUtils.preCheckCast(Random.Default, Random.class, "com.obric.memorydata.plugin"));
    }

    public static final char random(CharRange r1, Random r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "random");
        return (char) r2.nextInt(r1.getFirst(), r1.getLast() + 1);
    L6:
        e = move-exception;
        throw new NoSuchElementException(e.getMessage());
    }

    private static final int random(IntRange r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return RangesKt.random(r3, (Random) ZeusTransformUtils.preCheckCast(Random.Default, Random.class, "com.obric.memorydata.plugin"));
    }

    public static final int random(IntRange r1, Random r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "random");
        return RandomKt.nextInt(r2, r1);
    L5:
        e = move-exception;
        throw new NoSuchElementException(e.getMessage());
    }

    private static final long random(LongRange r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return RangesKt.random(r3, (Random) ZeusTransformUtils.preCheckCast(Random.Default, Random.class, "com.obric.memorydata.plugin"));
    }

    public static final long random(LongRange r1, Random r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "random");
        return RandomKt.nextLong(r2, r1);
    L5:
        e = move-exception;
        throw new NoSuchElementException(e.getMessage());
    }

    private static final Character randomOrNull(CharRange r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return RangesKt.randomOrNull(r3, (Random) ZeusTransformUtils.preCheckCast(Random.Default, Random.class, "com.obric.memorydata.plugin"));
    }

    public static final Character randomOrNull(CharRange r1, Random r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "random");
        if (r1.isEmpty() == false) goto L7;
        return null;
    L7:
        return Character.valueOf((char) r2.nextInt(r1.getFirst(), r1.getLast() + 1));
    }

    private static final Integer randomOrNull(IntRange r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return RangesKt.randomOrNull(r3, (Random) ZeusTransformUtils.preCheckCast(Random.Default, Random.class, "com.obric.memorydata.plugin"));
    }

    public static final Integer randomOrNull(IntRange r1, Random r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "random");
        if (r1.isEmpty() == false) goto L7;
        return null;
    L7:
        return Integer.valueOf(RandomKt.nextInt(r2, r1));
    }

    private static final Long randomOrNull(LongRange r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return RangesKt.randomOrNull(r3, (Random) ZeusTransformUtils.preCheckCast(Random.Default, Random.class, "com.obric.memorydata.plugin"));
    }

    public static final Long randomOrNull(LongRange r1, Random r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "random");
        if (r1.isEmpty() == false) goto L7;
        return null;
    L7:
        return Long.valueOf(RandomKt.nextLong(r2, r1));
    }

    public static final CharProgression reversed(CharProgression r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return CharProgression.Companion.fromClosedRange(r3.getLast(), r3.getFirst(), -r3.getStep());
    }

    public static final IntProgression reversed(IntProgression r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return IntProgression.Companion.fromClosedRange(r3.getLast(), r3.getFirst(), -r3.getStep());
    }

    public static final LongProgression reversed(LongProgression r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        return LongProgression.Companion.fromClosedRange(r8.getLast(), r8.getFirst(), -r8.getStep());
    }

    public static final boolean shortRangeContains(ClosedRange<Short> r2, byte r3) {
        ClosedRange r4 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r2, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return r4.contains((Comparable) ZeusTransformUtils.preCheckCast(Short.valueOf(r3), Comparable.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean shortRangeContains(ClosedRange r2, double r3) {
        ClosedRange r4 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r2, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Short r5 = RangesKt.toShortExactOrNull(r3);
        if (r5 != null) goto L7;
        return false;
    L7:
        return r4.contains((Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean shortRangeContains(ClosedRange r2, float r3) {
        ClosedRange r4 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r2, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Short r5 = RangesKt.toShortExactOrNull(r3);
        if (r5 != null) goto L7;
        return false;
    L7:
        return r4.contains((Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin"));
    }

    public static final boolean shortRangeContains(ClosedRange<Short> r2, int r3) {
        ClosedRange r4 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r2, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Short r5 = RangesKt.toShortExactOrNull(r3);
        if (r5 != null) goto L7;
        return false;
    L7:
        return r4.contains((Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin"));
    }

    public static final boolean shortRangeContains(ClosedRange<Short> r2, long r3) {
        ClosedRange r4 = (ClosedRange) ZeusTransformUtils.wrapperContextForParams(r2, ClosedRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Short r5 = RangesKt.toShortExactOrNull(r3);
        if (r5 != null) goto L7;
        return false;
    L7:
        return r4.contains((Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin"));
    }

    public static final boolean shortRangeContains(OpenEndRange<Short> r2, byte r3) {
        OpenEndRange r4 = (OpenEndRange) ZeusTransformUtils.wrapperContextForParams(r2, OpenEndRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return r4.contains((Comparable) ZeusTransformUtils.preCheckCast(Short.valueOf(r3), Comparable.class, "com.obric.memorydata.plugin"));
    }

    public static final boolean shortRangeContains(OpenEndRange<Short> r2, int r3) {
        OpenEndRange r4 = (OpenEndRange) ZeusTransformUtils.wrapperContextForParams(r2, OpenEndRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Short r5 = RangesKt.toShortExactOrNull(r3);
        if (r5 != null) goto L7;
        return false;
    L7:
        return r4.contains((Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin"));
    }

    public static final boolean shortRangeContains(OpenEndRange<Short> r2, long r3) {
        OpenEndRange r4 = (OpenEndRange) ZeusTransformUtils.wrapperContextForParams(r2, OpenEndRange.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Short r5 = RangesKt.toShortExactOrNull(r3);
        if (r5 != null) goto L7;
        return false;
    L7:
        return r4.contains((Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin"));
    }

    public static final CharProgression step(CharProgression r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r5 <= 0) goto L5;
        boolean r0 = true;
    L6:
        RangesKt.checkStepIsPositive(r0, (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r5), Number.class, "com.obric.memorydata.plugin"));
        CharProgression.Companion r1 = CharProgression.Companion;
        char r2 = r4.getFirst();
        char r3 = r4.getLast();
        if (r4.getStep() > 0) goto L11;
        r5 = -r5;
    L11:
        return r1.fromClosedRange(r2, r3, r5);
    L5:
        r0 = false;
        goto L6
    }

    public static final IntProgression step(IntProgression r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r5 <= 0) goto L5;
        boolean r0 = true;
    L6:
        RangesKt.checkStepIsPositive(r0, (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r5), Number.class, "com.obric.memorydata.plugin"));
        IntProgression.Companion r1 = IntProgression.Companion;
        int r2 = r4.getFirst();
        int r3 = r4.getLast();
        if (r4.getStep() > 0) goto L11;
        r5 = -r5;
    L11:
        return r1.fromClosedRange(r2, r3, r5);
    L5:
        r0 = false;
        goto L6
    }

    public static final LongProgression step(LongProgression r11, long r12) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        if (r12 <= 0) goto L5;
        boolean r2 = true;
    L6:
        RangesKt.checkStepIsPositive(r2, (Number) ZeusTransformUtils.preCheckCast(Long.valueOf(r12), Number.class, "com.obric.memorydata.plugin"));
        LongProgression.Companion r4 = LongProgression.Companion;
        long r5 = r11.getFirst();
        long r7 = r11.getLast();
        if (r11.getStep() > 0) goto L11;
        r12 = -r12;
    L11:
        return r4.fromClosedRange(r5, r7, r12);
    L5:
        r2 = false;
        goto L6
    }

    public static final Byte toByteExactOrNull(double r4) {
        boolean r1 = false;
        if ((-128.0d) <= r4) goto L5;
    L7:
        if (r1 == true) goto L11;
        return null;
    L11:
        return Byte.valueOf((byte) r4);
    L5:
        if (r4 > 127.0d) goto L7;
        r1 = true;
        goto L7
    }

    public static final Byte toByteExactOrNull(float r2) {
        boolean r1 = false;
        if ((-128.0f) <= r2) goto L5;
    L7:
        if (r1 == true) goto L11;
        return null;
    L11:
        return Byte.valueOf((byte) r2);
    L5:
        if (r2 > 127.0f) goto L7;
        r1 = true;
        goto L7
    }

    public static final Byte toByteExactOrNull(int r2) {
        boolean r0 = false;
        if ((-128) <= r2) goto L5;
    L7:
        if (r0 == true) goto L11;
        return null;
    L11:
        return Byte.valueOf((byte) r2);
    L5:
        if (r2 >= 128) goto L7;
        r0 = true;
        goto L7
    }

    public static final Byte toByteExactOrNull(long r4) {
        boolean r1 = false;
        if ((-128) <= r4) goto L5;
    L7:
        if (r1 == true) goto L11;
        return null;
    L11:
        return Byte.valueOf((byte) r4);
    L5:
        if (r4 >= 128) goto L7;
        r1 = true;
        goto L7
    }

    public static final Byte toByteExactOrNull(short r2) {
        boolean r0 = false;
        if ((-128) <= r2) goto L5;
    L7:
        if (r0 == true) goto L11;
        return null;
    L11:
        return Byte.valueOf((byte) r2);
    L5:
        if (r2 >= 128) goto L7;
        r0 = true;
        goto L7
    }

    public static final Integer toIntExactOrNull(double r4) {
        boolean r1 = false;
        if ((-2.147483648E9d) <= r4) goto L5;
    L7:
        if (r1 == true) goto L11;
        return null;
    L11:
        return Integer.valueOf((int) r4);
    L5:
        if (r4 > 2.147483647E9d) goto L7;
        r1 = true;
        goto L7
    }

    public static final Integer toIntExactOrNull(float r2) {
        boolean r1 = false;
        if ((-2.1474836E9f) <= r2) goto L5;
    L7:
        if (r1 == true) goto L11;
        return null;
    L11:
        return Integer.valueOf((int) r2);
    L5:
        if (r2 > 2.1474836E9f) goto L7;
        r1 = true;
        goto L7
    }

    public static final Integer toIntExactOrNull(long r4) {
        boolean r1 = false;
        if ((-2147483648L) <= r4) goto L5;
    L7:
        if (r1 == true) goto L11;
        return null;
    L11:
        return Integer.valueOf((int) r4);
    L5:
        if (r4 >= 2147483648L) goto L7;
        r1 = true;
        goto L7
    }

    public static final Long toLongExactOrNull(double r4) {
        boolean r1 = false;
        if ((-9.223372036854776E18d) <= r4) goto L5;
    L7:
        if (r1 == true) goto L11;
        return null;
    L11:
        return Long.valueOf((long) r4);
    L5:
        if (r4 > 9.223372036854776E18d) goto L7;
        r1 = true;
        goto L7
    }

    public static final Long toLongExactOrNull(float r2) {
        boolean r1 = false;
        if ((-9.223372E18f) <= r2) goto L5;
    L7:
        if (r1 == true) goto L11;
        return null;
    L11:
        return Long.valueOf((long) r2);
    L5:
        if (r2 > 9.223372E18f) goto L7;
        r1 = true;
        goto L7
    }

    public static final Short toShortExactOrNull(double r4) {
        boolean r1 = false;
        if ((-32768.0d) <= r4) goto L5;
    L7:
        if (r1 == true) goto L11;
        return null;
    L11:
        return Short.valueOf((short) r4);
    L5:
        if (r4 > 32767.0d) goto L7;
        r1 = true;
        goto L7
    }

    public static final Short toShortExactOrNull(float r2) {
        boolean r1 = false;
        if ((-32768.0f) <= r2) goto L5;
    L7:
        if (r1 == true) goto L11;
        return null;
    L11:
        return Short.valueOf((short) r2);
    L5:
        if (r2 > 32767.0f) goto L7;
        r1 = true;
        goto L7
    }

    public static final Short toShortExactOrNull(int r2) {
        boolean r0 = false;
        if ((-32768) <= r2) goto L5;
    L7:
        if (r0 == true) goto L11;
        return null;
    L11:
        return Short.valueOf((short) r2);
    L5:
        if (r2 >= 32768) goto L7;
        r0 = true;
        goto L7
    }

    public static final Short toShortExactOrNull(long r4) {
        boolean r1 = false;
        if ((-32768) <= r4) goto L5;
    L7:
        if (r1 == true) goto L11;
        return null;
    L11:
        return Short.valueOf((short) r4);
    L5:
        if (r4 >= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID) goto L7;
        r1 = true;
        goto L7
    }

    public static final CharRange until(char r1, char r2) {
        if (Intrinsics.compare(r2, 0) > 0) goto L7;
        return CharRange.Companion.getEMPTY();
    L7:
        return new CharRange(r1, (char) (r2 - 1));
    }

    public static final IntRange until(byte r1, byte r2) {
        return new IntRange(r1, r2 - 1);
    }

    public static final IntRange until(byte r1, int r2) {
        if (r2 > Integer.MIN_VALUE) goto L7;
        return IntRange.Companion.getEMPTY();
    L7:
        return new IntRange(r1, r2 - 1);
    }

    public static final IntRange until(byte r1, short r2) {
        return new IntRange(r1, r2 - 1);
    }

    public static final IntRange until(int r1, byte r2) {
        return new IntRange(r1, r2 - 1);
    }

    public static final IntRange until(int r1, int r2) {
        if (r2 > Integer.MIN_VALUE) goto L7;
        return IntRange.Companion.getEMPTY();
    L7:
        return new IntRange(r1, r2 - 1);
    }

    public static final IntRange until(int r1, short r2) {
        return new IntRange(r1, r2 - 1);
    }

    public static final IntRange until(short r1, byte r2) {
        return new IntRange(r1, r2 - 1);
    }

    public static final IntRange until(short r1, int r2) {
        if (r2 > Integer.MIN_VALUE) goto L7;
        return IntRange.Companion.getEMPTY();
    L7:
        return new IntRange(r1, r2 - 1);
    }

    public static final IntRange until(short r1, short r2) {
        return new IntRange(r1, r2 - 1);
    }

    public static final LongRange until(byte r5, long r6) {
        if (r6 > Long.MIN_VALUE) goto L7;
        return LongRange.Companion.getEMPTY();
    L7:
        return new LongRange(r5, r6 - 1);
    }

    public static final LongRange until(int r5, long r6) {
        if (r6 > Long.MIN_VALUE) goto L7;
        return LongRange.Companion.getEMPTY();
    L7:
        return new LongRange(r5, r6 - 1);
    }

    public static final LongRange until(long r5, byte r7) {
        return new LongRange(r5, ((long) r7) - 1);
    }

    public static final LongRange until(long r5, int r7) {
        return new LongRange(r5, ((long) r7) - 1);
    }

    public static final LongRange until(long r3, long r5) {
        if (r5 > Long.MIN_VALUE) goto L7;
        return LongRange.Companion.getEMPTY();
    L7:
        return new LongRange(r3, r5 - 1);
    }

    public static final LongRange until(long r5, short r7) {
        return new LongRange(r5, ((long) r7) - 1);
    }

    public static final LongRange until(short r5, long r6) {
        if (r6 > Long.MIN_VALUE) goto L7;
        return LongRange.Companion.getEMPTY();
    L7:
        return new LongRange(r5, r6 - 1);
    }
}
