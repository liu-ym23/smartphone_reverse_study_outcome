package kotlin.ranges;

import ai.j0;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.antlr.runtime.a;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.random.RandomKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000t\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001d\u001a'\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005\u001a\u0012\u0010\u0000\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006\u001a\u0012\u0010\u0000\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0007\u001a\u0012\u0010\u0000\u001a\u00020\b*\u00020\b2\u0006\u0010\u0003\u001a\u00020\b\u001a\u0012\u0010\u0000\u001a\u00020\t*\u00020\t2\u0006\u0010\u0003\u001a\u00020\t\u001a\u0012\u0010\u0000\u001a\u00020\n*\u00020\n2\u0006\u0010\u0003\u001a\u00020\n\u001a'\u0010\u000b\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\u0006\u0010\f\u001a\u0002H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0012\u0010\u000b\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005\u001a\u0012\u0010\u000b\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006\u001a\u0012\u0010\u000b\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007\u001a\u0012\u0010\u000b\u001a\u00020\b*\u00020\b2\u0006\u0010\f\u001a\u00020\b\u001a\u0012\u0010\u000b\u001a\u00020\t*\u00020\t2\u0006\u0010\f\u001a\u00020\t\u001a\u0012\u0010\u000b\u001a\u00020\n*\u00020\n2\u0006\u0010\f\u001a\u00020\n\u001a3\u0010\r\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\b\u0010\u0003\u001a\u0004\u0018\u0001H\u00012\b\u0010\f\u001a\u0004\u0018\u0001H\u0001¢\u0006\u0002\u0010\u000e\u001a/\u0010\r\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001a-\u0010\r\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0012¢\u0006\u0002\u0010\u0013\u001a\u001a\u0010\r\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005\u001a\u001a\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006\u001a\u001a\u0010\r\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007\u001a\u001a\u0010\r\u001a\u00020\b*\u00020\b2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b\u001a\u0018\u0010\r\u001a\u00020\b*\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0012\u001a\u001a\u0010\r\u001a\u00020\t*\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t\u001a\u0018\u0010\r\u001a\u00020\t*\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0012\u001a\u001a\u0010\r\u001a\u00020\n*\u00020\n2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0087\n¢\u0006\u0002\u0010\u0019\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b \u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020!2\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\n\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020!2\b\u0010\u0017\u001a\u0004\u0018\u00010\bH\u0087\n¢\u0006\u0002\u0010\"\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020!2\u0006\u0010\u001a\u001a\u00020\tH\u0087\n\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020!2\u0006\u0010\u001a\u001a\u00020\nH\u0087\n\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020#2\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\n\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020#2\u0006\u0010\u001a\u001a\u00020\bH\u0087\n\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020#2\b\u0010\u0017\u001a\u0004\u0018\u00010\tH\u0087\n¢\u0006\u0002\u0010$\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020#2\u0006\u0010\u001a\u001a\u00020\nH\u0087\n\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060%2\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0%2\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0%2\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0%2\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0%2\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0%2\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0%2\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0%2\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0%2\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0%2\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b \u001a\u0015\u0010&\u001a\u00020'*\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\u00052\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\u00052\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\u00052\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020**\u00020\u00182\u0006\u0010(\u001a\u00020\u0018H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\b2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\b2\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\b2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\b2\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\t2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\t2\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\t2\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\n2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\n2\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\n2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\f\u0010+\u001a\u00020\u0018*\u00020*H\u0007\u001a\f\u0010+\u001a\u00020\b*\u00020'H\u0007\u001a\f\u0010+\u001a\u00020\t*\u00020)H\u0007\u001a\u0013\u0010,\u001a\u0004\u0018\u00010\u0018*\u00020*H\u0007¢\u0006\u0002\u0010-\u001a\u0013\u0010,\u001a\u0004\u0018\u00010\b*\u00020'H\u0007¢\u0006\u0002\u0010.\u001a\u0013\u0010,\u001a\u0004\u0018\u00010\t*\u00020)H\u0007¢\u0006\u0002\u0010/\u001a\f\u00100\u001a\u00020\u0018*\u00020*H\u0007\u001a\f\u00100\u001a\u00020\b*\u00020'H\u0007\u001a\f\u00100\u001a\u00020\t*\u00020)H\u0007\u001a\u0013\u00101\u001a\u0004\u0018\u00010\u0018*\u00020*H\u0007¢\u0006\u0002\u0010-\u001a\u0013\u00101\u001a\u0004\u0018\u00010\b*\u00020'H\u0007¢\u0006\u0002\u0010.\u001a\u0013\u00101\u001a\u0004\u0018\u00010\t*\u00020)H\u0007¢\u0006\u0002\u0010/\u001a\r\u00102\u001a\u00020\u0018*\u00020\u0016H\u0087\b\u001a\u0014\u00102\u001a\u00020\u0018*\u00020\u00162\u0006\u00102\u001a\u000203H\u0007\u001a\r\u00102\u001a\u00020\b*\u00020!H\u0087\b\u001a\u0014\u00102\u001a\u00020\b*\u00020!2\u0006\u00102\u001a\u000203H\u0007\u001a\r\u00102\u001a\u00020\t*\u00020#H\u0087\b\u001a\u0014\u00102\u001a\u00020\t*\u00020#2\u0006\u00102\u001a\u000203H\u0007\u001a\u0014\u00104\u001a\u0004\u0018\u00010\u0018*\u00020\u0016H\u0087\b¢\u0006\u0002\u00105\u001a\u001b\u00104\u001a\u0004\u0018\u00010\u0018*\u00020\u00162\u0006\u00102\u001a\u000203H\u0007¢\u0006\u0002\u00106\u001a\u0014\u00104\u001a\u0004\u0018\u00010\b*\u00020!H\u0087\b¢\u0006\u0002\u00107\u001a\u001b\u00104\u001a\u0004\u0018\u00010\b*\u00020!2\u0006\u00102\u001a\u000203H\u0007¢\u0006\u0002\u00108\u001a\u0014\u00104\u001a\u0004\u0018\u00010\t*\u00020#H\u0087\b¢\u0006\u0002\u00109\u001a\u001b\u00104\u001a\u0004\u0018\u00010\t*\u00020#2\u0006\u00102\u001a\u000203H\u0007¢\u0006\u0002\u0010:\u001a\n\u0010;\u001a\u00020**\u00020*\u001a\n\u0010;\u001a\u00020'*\u00020'\u001a\n\u0010;\u001a\u00020)*\u00020)\u001a\u0015\u0010<\u001a\u00020**\u00020*2\u0006\u0010<\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010<\u001a\u00020'*\u00020'2\u0006\u0010<\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010<\u001a\u00020)*\u00020)2\u0006\u0010<\u001a\u00020\tH\u0086\u0004\u001a\u0013\u0010=\u001a\u0004\u0018\u00010\u0005*\u00020\u0006H\u0000¢\u0006\u0002\u0010>\u001a\u0013\u0010=\u001a\u0004\u0018\u00010\u0005*\u00020\u0007H\u0000¢\u0006\u0002\u0010?\u001a\u0013\u0010=\u001a\u0004\u0018\u00010\u0005*\u00020\bH\u0000¢\u0006\u0002\u0010@\u001a\u0013\u0010=\u001a\u0004\u0018\u00010\u0005*\u00020\tH\u0000¢\u0006\u0002\u0010A\u001a\u0013\u0010=\u001a\u0004\u0018\u00010\u0005*\u00020\nH\u0000¢\u0006\u0002\u0010B\u001a\u0013\u0010C\u001a\u0004\u0018\u00010\b*\u00020\u0006H\u0000¢\u0006\u0002\u0010D\u001a\u0013\u0010C\u001a\u0004\u0018\u00010\b*\u00020\u0007H\u0000¢\u0006\u0002\u0010E\u001a\u0013\u0010C\u001a\u0004\u0018\u00010\b*\u00020\tH\u0000¢\u0006\u0002\u0010F\u001a\u0013\u0010G\u001a\u0004\u0018\u00010\t*\u00020\u0006H\u0000¢\u0006\u0002\u0010H\u001a\u0013\u0010G\u001a\u0004\u0018\u00010\t*\u00020\u0007H\u0000¢\u0006\u0002\u0010I\u001a\u0013\u0010J\u001a\u0004\u0018\u00010\n*\u00020\u0006H\u0000¢\u0006\u0002\u0010K\u001a\u0013\u0010J\u001a\u0004\u0018\u00010\n*\u00020\u0007H\u0000¢\u0006\u0002\u0010L\u001a\u0013\u0010J\u001a\u0004\u0018\u00010\n*\u00020\bH\u0000¢\u0006\u0002\u0010M\u001a\u0013\u0010J\u001a\u0004\u0018\u00010\n*\u00020\tH\u0000¢\u0006\u0002\u0010N\u001a\u0015\u0010O\u001a\u00020!*\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010O\u001a\u00020!*\u00020\u00052\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020#*\u00020\u00052\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020!*\u00020\u00052\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020\u0016*\u00020\u00182\u0006\u0010(\u001a\u00020\u0018H\u0086\u0004\u001a\u0015\u0010O\u001a\u00020!*\u00020\b2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010O\u001a\u00020!*\u00020\b2\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020#*\u00020\b2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020!*\u00020\b2\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010O\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020!*\u00020\n2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010O\u001a\u00020!*\u00020\n2\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020#*\u00020\n2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010O\u001a\u00020!*\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0086\u0004¨\u0006P"}, d2 = {"coerceAtLeast", ExifInterface.GPS_DIRECTION_TRUE, "", "minimumValue", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "coerceAtMost", "maximumValue", "coerceIn", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "range", "Lkotlin/ranges/ClosedFloatingPointRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "Lkotlin/ranges/ClosedRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedRange;)Ljava/lang/Comparable;", "contains", "", "Lkotlin/ranges/CharRange;", "element", "", "(Lkotlin/ranges/CharRange;Ljava/lang/Character;)Z", "value", "byteRangeContains", "doubleRangeContains", "floatRangeContains", "intRangeContains", "longRangeContains", "shortRangeContains", "Lkotlin/ranges/IntRange;", "(Lkotlin/ranges/IntRange;Ljava/lang/Integer;)Z", "Lkotlin/ranges/LongRange;", "(Lkotlin/ranges/LongRange;Ljava/lang/Long;)Z", "Lkotlin/ranges/OpenEndRange;", "downTo", "Lkotlin/ranges/IntProgression;", "to", "Lkotlin/ranges/LongProgression;", "Lkotlin/ranges/CharProgression;", "first", "firstOrNull", "(Lkotlin/ranges/CharProgression;)Ljava/lang/Character;", "(Lkotlin/ranges/IntProgression;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongProgression;)Ljava/lang/Long;", "last", "lastOrNull", "random", "Lkotlin/random/Random;", "randomOrNull", "(Lkotlin/ranges/CharRange;)Ljava/lang/Character;", "(Lkotlin/ranges/CharRange;Lkotlin/random/Random;)Ljava/lang/Character;", "(Lkotlin/ranges/IntRange;)Ljava/lang/Integer;", "(Lkotlin/ranges/IntRange;Lkotlin/random/Random;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongRange;)Ljava/lang/Long;", "(Lkotlin/ranges/LongRange;Lkotlin/random/Random;)Ljava/lang/Long;", "reversed", "step", "toByteExactOrNull", "(D)Ljava/lang/Byte;", "(F)Ljava/lang/Byte;", "(I)Ljava/lang/Byte;", "(J)Ljava/lang/Byte;", "(S)Ljava/lang/Byte;", "toIntExactOrNull", "(D)Ljava/lang/Integer;", "(F)Ljava/lang/Integer;", "(J)Ljava/lang/Integer;", "toLongExactOrNull", "(D)Ljava/lang/Long;", "(F)Ljava/lang/Long;", "toShortExactOrNull", "(D)Ljava/lang/Short;", "(F)Ljava/lang/Short;", "(I)Ljava/lang/Short;", "(J)Ljava/lang/Short;", "until", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/ranges/RangesKt")
@SourceDebugExtension({"SMAP\n_Ranges.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Ranges.kt\nkotlin/ranges/RangesKt___RangesKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1538:1\n1#2:1539\n*E\n"})
class RangesKt___RangesKt extends RangesKt__RangesKt {
    public RangesKt___RangesKt() {
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "byteRangeContains")
    public static final /* synthetic */ boolean byteRangeContains(ClosedRange r5, double r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Byte r11 = toByteExactOrNull(r10);
        if (r11 != null) goto L7;
        return false;
    L7:
        return r5.contains(r11);
    }

