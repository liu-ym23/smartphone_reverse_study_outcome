package com.obric.aiproactive.impl.bridge;

import androidx.core.app.NotificationCompat;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import okio.Utf8;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 )2\u00020\u0001:\u0003'()B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010J(\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J\u001e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J9\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010!\u001a\u0004\u0018\u00010\u00102\b\u0010\"\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010#J\u0012\u0010$\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010%\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/obric/aiproactive/impl/bridge/RemoteArtifactDownloader;", "", "resolver", "Lcom/obric/aiproactive/impl/bridge/RemoteHostResolver;", NotificationCompat.CATEGORY_TRANSPORT, "Lcom/obric/aiproactive/impl/bridge/RemoteArtifactTransport;", "<init>", "(Lcom/obric/aiproactive/impl/bridge/RemoteHostResolver;Lcom/obric/aiproactive/impl/bridge/RemoteArtifactTransport;)V", "download", "Lcom/obric/aiproactive/impl/bridge/RemoteDownloadResult;", "sourceLocator", "", "sourcePolicyKey", "staging", "Ljava/io/File;", "maxBytes", "", "downloadHop", "url", "Lokhttp3/HttpUrl;", "redirects", "", "resolvePublicAddresses", "Lcom/obric/aiproactive/impl/bridge/RemoteArtifactDownloader$AddressResolution;", "host", "execute", "Lcom/obric/aiproactive/impl/bridge/RemoteArtifactDownloader$TransportResult;", "addresses", "", "Ljava/net/InetAddress;", "copyBody", "input", "Ljava/io/InputStream;", "expectedBytes", "contentType", "(Ljava/io/InputStream;Ljava/io/File;JLjava/lang/Long;Ljava/lang/String;)Lcom/obric/aiproactive/impl/bridge/RemoteDownloadResult;", "validateUrl", "failure", "code", "AddressResolution", "TransportResult", "Companion", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f6410a = null;
    private static final Set<Integer> d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m f6411b;
    private final k c;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/obric/aiproactive/impl/bridge/RemoteArtifactDownloader$AddressResolution;", "", "addresses", "", "Ljava/net/InetAddress;", "errorCode", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getAddresses", "()Ljava/util/List;", "getErrorCode", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<InetAddress> f6412a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f6413b;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public a(List<? extends InetAddress> r3, String r4) {
            List<InetAddress> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "addresses");
            Intrinsics.checkNotNullParameter(r4, "errorCode");
            this.f6412a = r5;
            this.f6413b = r4;
        }

        public /* synthetic */ a(List r2, String r3, int r4, DefaultConstructorMarker r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
            if ((r4 & 1) == 0) goto L6;
            r6 = CollectionsKt.emptyList();
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = "";
        L8:
            this(r6, r3);
        }

        public final List<InetAddress> a() {
            return this.f6412a;
        }

        public final String b() {
            return this.f6413b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6412a, r6.f6412a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f6413b, r6.f6413b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f6412a.hashCode() * 31) + this.f6413b.hashCode();
        }

        public String toString() {
            return "AddressResolution(addresses=" + this.f6412a + ", errorCode=" + this.f6413b + ')';
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0010J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/aiproactive/impl/bridge/RemoteArtifactDownloader$Companion;", "", "<init>", "()V", "MAX_REMOTE_URL_CHARS", "", "MAX_REDIRECTS", "HTTPS_PORT", "BYTEIMG_ROOT_HOST", "", "REDIRECT_STATUS_CODES", "", "isPublicAddress", "", MemoryKeyInfoEntity.KEY_ADDRESS, "Ljava/net/InetAddress;", "isPublicAddress$ai_proactive_impl_obricRelease", "isPublicIpv4", "bytes", "", "isPublicIpv6", "hasPrefix", "prefix", "bits", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }

        private final boolean a(byte[] r8) {
            int r0 = r8[0] & 255;
            int r2 = r8[1] & 255;
            if (r0 != 0) goto L5;
            return false;
        L5:
            if (r0 != 10) goto L7;
            return false;
        L7:
            if (r0 != 127) goto L9;
            return false;
        L9:
            if (r0 < 224) goto L12;
            return false;
        L12:
            if (r0 != 100) goto L22;
            if (64 <= r2) goto L16;
        L18:
            boolean r4 = false;
        L19:
            if (r4 == false) goto L22;
            return false;
        L16:
            if (r2 >= 128) goto L18;
            r4 = true;
        L22:
            if (r0 != 169) goto L27;
            if (r2 != 254) goto L27;
            return false;
        L27:
            if (r0 != 172) goto L37;
            if (16 <= r2) goto L31;
        L33:
            boolean r5 = false;
        L34:
            if (r5 == false) goto L37;
            return false;
        L31:
            if (r2 >= 32) goto L33;
            r5 = true;
        L37:
            if (r0 != 192) goto L40;
            if (r2 != 0) goto L40;
            return false;
        L40:
            if (r0 != 192) goto L45;
            if (r2 != 168) goto L45;
            return false;
        L45:
            if (r0 != 192) goto L54;
            if (r2 != 88) goto L54;
            if ((r8[2] & 255) != 99) goto L54;
            if ((r8[3] & 255) != 2) goto L54;
            return false;
        L54:
            if (r0 == 198) goto L56;
        L63:
            if (r0 != 198) goto L70;
            if (r2 != 51) goto L70;
            if ((r8[2] & 255) != 100) goto L70;
            return false;
        L70:
            if (r0 != 203) goto L76;
            if (r2 != 0) goto L76;
            if ((r8[2] & 255) != 113) goto L76;
            return false;
        L76:
            return true;
        L56:
            if (18 <= r2) goto L58;
        L60:
            boolean r6 = false;
        L61:
            if (r6 == false) goto L63;
            return false;
        L58:
            if (r2 >= 20) goto L60;
            r6 = true;
            goto L61
        }

        private final boolean a(byte[] r5, byte[] r6, int r7) {
            int r4 = r7 / 8;
            int r1 = 0;
        L3:
            if (r1 >= r4) goto L8;
            if (r5[r1] != r6[r1]) goto L6;
            r1 = r1 + 1;
            goto L3
        L6:
            return false;
        L8:
            int r8 = r7 % 8;
            if (r8 != 0) goto L11;
            return true;
        L11:
            int r9 = (255 << (8 - r8)) & 255;
            if ((r5[r4] & r9) == (r6[r4] & r9)) goto L14;
            return false;
        L14:
            return true;
        }

        private final boolean b(byte[] r6) {
            if (a(r6, new byte[]{32, 0}, 3) == true) goto L6;
            return false;
        L6:
            if (a(r6, new byte[]{32, 1, 0}, 23) == false) goto L9;
            return false;
        L9:
            if (a(r6, new byte[]{32, 1, 13, -72}, 32) == false) goto L12;
            return false;
        L12:
            if (a(r6, new byte[]{32, 2}, 16) == false) goto L15;
            return false;
        L15:
            if (a(r6, new byte[]{Utf8.REPLACEMENT_BYTE, -1, 0}, 20) == false) goto L17;
            return false;
        L17:
            return true;
        }

        public final boolean a(InetAddress r4) {
            Intrinsics.checkNotNullParameter(r4, MemoryKeyInfoEntity.KEY_ADDRESS);
            if (r4.isAnyLocalAddress() == false) goto L5;
            return false;
        L5:
            if (r4.isLoopbackAddress() == false) goto L7;
            return false;
        L7:
            if (r4.isLinkLocalAddress() == false) goto L9;
            return false;
        L9:
            if (r4.isSiteLocalAddress() == false) goto L11;
            return false;
        L11:
            if (r4.isMulticastAddress() == true) goto L26;
            byte[] r0 = r4.getAddress();
            if (ZeusTransformUtils.instanceOf(r4, Inet4Address.class) == false) goto L17;
            Intrinsics.checkNotNull(r0);
            return a(r0);
        L17:
            if (ZeusTransformUtils.instanceOf(r4, Inet6Address.class) == false) goto L25;
            Intrinsics.checkNotNull(r0);
            return b(r0);
        L25:
            return false;
        L26:
            return false;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/aiproactive/impl/bridge/RemoteArtifactDownloader$TransportResult;", "", ChatMessage.TYPE_RESPONSE, "Lcom/obric/aiproactive/impl/bridge/RemoteArtifactResponse;", "errorCode", "", "<init>", "(Lcom/obric/aiproactive/impl/bridge/RemoteArtifactResponse;Ljava/lang/String;)V", "getResponse", "()Lcom/obric/aiproactive/impl/bridge/RemoteArtifactResponse;", "getErrorCode", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final j f6414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f6415b;

        /* JADX WARN: Multi-variable type inference failed */
        public c() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public c(j r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "errorCode");
            this.f6414a = r2;
            this.f6415b = r3;
        }

        public /* synthetic */ c(j r1, String r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = null;
        L6:
            if ((r3 & 2) == 0) goto L8;
            r2 = "";
        L8:
            this(r1, r2);
        }

        public final j a() {
            return this.f6414a;
        }

        public final String b() {
            return this.f6415b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6414a, r6.f6414a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f6415b, r6.f6415b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            j r0 = this.f6414a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.f6415b.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "TransportResult(response=" + this.f6414a + ", errorCode=" + this.f6415b + ')';
        }
    }

    static {
        f6410a = new b(null);
        d = SetsKt.setOf(new Integer[]{301, 302, 303, 307, 308});
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public h(m r3, k r4) {
        m r5 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        k r6 = (k) ZeusTransformUtils.wrapperContextForParams(r4, k.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "resolver");
        Intrinsics.checkNotNullParameter(r6, NotificationCompat.CATEGORY_TRANSPORT);
        this.f6411b = r5;
        this.c = r6;
    }

    public /* synthetic */ h(m r2, k r3, int r4, DefaultConstructorMarker r5) {
        m r6 = (m) ZeusTransformUtils.wrapperContextForParams(r2, m.class, "com.obric.memorydata.plugin");
        k r7 = (k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = (m) ZeusTransformUtils.preCheckCast(o.f6433a, m.class, "com.obric.memorydata.plugin");
    L6:
        if ((r4 & 2) == 0) goto L8;
        r7 = (k) ZeusTransformUtils.preCheckCast(new g(), k.class, "com.obric.memorydata.plugin");
    L8:
        this(r6, r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final a a(String r7) {
        String r0 = "remote_dns_failed";
        int r1 = 1;
        String r2 = null;
        Object[] r3 = 0;
        Object[] r4 = 0;
        Object[] r5 = 0;
        Object[] r6 = 0;
        Object[] r8 = 0;
        Object[] r9 = 0;
        Object[] r10 = 0;
        List<InetAddress> r11 = this.f6411b.a(r7);     // Catch: SecurityException -> L22 IOException -> L24
    L5:
        if (r11.isEmpty() == true) goto L21;
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        boolean r13 = false;
        if (ZeusTransformUtils.instanceOf(r12, Collection.class) == true) goto L9;
    L11:
        Iterator r14 = r12.iterator();
    L13:
        if (r14.hasNext() == false) goto L17;
        if ((!f6410a.a((InetAddress) ZeusTransformUtils.preCheckCast(r14.next(), InetAddress.class, "com.obric.memorydata.plugin"))) == false) goto L13;
        r13 = true;
    L17:
        if (r13 == true) goto L21;
        return new a(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")), r2, 2, r10 == true ? 1 : 0);
    L9:
        if (((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L11;
    L21:
        return new a(r9 == true ? 1 : 0, "source_address_not_public", r1, r8 == true ? 1 : 0);
    L25:
        return new a(r6 == true ? 1 : 0, r0, r1, r5 == true ? 1 : 0);
    L23:
        return new a(r4 == true ? 1 : 0, r0, r1, r3 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final c a(HttpUrl r5, List<? extends InetAddress> r6) {
        String r0 = "remote_request_failed";
        List<? extends InetAddress> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r1 = 1;
        String r2 = null;
        Object[] r3 = 0;
        Object[] r4 = 0;
        Object[] r8 = 0;
        Object[] r9 = 0;
    L13:
        return new c(this.c.a(r5, r7), r2, 2, r9 == true ? 1 : 0);
    L7:
        Object[] r10 = 0 == true ? 1 : 0;
        return new c(r10, "remote_timeout", r1, r8 == true ? 1 : 0);
    L12:
        return new c(0 == true ? 1 : 0, r0, r1, r4 == true ? 1 : 0);
    L11:
        return new c(0 == true ? 1 : 0, r0, r1, r3 == true ? 1 : 0);
    }

    public static /* synthetic */ l a(h r6, String r7, String r8, File r9, long r10, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L6;
        r10 = 2147483648L;
    L6:
        return r6.a(r7, r8, r9, r10);
    }

    private final l a(File r9, String r10) {
        r9.delete();
        return new l(false, r10, null, 0, 12, null);
    }

    private final l a(InputStream r19, File r20, long r21, Long r23, String r24) {
        Closeable r5 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r20), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37 InterruptedIOException -> L38
        FileOutputStream r6 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r5, FileOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
        byte[] r7 = new byte[8192];     // Catch: Throwable -> L30
        long r14 = 0;
    L5:
        int r9 = r19.read(r7);     // Catch: Throwable -> L30
        if (r9 < 0) goto L14;
        r14 = r14 + ((long) r9);     // Catch: Throwable -> L30
        if (r14 > r21) goto L9;
        r6.write(r7, 0, r9);     // Catch: Throwable -> L30
        goto L5
    L9:
        l r0 = a(r20, "size_limit_exceeded");     // Catch: Throwable -> L30
        CloseableKt.closeFinally(r5, null);     // Catch: Throwable -> L37 Throwable -> L37 InterruptedIOException -> L38
        return r0;
    L14:
        r6.getFD().sync();     // Catch: Throwable -> L30
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L30
        CloseableKt.closeFinally(r5, null);     // Catch: Throwable -> L37 Throwable -> L37 InterruptedIOException -> L38
        if (r23 == null) goto L21;
        if (r14 == r23.longValue()) goto L21;
        return a(r20, "size_mismatch");
    L21:
        if (r24 == null) goto L27;
        String r1 = StringsKt.substringBefore$default(r24, ';', null, 2, null);     // Catch: Throwable -> L37 Throwable -> L37 InterruptedIOException -> L38
        if (r1 == null) goto L27;
        String r2 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).toString();     // Catch: Throwable -> L37 Throwable -> L37 InterruptedIOException -> L38
        if (r2 == null) goto L27;
        Locale r4 = Locale.ROOT;     // Catch: Throwable -> L37 Throwable -> L37 InterruptedIOException -> L38
        Intrinsics.checkNotNullExpressionValue(r4, "ROOT");     // Catch: Throwable -> L37 Throwable -> L37 InterruptedIOException -> L38
        String r3 = r2.toLowerCase(r4);     // Catch: Throwable -> L37 Throwable -> L37 InterruptedIOException -> L38
        Intrinsics.checkNotNullExpressionValue(r3, "toLowerCase(...)");     // Catch: Throwable -> L37 Throwable -> L37 InterruptedIOException -> L38
        String r13 = r3;
    L47:
        return new l(true, null, r13, r14, 2, null);
    L27:
        r13 = null;
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);     // Catch: Throwable -> L37 Throwable -> L37 InterruptedIOException -> L38
        throw th;     // Catch: Throwable -> L37 Throwable -> L37 InterruptedIOException -> L38
    L48:
        return a(r20, "remote_request_failed");
    L39:
        return a(r20, "remote_timeout");
    }

    private final l a(HttpUrl r10, int r11, File r12, long r13) {
        String r0 = a(r10);
        if (r0 != null) goto L5;
        a r1 = a(r10.host());
        boolean r2 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1.b(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L14;
        String r14 = r1.b();
    L13:
        return a(r12, r14);
    L14:
        c r4 = a(r10, r1.a());
        j r5 = r4.a();
        if (r5 != null) goto L72;
        r14 = r4.b();
        goto L13
    L72:
    L69:
        th = move-exception;
        r5.close();
        throw th;
    L18:
        if (d.contains(Integer.valueOf(r5.a())) == true) goto L20;
        int r15 = r5.a();     // Catch: Throwable -> L69
        if (200 <= r15) goto L42;
    L44:
        boolean r16 = false;
    L45:
        if (r16 == true) goto L50;
        l r9 = a(r12, "remote_http_error");     // Catch: Throwable -> L69
        r5.close();
        return r9;
    L50:
        if (r5.c() <= r13) goto L54;
        l r17 = a(r12, "size_limit_exceeded");     // Catch: Throwable -> L69
        r5.close();
        return r17;
    L54:
        InputStream r18 = r5.e();     // Catch: Throwable -> L69
        if (r18 != null) goto L59;
        l r19 = a(r12, "remote_response_empty");     // Catch: Throwable -> L69
        r5.close();
        return r19;
    L59:
        Long r110 = Long.valueOf(r5.c());     // Catch: Throwable -> L69
        if (((Number) ZeusTransformUtils.preCheckCast(r110, Number.class, "com.obric.memorydata.plugin")).longValue() >= 0) goto L63;
        r2 = false;
    L63:
        if (r2 == true) goto L66;
        r110 = null;
    L66:
        l r20 = a(r18, r12, r13, r110, r5.b());     // Catch: Throwable -> L69
        r5.close();
        return r20;
    L42:
        if (r15 >= 300) goto L44;
        r16 = true;
        goto L45
    L20:
        if (r11 < 3) goto L24;
        l r21 = a(r12, "redirect_limit_exceeded");     // Catch: Throwable -> L69
        r5.close();
        return r21;
    L24:
        String r6 = r5.d();     // Catch: Throwable -> L69
        if (r6 != null) goto L30;
        l r22 = a(r12, "invalid_redirect");     // Catch: Throwable -> L69
        r5.close();
        return r22;
    L30:
        HttpUrl r111 = r10.resolve(r6);     // Catch: Throwable -> L69
        if (r111 != null) goto L36;
        l r23 = a(r12, "invalid_redirect");     // Catch: Throwable -> L69
        r5.close();
        return r23;
    L36:
        l r24 = a(r111, r11 + 1, r12, r13);     // Catch: Throwable -> L69
        r5.close();
        return r24;
    L9:
        r3 = false;
        goto L10
    L5:
        return a(r12, r0);
    }

    private final String a(HttpUrl r4) {
        if (r4.isHttps() == true) goto L7;
        return "source_scheme_not_allowed";
    L7:
        if (r4.port() == 443) goto L11;
        return "source_port_not_allowed";
    L11:
        if (r4.uri().getRawUserInfo() == null) goto L14;
        return "source_userinfo_not_allowed";
    L14:
        String r3 = r4.host();
        Locale r5 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r5, "ROOT");
        String r6 = r3.toLowerCase(r5);
        Intrinsics.checkNotNullExpressionValue(r6, "toLowerCase(...)");
        if (Intrinsics.areEqual(r6, "byteimg.com") == false) goto L17;
    L20:
        return null;
    L17:
        if (StringsKt.endsWith$default(r6, ".byteimg.com", false, 2, null) == true) goto L20;
        return "source_host_not_allowed";
    }

    public final l a(String r7, String r8, File r9, long r10) {
        Intrinsics.checkNotNullParameter(r7, "sourceLocator");
        Intrinsics.checkNotNullParameter(r8, "sourcePolicyKey");
        Intrinsics.checkNotNullParameter(r9, "staging");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L30;
        if (Intrinsics.areEqual(r7, StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).toString()) == false) goto L30;
        if (r7.length() > 4096) goto L30;
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r1 = false;
        int r2 = 0;
    L10:
        if (r2 >= r0.length()) goto L15;
        if (Character.isISOControl(r0.charAt(r2)) == true) goto L13;
        r2 = r2 + 1;
        goto L10
    L13:
        r1 = true;
    L15:
        if (r1 == true) goto L30;
        if (r10 < 0) goto L30;
        if (Intrinsics.areEqual(r8, "byteimg_media_v1") == false) goto L22;
        HttpUrl r3 = HttpUrl.Companion.parse(r7);
        if (r3 != null) goto L28;
        return a(r9, "invalid_remote_url");
    L28:
        return a(r3, 0, r9, r10);
    L22:
        return a(r9, "unsupported_source_policy");
    L30:
        return a(r9, "invalid_request");
    }
}