    public static final byte coerceAtLeast(byte r5, byte r10) {
        if (r5 < r10) goto L4;
        return r5;
    L4:
        return r10;
    }

    public static final byte coerceAtMost(byte r5, byte r10) {
        if (r5 > r10) goto L4;
        return r5;
    L4:
        return r10;
    }

    public static final <T extends Comparable<? super T>> T coerceIn(T r5, T r10, T r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r10 == null) goto L15;
        if (r11 == null) goto L15;
        if (r10.compareTo(r11) > 0) goto L14;
        if (r5.compareTo(r10) >= 0) goto L11;
        return r10;
    L11:
        if (r5.compareTo(r11) <= 0) goto L23;
        return r11;
    L23:
        return r5;
    L14:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r11 + " is less than minimum " + r10 + '.');
    L15:
        if (r10 != null) goto L17;
    L19:
        if (r11 == null) goto L23;
        if (r5.compareTo(r11) <= 0) goto L23;
        return r11;
    L17:
        if (r5.compareTo(r10) >= 0) goto L19;
        return r10;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean contains(IntRange r5, Integer r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.contains(r10.intValue()) == false) goto L7;
        return true;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "doubleRangeContains")
    public static final /* synthetic */ boolean doubleRangeContains(ClosedRange r5, byte r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.contains(Double.valueOf(r10));
    }

    public static final IntProgression downTo(int r5, byte r10) {
        return IntProgression.Companion.fromClosedRange(r5, r10, -1);
    }

    @SinceKotlin(version = "1.7")
    public static final int first(IntProgression r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isEmpty() == true) goto L7;
        return r5.getFirst();
    L7:
        throw new NoSuchElementException("Progression " + r5 + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    public static final Integer firstOrNull(IntProgression r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isEmpty() == false) goto L6;
        return null;
    L6:
        return Integer.valueOf(r5.getFirst());
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "floatRangeContains")
    public static final /* synthetic */ boolean floatRangeContains(ClosedRange r5, byte r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.contains(Float.valueOf(r10));
    }

    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(ClosedRange<Integer> r5, byte r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.contains(Integer.valueOf(r10));
    }

    @SinceKotlin(version = "1.7")
    public static final int last(IntProgression r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isEmpty() == true) goto L7;
        return r5.getLast();
    L7:
        throw new NoSuchElementException("Progression " + r5 + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    public static final Integer lastOrNull(IntProgression r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isEmpty() == false) goto L6;
        return null;
    L6:
        return Integer.valueOf(r5.getLast());
    }

    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(ClosedRange<Long> r5, byte r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.contains(Long.valueOf(r10));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final int random(IntRange r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return random(r5, Random.Default);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final Integer randomOrNull(IntRange r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return randomOrNull(r5, Random.Default);
    }

    public static final IntProgression reversed(IntProgression r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return IntProgression.Companion.fromClosedRange(r5.getLast(), r5.getFirst(), -r5.getStep());
    }

    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(ClosedRange<Short> r5, byte r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.contains(Short.valueOf(r10));
    }

    public static IntProgression step(IntProgression r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r10 <= 0) goto L5;
        boolean r11 = true;
    L6:
        RangesKt__RangesKt.checkStepIsPositive(r11, Integer.valueOf(r10));
        IntProgression.Companion r12 = IntProgression.Companion;
        int r13 = r5.getFirst();
        int r14 = r5.getLast();
        if (r5.getStep() > 0) goto L11;
        r10 = -r10;
    L11:
        return r12.fromClosedRange(r13, r14, r10);
    L5:
        r11 = false;
        goto L6
    }

    public static final Byte toByteExactOrNull(int r5) {
        if ((-128) <= r5) goto L5;
    L7:
        return null;
    L5:
        if (r5 >= 128) goto L7;
        return Byte.valueOf((byte) r5);
    }

    public static final Integer toIntExactOrNull(long r5) {
        if ((-2147483648L) <= r5) goto L5;
    L7:
        return null;
    L5:
        if (r5 >= 2147483648L) goto L7;
        return Integer.valueOf((int) r5);
    }

    public static final Long toLongExactOrNull(double r5) {
        if ((-9.223372036854776E18d) <= r5) goto L5;
    L7:
        return null;
    L5:
        if (r5 > 9.223372036854776E18d) goto L7;
        return Long.valueOf((long) r5);
    }

    public static final Short toShortExactOrNull(int r5) {
        if ((-32768) <= r5) goto L5;
    L7:
        return null;
    L5:
        if (r5 >= 32768) goto L7;
        return Short.valueOf((short) r5);
    }

    public static final IntRange until(int r5, byte r10) {
        return new IntRange(r5, r10 - 1);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "byteRangeContains")
    public static final /* synthetic */ boolean byteRangeContains(ClosedRange r5, float r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Byte r11 = toByteExactOrNull(r10);
        if (r11 != null) goto L7;
        return false;
    L7:
        return r5.contains(r11);
    }

    public static final double coerceAtLeast(double r5, double r10) {
        if (r5 < r10) goto L5;
        return r5;
    L5:
        return r10;
    }

    public static final double coerceAtMost(double r5, double r10) {
        if (r5 > r10) goto L5;
        return r5;
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean contains(LongRange r5, Long r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.contains(r10.longValue()) == false) goto L7;
        return true;
    }

    @JvmName(name = "doubleRangeContains")
    public static final boolean doubleRangeContains(ClosedRange<Double> r5, float r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.contains(Double.valueOf(r10));
    }

    public static final LongProgression downTo(long r10, byte r11) {
        return LongProgression.Companion.fromClosedRange(r10, r11, -1);
    }

    @SinceKotlin(version = "1.7")
    public static final Long firstOrNull(LongProgression r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isEmpty() == false) goto L6;
        return null;
    L6:
        return Long.valueOf(r5.getFirst());
    }

    @JvmName(name = "floatRangeContains")
    public static final boolean floatRangeContains(ClosedRange<Float> r5, double r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.contains(Float.valueOf((float) r10));
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(OpenEndRange<Integer> r5, byte r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.contains(Integer.valueOf(r10));
    }

    @SinceKotlin(version = "1.7")
    public static final Long lastOrNull(LongProgression r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isEmpty() == false) goto L6;
        return null;
    L6:
        return Long.valueOf(r5.getLast());
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(OpenEndRange<Long> r5, byte r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.contains(Long.valueOf(r10));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final long random(LongRange r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return random(r5, Random.Default);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final Long randomOrNull(LongRange r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return randomOrNull(r5, Random.Default);
    }

    public static final LongProgression reversed(LongProgression r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return LongProgression.Companion.fromClosedRange(r10.getLast(), r10.getFirst(), -r10.getStep());
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(OpenEndRange<Short> r5, byte r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.contains(Short.valueOf(r10));
    }

    public static final Byte toByteExactOrNull(long r5) {
        if ((-128) <= r5) goto L5;
    L7:
        return null;
    L5:
        if (r5 >= 128) goto L7;
        return Byte.valueOf((byte) r5);
    }

    public static final Integer toIntExactOrNull(double r5) {
        if ((-2.147483648E9d) <= r5) goto L5;
    L7:
        return null;
    L5:
        if (r5 > 2.147483647E9d) goto L7;
        return Integer.valueOf((int) r5);
    }

    public static final Long toLongExactOrNull(float r5) {
        if ((-9.223372E18f) <= r5) goto L5;
    L7:
        return null;
    L5:
        if (r5 > 9.223372E18f) goto L7;
        return Long.valueOf((long) r5);
    }

    public static final Short toShortExactOrNull(long r5) {
        if ((-32768) <= r5) goto L5;
    L7:
        return null;
    L5:
        if (r5 >= 32768) goto L7;
        return Short.valueOf((short) r5);
    }

    public static final LongRange until(long r5, byte r10) {
        return new LongRange(r5, ((long) r10) - 1);
    }

    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(ClosedRange<Byte> r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Byte r11 = toByteExactOrNull(r10);
        if (r11 != null) goto L7;
        return false;
    L7:
        return r5.contains(r11);
    }

    public static float coerceAtLeast(float r5, float r10) {
        if (r5 < r10) goto L5;
        return r5;
    L5:
        return r10;
    }

    public static float coerceAtMost(float r5, float r10) {
        if (r5 > r10) goto L5;
        return r5;
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean contains(CharRange r5, Character r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.contains(r10.charValue()) == false) goto L7;
        return true;
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "doubleRangeContains")
    public static final boolean doubleRangeContains(OpenEndRange<Double> r5, float r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.contains(Double.valueOf(r10));
    }

    public static final IntProgression downTo(byte r5, byte r10) {
        return IntProgression.Companion.fromClosedRange(r5, r10, -1);
    }

    @SinceKotlin(version = "1.7")
    public static final Character firstOrNull(CharProgression r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isEmpty() == false) goto L6;
        return null;
    L6:
        return Character.valueOf(r5.getFirst());
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "floatRangeContains")
    public static final /* synthetic */ boolean floatRangeContains(ClosedRange r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.contains(Float.valueOf(r10));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "intRangeContains")
    public static final /* synthetic */ boolean intRangeContains(ClosedRange r5, double r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Integer r11 = toIntExactOrNull(r10);
        if (r11 != null) goto L7;
        return false;
    L7:
        return r5.contains(r11);
    }

    @SinceKotlin(version = "1.7")
    public static final Character lastOrNull(CharProgression r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isEmpty() == false) goto L6;
        return null;
    L6:
        return Character.valueOf(r5.getLast());
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "longRangeContains")
    public static final /* synthetic */ boolean longRangeContains(ClosedRange r5, double r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Long r11 = toLongExactOrNull(r10);
        if (r11 != null) goto L7;
        return false;
    L7:
        return r5.contains(r11);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final char random(CharRange r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return random(r5, Random.Default);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final Character randomOrNull(CharRange r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return randomOrNull(r5, Random.Default);
    }

    public static final CharProgression reversed(CharProgression r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return CharProgression.Companion.fromClosedRange(r5.getLast(), r5.getFirst(), -r5.getStep());
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "shortRangeContains")
    public static final /* synthetic */ boolean shortRangeContains(ClosedRange r5, double r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Short r11 = toShortExactOrNull(r10);
        if (r11 != null) goto L7;
        return false;
    L7:
        return r5.contains(r11);
    }

    public static final LongProgression step(LongProgression r11, long r12) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        if (r12 <= 0) goto L5;
        boolean r5 = true;
    L6:
        RangesKt__RangesKt.checkStepIsPositive(r5, Long.valueOf(r12));
        LongProgression.Companion r10 = LongProgression.Companion;
        long r13 = r11.getFirst();
        long r14 = r11.getLast();
        if (r11.getStep() > 0) goto L11;
        r12 = -r12;
    L11:
        return r10.fromClosedRange(r13, r14, r12);
    L5:
        r5 = false;
        goto L6
    }

    public static final Byte toByteExactOrNull(short r5) {
        if ((-128) <= r5) goto L5;
    L7:
        return null;
    L5:
        if (r5 >= 128) goto L7;
        return Byte.valueOf((byte) r5);
    }

    public static final Integer toIntExactOrNull(float r5) {
        if ((-2.1474836E9f) <= r5) goto L5;
    L7:
        return null;
    L5:
        if (r5 > 2.1474836E9f) goto L7;
        return Integer.valueOf((int) r5);
    }

    public static final Short toShortExactOrNull(double r5) {
        if ((-32768.0d) <= r5) goto L5;
    L7:
        return null;
    L5:
        if (r5 > 32767.0d) goto L7;
        return Short.valueOf((short) r5);
    }

    public static final IntRange until(byte r5, byte r10) {
        return new IntRange(r5, r10 - 1);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(OpenEndRange<Byte> r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Byte r11 = toByteExactOrNull(r10);
        if (r11 != null) goto L7;
        return false;
    L7:
        return r5.contains(r11);
    }

    public static int coerceAtLeast(int r5, int r10) {
        if (r5 < r10) goto L4;
        return r5;
    L4:
        return r10;
    }

    public static int coerceAtMost(int r5, int r10) {
        if (r5 > r10) goto L4;
        return r5;
    L4:
        return r10;
    }

    @InlineOnly
    private static final boolean contains(IntRange r5, byte r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return intRangeContains(r5, r10);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "doubleRangeContains")
    public static final /* synthetic */ boolean doubleRangeContains(ClosedRange r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.contains(Double.valueOf(r10));
    }

    public static final IntProgression downTo(short r5, byte r10) {
        return IntProgression.Companion.fromClosedRange(r5, r10, -1);
    }

    @SinceKotlin(version = "1.7")
    public static final long first(LongProgression r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isEmpty() == true) goto L7;
        return r5.getFirst();
    L7:
        throw new NoSuchElementException("Progression " + r5 + " is empty.");
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "floatRangeContains")
    public static final /* synthetic */ boolean floatRangeContains(ClosedRange r5, long r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.contains(Float.valueOf(r10));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "intRangeContains")
    public static final /* synthetic */ boolean intRangeContains(ClosedRange r5, float r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Integer r11 = toIntExactOrNull(r10);
        if (r11 != null) goto L7;
        return false;
    L7:
        return r5.contains(r11);
    }

    @SinceKotlin(version = "1.7")
    public static final long last(LongProgression r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isEmpty() == true) goto L7;
        return r5.getLast();
    L7:
        throw new NoSuchElementException("Progression " + r5 + " is empty.");
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "longRangeContains")
    public static final /* synthetic */ boolean longRangeContains(ClosedRange r5, float r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Long r11 = toLongExactOrNull(r10);
        if (r11 != null) goto L7;
        return false;
    L7:
        return r5.contains(r11);
    }

    @SinceKotlin(version = "1.3")
    public static final int random(IntRange r5, Random r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "random");
        return RandomKt.nextInt(r10, r5);
    L5:
        e = move-exception;
        throw new NoSuchElementException(e.getMessage());
    }

    @SinceKotlin(version = "1.4")
    public static final Integer randomOrNull(IntRange r5, Random r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "random");
        if (r5.isEmpty() == false) goto L7;
        return null;
    L7:
        return Integer.valueOf(RandomKt.nextInt(r10, r5));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "shortRangeContains")
    public static final /* synthetic */ boolean shortRangeContains(ClosedRange r5, float r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Short r11 = toShortExactOrNull(r10);
        if (r11 != null) goto L7;
        return false;
    L7:
        return r5.contains(r11);
    }

    public static final Byte toByteExactOrNull(double r5) {
        if ((-128.0d) <= r5) goto L5;
    L7:
        return null;
    L5:
        if (r5 > 127.0d) goto L7;
        return Byte.valueOf((byte) r5);
    }

    public static final Short toShortExactOrNull(float r5) {
        if ((-32768.0f) <= r5) goto L5;
    L7:
        return null;
    L5:
        if (r5 > 32767.0f) goto L7;
        return Short.valueOf((short) r5);
    }

    public static final IntRange until(short r5, byte r10) {
        return new IntRange(r5, r10 - 1);
    }

    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(ClosedRange<Byte> r5, long r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Byte r11 = toByteExactOrNull(r10);
        if (r11 != null) goto L7;
        return false;
    L7:
        return r5.contains(r11);
    }

    public static long coerceAtLeast(long r5, long r10) {
        if (r5 < r10) goto L5;
        return r5;
    L5:
        return r10;
    }

    public static long coerceAtMost(long r5, long r10) {
        if (r5 > r10) goto L5;
        return r5;
    L5:
        return r10;
    }

    @InlineOnly
    private static final boolean contains(LongRange r5, byte r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return longRangeContains(r5, r10);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "doubleRangeContains")
    public static final /* synthetic */ boolean doubleRangeContains(ClosedRange r5, long r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.contains(Double.valueOf(r10));
    }

    public static final CharProgression downTo(char r5, char r10) {
        return CharProgression.Companion.fromClosedRange(r5, r10, -1);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "floatRangeContains")
    public static final /* synthetic */ boolean floatRangeContains(ClosedRange r5, short r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.contains(Float.valueOf(r10));
    }

    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(ClosedRange<Integer> r5, long r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Integer r11 = toIntExactOrNull(r10);
        if (r11 != null) goto L7;
        return false;
    L7:
        return r5.contains(r11);
    }

    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(ClosedRange<Long> r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.contains(Long.valueOf(r10));
    }

    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(ClosedRange<Short> r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Short r11 = toShortExactOrNull(r10);
        if (r11 != null) goto L7;
        return false;
    L7:
        return r5.contains(r11);
    }

    public static final CharProgression step(CharProgression r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r10 <= 0) goto L5;
        boolean r11 = true;
    L6:
        RangesKt__RangesKt.checkStepIsPositive(r11, Integer.valueOf(r10));
        CharProgression.Companion r12 = CharProgression.Companion;
        char r13 = r5.getFirst();
        char r14 = r5.getLast();
        if (r5.getStep() > 0) goto L11;
        r10 = -r10;
    L11:
        return r12.fromClosedRange(r13, r14, r10);
    L5:
        r11 = false;
        goto L6
    }

    public static final Byte toByteExactOrNull(float r5) {
        if ((-128.0f) <= r5) goto L5;
    L7:
        return null;
    L5:
        if (r5 > 127.0f) goto L7;
        return Byte.valueOf((byte) r5);
    }

    public static final CharRange until(char r5, char r10) {
        if (Intrinsics.compare(r10, 0) > 0) goto L7;
        return CharRange.Companion.getEMPTY();
    L7:
        return new CharRange(r5, (char) (r10 - 1));
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(OpenEndRange<Byte> r5, long r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Byte r11 = toByteExactOrNull(r10);
        if (r11 != null) goto L7;
        return false;
    L7:
        return r5.contains(r11);
    }

    public static final short coerceAtLeast(short r5, short r10) {
        if (r5 < r10) goto L4;
        return r5;
    L4:
        return r10;
    }

    public static final short coerceAtMost(short r5, short r10) {
        if (r5 > r10) goto L4;
        return r5;
    L4:
        return r10;
    }

    @InlineOnly
    private static final boolean contains(LongRange r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return longRangeContains(r5, r10);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "doubleRangeContains")
    public static final /* synthetic */ boolean doubleRangeContains(ClosedRange r5, short r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.contains(Double.valueOf(r10));
    }

    public static IntProgression downTo(int r5, int r10) {
        return IntProgression.Companion.fromClosedRange(r5, r10, -1);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(OpenEndRange<Integer> r5, long r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Integer r11 = toIntExactOrNull(r10);
        if (r11 != null) goto L7;
        return false;
    L7:
        return r5.contains(r11);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(OpenEndRange<Long> r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.contains(Long.valueOf(r10));
    }

    @SinceKotlin(version = "1.3")
    public static final long random(LongRange r5, Random r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "random");
        return RandomKt.nextLong(r10, r5);
    L5:
        e = move-exception;
        throw new NoSuchElementException(e.getMessage());
    }

    @SinceKotlin(version = "1.4")
    public static final Long randomOrNull(LongRange r5, Random r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "random");
        if (r5.isEmpty() == false) goto L7;
        return null;
    L7:
        return Long.valueOf(RandomKt.nextLong(r10, r5));
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(OpenEndRange<Short> r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Short r11 = toShortExactOrNull(r10);
        if (r11 != null) goto L7;
        return false;
    L7:
        return r5.contains(r11);
    }

    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(ClosedRange<Byte> r5, short r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Byte r11 = toByteExactOrNull(r10);
        if (r11 != null) goto L7;
        return false;
    L7:
        return r5.contains(r11);
    }

    public static final <T extends Comparable<? super T>> T coerceAtLeast(T r5, T r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "minimumValue");
        if (r5.compareTo(r10) < 0) goto L5;
        return r5;
    L5:
        return r10;
    }

    public static final <T extends Comparable<? super T>> T coerceAtMost(T r5, T r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "maximumValue");
        if (r5.compareTo(r10) > 0) goto L5;
        return r5;
    L5:
        return r10;
    }

    public static final byte coerceIn(byte r5, byte r10, byte r11) {
        if (r10 > r11) goto L9;
        if (r5 >= r10) goto L5;
        return r10;
    L5:
        if (r5 <= r11) goto L7;
        return r11;
    L7:
        return r5;
    L9:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r11 + " is less than minimum " + r10 + '.');
    }

    @InlineOnly
    private static final boolean contains(IntRange r5, long r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return intRangeContains(r5, r10);
    }

    public static final LongProgression downTo(long r10, int r11) {
        return LongProgression.Companion.fromClosedRange(r10, r11, -1);
    }

    @SinceKotlin(version = "1.7")
    public static final char first(CharProgression r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isEmpty() == true) goto L7;
        return r5.getFirst();
    L7:
        throw new NoSuchElementException("Progression " + r5 + " is empty.");
    }

    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(ClosedRange<Integer> r5, short r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.contains(Integer.valueOf(r10));
    }

    @SinceKotlin(version = "1.7")
    public static final char last(CharProgression r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isEmpty() == true) goto L7;
        return r5.getLast();
    L7:
        throw new NoSuchElementException("Progression " + r5 + " is empty.");
    }

    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(ClosedRange<Long> r5, short r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.contains(Long.valueOf(r10));
    }

    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(ClosedRange<Short> r5, long r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Short r11 = toShortExactOrNull(r10);
        if (r11 != null) goto L7;
        return false;
    L7:
        return r5.contains(r11);
    }

    public static IntRange until(int r5, int r10) {
        if (r10 > Integer.MIN_VALUE) goto L7;
        return IntRange.Companion.getEMPTY();
    L7:
        return new IntRange(r5, r10 - 1);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(OpenEndRange<Byte> r5, short r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Byte r11 = toByteExactOrNull(r10);
        if (r11 != null) goto L7;
        return false;
    L7:
        return r5.contains(r11);
    }

    public static final short coerceIn(short r5, short r10, short r11) {
        if (r10 > r11) goto L9;
        if (r5 >= r10) goto L5;
        return r10;
    L5:
        if (r5 <= r11) goto L7;
        return r11;
    L7:
        return r5;
    L9:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r11 + " is less than minimum " + r10 + '.');
    }

    @InlineOnly
    private static final boolean contains(IntRange r5, short r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return intRangeContains(r5, r10);
    }

    public static final IntProgression downTo(byte r5, int r10) {
        return IntProgression.Companion.fromClosedRange(r5, r10, -1);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(OpenEndRange<Integer> r5, short r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.contains(Integer.valueOf(r10));
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(OpenEndRange<Long> r5, short r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.contains(Long.valueOf(r10));
    }

    @SinceKotlin(version = "1.3")
    public static final char random(CharRange r5, Random r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "random");
        return (char) r10.nextInt(r5.getFirst(), r5.getLast() + 1);
    L6:
        e = move-exception;
        throw new NoSuchElementException(e.getMessage());
    }

    @SinceKotlin(version = "1.4")
    public static final Character randomOrNull(CharRange r5, Random r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "random");
        if (r5.isEmpty() == false) goto L7;
        return null;
    L7:
        return Character.valueOf((char) r10.nextInt(r5.getFirst(), r5.getLast() + 1));
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(OpenEndRange<Short> r5, long r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Short r11 = toShortExactOrNull(r10);
        if (r11 != null) goto L7;
        return false;
    L7:
        return r5.contains(r11);
    }

    public static int coerceIn(int r5, int r10, int r11) {
        if (r10 > r11) goto L9;
        if (r5 >= r10) goto L5;
        return r10;
    L5:
        if (r5 <= r11) goto L7;
        return r11;
    L7:
        return r5;
    L9:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r11 + " is less than minimum " + r10 + '.');
    }

    @InlineOnly
    private static final boolean contains(LongRange r5, short r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return longRangeContains(r5, r10);
    }

    public static final IntProgression downTo(short r5, int r10) {
        return IntProgression.Companion.fromClosedRange(r5, r10, -1);
    }

    public static final LongRange until(long r5, int r10) {
        return new LongRange(r5, ((long) r10) - 1);
    }

    public static long coerceIn(long r5, long r10, long r11) {
        if (r10 > r11) goto L12;
        if (r5 >= r10) goto L8;
        return r10;
    L8:
        if (r5 <= r11) goto L10;
        return r11;
    L10:
        return r5;
    L12:
        throw new IllegalArgumentException(a.t(j0.t(r11, "Cannot coerce value to an empty range: maximum ", " is less than minimum "), r10, '.'));
    }

    public static final LongProgression downTo(int r10, long r11) {
        return LongProgression.Companion.fromClosedRange(r10, r11, -1);
    }

    public static final IntRange until(byte r5, int r10) {
        if (r10 > Integer.MIN_VALUE) goto L7;
        return IntRange.Companion.getEMPTY();
    L7:
        return new IntRange(r5, r10 - 1);
    }

    public static final LongProgression downTo(long r10, long r11) {
        return LongProgression.Companion.fromClosedRange(r10, r11, -1);
    }

    public static final LongProgression downTo(byte r10, long r11) {
        return LongProgression.Companion.fromClosedRange(r10, r11, -1);
    }

    public static final IntRange until(short r5, int r10) {
        if (r10 > Integer.MIN_VALUE) goto L7;
        return IntRange.Companion.getEMPTY();
    L7:
        return new IntRange(r5, r10 - 1);
    }

    public static final LongProgression downTo(short r10, long r11) {
        return LongProgression.Companion.fromClosedRange(r10, r11, -1);
    }

    public static final IntProgression downTo(int r5, short r10) {
        return IntProgression.Companion.fromClosedRange(r5, r10, -1);
    }

    public static final LongRange until(int r5, long r10) {
        if (r10 > Long.MIN_VALUE) goto L7;
        return LongRange.Companion.getEMPTY();
    L7:
        return new LongRange(r5, r10 - 1);
    }

    public static final LongProgression downTo(long r10, short r11) {
        return LongProgression.Companion.fromClosedRange(r10, r11, -1);
    }

    public static final IntProgression downTo(byte r5, short r10) {
        return IntProgression.Companion.fromClosedRange(r5, r10, -1);
    }

    public static final LongRange until(long r5, long r10) {
        if (r10 > Long.MIN_VALUE) goto L7;
        return LongRange.Companion.getEMPTY();
    L7:
        return new LongRange(r5, r10 - 1);
    }

    public static final IntProgression downTo(short r5, short r10) {
        return IntProgression.Companion.fromClosedRange(r5, r10, -1);
    }

    public static final LongRange until(byte r5, long r10) {
        if (r10 > Long.MIN_VALUE) goto L7;
        return LongRange.Companion.getEMPTY();
    L7:
        return new LongRange(r5, r10 - 1);
    }

    public static final LongRange until(short r5, long r10) {
        if (r10 > Long.MIN_VALUE) goto L7;
        return LongRange.Companion.getEMPTY();
    L7:
        return new LongRange(r5, r10 - 1);
    }

    public static float coerceIn(float r5, float r10, float r11) {
        if (r10 > r11) goto L12;
        if (r5 >= r10) goto L8;
        return r10;
    L8:
        if (r5 <= r11) goto L10;
        return r11;
    L10:
        return r5;
    L12:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r11 + " is less than minimum " + r10 + '.');
    }

    public static double coerceIn(double r5, double r10, double r11) {
        if (r10 > r11) goto L12;
        if (r5 >= r10) goto L8;
        return r10;
    L8:
        if (r5 <= r11) goto L10;
        return r11;
    L10:
        return r5;
    L12:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r11 + " is less than minimum " + r10 + '.');
    }

    public static final IntRange until(int r5, short r10) {
        return new IntRange(r5, r10 - 1);
    }

    @SinceKotlin(version = "1.1")
    public static final <T extends Comparable<? super T>> T coerceIn(T r5, ClosedFloatingPointRange<T> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "range");
        if (r10.isEmpty() == true) goto L16;
        if (r10.lessThanOrEquals(r5, r10.getStart()) == false) goto L10;
        if (r10.lessThanOrEquals(r10.getStart(), r5) == true) goto L10;
        return r10.getStart();
    L10:
        if (r10.lessThanOrEquals(r10.getEndInclusive(), r5) == true) goto L12;
        return r5;
    L12:
        if (r10.lessThanOrEquals(r5, r10.getEndInclusive()) == false) goto L14;
        return r5;
    L14:
        return r10.getEndInclusive();
    L16:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + r10 + '.');
    }

    public static final LongRange until(long r5, short r10) {
        return new LongRange(r5, ((long) r10) - 1);
    }

    public static final IntRange until(byte r5, short r10) {
        return new IntRange(r5, r10 - 1);
    }

    public static final IntRange until(short r5, short r10) {
        return new IntRange(r5, r10 - 1);
    }

    public static final <T extends Comparable<? super T>> T coerceIn(T r5, ClosedRange<T> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "range");
        if ((r10 instanceof ClosedFloatingPointRange) == false) goto L7;
        return (T) coerceIn(r5, (ClosedFloatingPointRange) r10);
    L7:
        if (r10.isEmpty() == true) goto L16;
        if (r5.compareTo(r10.getStart()) >= 0) goto L12;
        return (T) r10.getStart();
    L12:
        if (r5.compareTo(r10.getEndInclusive()) > 0) goto L14;
        return r5;
    L14:
        return (T) r10.getEndInclusive();
    L16:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + r10 + '.');
    }

    public static final int coerceIn(int r5, ClosedRange<Integer> r10) {
        Intrinsics.checkNotNullParameter(r10, "range");
        if ((r10 instanceof ClosedFloatingPointRange) == false) goto L7;
        return ((Number) coerceIn(Integer.valueOf(r5), (ClosedFloatingPointRange) r10)).intValue();
    L7:
        if (r10.isEmpty() == true) goto L16;
        if (r5 >= ((Number) r10.getStart()).intValue()) goto L12;
        return ((Number) r10.getStart()).intValue();
    L12:
        if (r5 > ((Number) r10.getEndInclusive()).intValue()) goto L14;
        return r5;
    L14:
        return ((Number) r10.getEndInclusive()).intValue();
    L16:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + r10 + '.');
    }

    public static long coerceIn(long r5, ClosedRange<Long> r10) {
        Intrinsics.checkNotNullParameter(r10, "range");
        if ((r10 instanceof ClosedFloatingPointRange) == false) goto L7;
        return ((Number) coerceIn(Long.valueOf(r5), (ClosedFloatingPointRange) r10)).longValue();
    L7:
        if (r10.isEmpty() == true) goto L16;
        if (r5 >= ((Number) r10.getStart()).longValue()) goto L12;
        return ((Number) r10.getStart()).longValue();
    L12:
        if (r5 > ((Number) r10.getEndInclusive()).longValue()) goto L14;
        return r5;
    L14:
        return ((Number) r10.getEndInclusive()).longValue();
    L16:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + r10 + '.');
    }
}
