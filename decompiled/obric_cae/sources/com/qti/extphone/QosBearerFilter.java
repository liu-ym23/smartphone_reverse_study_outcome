package com.qti.extphone;

import android.aimedia.a;
import android.hardware.radio.V1_6.MaybePort;
import android.hardware.radio.V1_6.QosFilter;
import android.net.InetAddresses;
import android.net.LinkAddress;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.protobuf.e;
import defpackage.b;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class QosBearerFilter implements Parcelable {
    public static final Parcelable.Creator<QosBearerFilter> CREATOR = null;
    public static final int QOS_FILTER_DIRECTION_BIDIRECTIONAL = 2;
    public static final int QOS_FILTER_DIRECTION_DOWNLINK = 0;
    public static final int QOS_FILTER_DIRECTION_UPLINK = 1;
    public static final int QOS_MAX_PORT = 65535;
    public static final int QOS_MIN_PORT = 20;
    public static final int QOS_PROTOCOL_AH = 51;
    public static final int QOS_PROTOCOL_ESP = 50;
    public static final int QOS_PROTOCOL_TCP = 6;
    public static final int QOS_PROTOCOL_UDP = 17;
    public static final int QOS_PROTOCOL_UNSPECIFIED = -1;

    @QosBearerFilterDirection
    private int filterDirection;
    private long flowLabel;
    private List<LinkAddress> localAddresses;
    private PortRange localPort;
    private int precedence;

    @QosProtocol
    private int protocol;
    private List<LinkAddress> remoteAddresses;
    private PortRange remotePort;
    private long securityParameterIndex;
    private int typeOfServiceMask;

    public static class PortRange implements Parcelable {
        public static final Parcelable.Creator<PortRange> CREATOR = null;
        int end;
        int start;

        static {
            CREATOR = new AnonymousClass1();
        }

        public PortRange() {
            this.start = -1;
            this.end = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if (r8 != null) goto L8;
        L17:
            return false;
        L8:
            if ((r8 instanceof PortRange) == false) goto L17;
            PortRange r10 = (PortRange) r8;
            if (this.start != r10.start) goto L16;
            if (this.end != r10.end) goto L16;
            return true;
        L16:
            return false;
        }

        public int getEnd() {
            return this.end;
        }

        public int getStart() {
            return this.start;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.start), Integer.valueOf(this.end)});
        }

        public boolean isValid() {
            int r8 = this.start;
            if (r8 >= 20) goto L5;
        L11:
            return false;
        L5:
            if (r8 > 65535) goto L11;
            int r10 = this.end;
            if (r10 < 20) goto L11;
            if (r10 > 65535) goto L11;
            if (r8 > r10) goto L11;
            return true;
        }

        public String toString() {
            StringBuilder r8 = new StringBuilder("PortRange { start=");
            r8.append(this.start);
            r8.append(" end=");
            return a.h(r8, this.end, "}");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r8, int r10) {
            r8.writeInt(this.start);
            r8.writeInt(this.end);
        }

        public PortRange(int r8, int r10) {
            this.start = r8;
            this.end = r10;
        }

        private PortRange(Parcel r8) {
            this.start = r8.readInt();
            this.end = r8.readInt();
        }

        public /* synthetic */ PortRange(Parcel r8, int r10) {
            this(r8);
        }
    }

    public @interface QosBearerFilterDirection {
    }

    public @interface QosProtocol {
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public QosBearerFilter() {
        this.localAddresses = new ArrayList();
        this.remoteAddresses = new ArrayList();
        this.localPort = new PortRange();
        this.remotePort = new PortRange();
        this.protocol = -1;
        this.filterDirection = 2;
    }

    public static QosBearerFilter create(QosFilter r8) {
        QosBearerFilter r10 = new QosBearerFilter();
        int r11 = 1;
        String[] r12 = (String[]) r8.localAddresses.stream().toArray(new com.obric.cae.libs.useraware.a(r11));
        int r13 = 0;
        if (r12 == null) goto L7;
        int r14 = r12.length;
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L7;
        r10.localAddresses.add(createLinkAddressFromString(r12[r15]));
        r15 = r15 + 1;
    L7:
        String[] r16 = (String[]) r8.remoteAddresses.stream().toArray(new e(r11));
        if (r16 == null) goto L12;
        int r17 = r16.length;
    L10:
        if (r13 >= r17) goto L12;
        r10.remoteAddresses.add(createLinkAddressFromString(r16[r13]));
        r13 = r13 + 1;
    L12:
        MaybePort r18 = r8.localPort;
        if (r18 != null) goto L15;
    L17:
        MaybePort r19 = r8.remotePort;
        if (r19 != null) goto L20;
    L22:
        r10.protocol = r8.protocol;
        QosFilter.TypeOfService r20 = r8.tos;
        if (r20 != null) goto L25;
    L27:
        QosFilter.Ipv6FlowLabel r21 = r8.flowLabel;
        if (r21 != null) goto L30;
    L32:
        QosFilter.IpsecSpi r22 = r8.spi;
        if (r22 != null) goto L35;
    L37:
        r10.filterDirection = r8.direction;
        r10.precedence = r8.precedence;
        return r10;
    L35:
        if (r22.getDiscriminator() != 1) goto L37;
        r10.securityParameterIndex = r8.spi.value();
        goto L37
    L30:
        if (r21.getDiscriminator() != 1) goto L32;
        r10.flowLabel = r8.flowLabel.value();
        goto L32
    L25:
        if (r20.getDiscriminator() != 1) goto L27;
        r10.typeOfServiceMask = r8.tos.value();
        goto L27
    L20:
        if (r19.getDiscriminator() != 1) goto L22;
        android.hardware.radio.V1_6.PortRange r23 = r8.remotePort.range();
        PortRange r24 = r10.remotePort;
        r24.start = r23.start;
        r24.end = r23.end;
        goto L22
    L15:
        if (r18.getDiscriminator() != 1) goto L17;
        android.hardware.radio.V1_6.PortRange r25 = r8.localPort.range();
        PortRange r26 = r10.localPort;
        r26.start = r25.start;
        r26.end = r25.end;
        goto L17
    }

    private static LinkAddress createLinkAddressFromString(String r11) {
        String r12 = r11.trim();
        String[] r8 = r12.split("/", 2);     // Catch: Throwable -> L15
        InetAddress r10 = InetAddresses.parseNumericAddress(r8[0]);     // Catch: Throwable -> L15
        if (r8.length != 1) goto L10;
        if ((r10 instanceof Inet4Address) == false) goto L8;
        int r13 = 32;
    L14:
        InetAddress r14 = r10;
        int r15 = r13;
    L16:
        if (r14 == null) goto L21;
        if (r15 == (-1)) goto L21;
        return new LinkAddress(r14, r15, 0, 0, -1, -1);
    L21:
        throw new IllegalArgumentException(b.c("Invalid link address ", r12));
    L8:
        r13 = 128;
        goto L14
    L10:
        if (r8.length != 2) goto L13;
        r13 = Integer.parseInt(r8[1]);     // Catch: Throwable -> L15
        goto L14
    L13:
        r13 = -1;
    L15:
        r14 = null;
        r15 = -1;
        goto L16
    }

    private static /* synthetic */ String[] lambda$create$0(int r8) {
        return new String[r8];
    }

    private static /* synthetic */ String[] lambda$create$1(int r8) {
        return new String[r8];
    }

    public static /* synthetic */ String[] t(int r8) {
        return lambda$create$1(r8);
    }

    public static /* synthetic */ String[] u(int r8) {
        return lambda$create$0(r8);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L37:
        return false;
    L8:
        if ((r8 instanceof QosBearerFilter) == false) goto L37;
        QosBearerFilter r10 = (QosBearerFilter) r8;
        if (this.localAddresses.size() != r10.localAddresses.size()) goto L36;
        if (this.localAddresses.containsAll(r10.localAddresses) == false) goto L36;
        if (this.remoteAddresses.size() != r10.remoteAddresses.size()) goto L36;
        if (this.remoteAddresses.containsAll(r10.remoteAddresses) == false) goto L36;
        if (Objects.equals(this.localPort, r10.localPort) == false) goto L36;
        if (Objects.equals(this.remotePort, r10.remotePort) == false) goto L36;
        if (this.protocol != r10.protocol) goto L36;
        if (this.typeOfServiceMask != r10.typeOfServiceMask) goto L36;
        if (this.flowLabel != r10.flowLabel) goto L36;
        if (this.securityParameterIndex != r10.securityParameterIndex) goto L36;
        if (this.filterDirection != r10.filterDirection) goto L36;
        if (this.precedence != r10.precedence) goto L36;
        return true;
    L36:
        return false;
    }

    public int getDirection() {
        return this.filterDirection;
    }

    public long getFlowLabel() {
        return this.flowLabel;
    }

    public List<LinkAddress> getLocalAddresses() {
        return this.localAddresses;
    }

    public PortRange getLocalPortRange() {
        return this.localPort;
    }

    public int getPrecedence() {
        return this.precedence;
    }

    public int getProtocol() {
        return this.protocol;
    }

    public List<LinkAddress> getRemoteAddresses() {
        return this.remoteAddresses;
    }

    public PortRange getRemotePortRange() {
        return this.remotePort;
    }

    public long getSpi() {
        return this.securityParameterIndex;
    }

    public int getTypeOfServiceMask() {
        return this.typeOfServiceMask;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.localAddresses, this.remoteAddresses, this.localPort, this.remotePort, Integer.valueOf(this.protocol), Integer.valueOf(this.typeOfServiceMask), Long.valueOf(this.flowLabel), Long.valueOf(this.securityParameterIndex), Integer.valueOf(this.filterDirection), Integer.valueOf(this.precedence)});
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder("QosBearerFilter { localAddresses=");
        r8.append(this.localAddresses);
        r8.append(" remoteAddresses=");
        r8.append(this.remoteAddresses);
        r8.append(" localPort=");
        r8.append(this.localPort);
        r8.append(" remotePort=");
        r8.append(this.remotePort);
        r8.append(" protocol=");
        r8.append(this.protocol);
        r8.append(" typeOfServiceMask=");
        r8.append(this.typeOfServiceMask);
        r8.append(" flowLabel=");
        r8.append(this.flowLabel);
        r8.append(" securityParameterIndex=");
        r8.append(this.securityParameterIndex);
        r8.append(" filterDirection=");
        r8.append(this.filterDirection);
        r8.append(" precedence=");
        return a.h(r8, this.precedence, "}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeList(this.localAddresses);
        r8.writeList(this.remoteAddresses);
        r8.writeParcelable(this.localPort, r10);
        r8.writeParcelable(this.remotePort, r10);
        r8.writeInt(this.protocol);
        r8.writeInt(this.typeOfServiceMask);
        r8.writeLong(this.flowLabel);
        r8.writeLong(this.securityParameterIndex);
        r8.writeInt(this.filterDirection);
        r8.writeInt(this.precedence);
    }

    private QosBearerFilter(Parcel r8) {
        ArrayList r10 = new ArrayList();
        this.localAddresses = r10;
        r8.readList(r10, LinkAddress.class.getClassLoader());
        ArrayList r11 = new ArrayList();
        this.remoteAddresses = r11;
        r8.readList(r11, LinkAddress.class.getClassLoader());
        this.localPort = (PortRange) r8.readParcelable(PortRange.class.getClassLoader());
        this.remotePort = (PortRange) r8.readParcelable(PortRange.class.getClassLoader());
        this.protocol = r8.readInt();
        this.typeOfServiceMask = r8.readInt();
        this.flowLabel = r8.readLong();
        this.securityParameterIndex = r8.readLong();
        this.filterDirection = r8.readInt();
        this.precedence = r8.readInt();
    }

    public /* synthetic */ QosBearerFilter(Parcel r8, int r10) {
        this(r8);
    }

    public QosBearerFilter(List<LinkAddress> r8, List<LinkAddress> r10, PortRange r11, PortRange r12, @QosProtocol int r13, int r14, long r15, long r16, @QosBearerFilterDirection int r17, int r18) {
        this.localAddresses = r8;
        this.remoteAddresses = r10;
        this.localPort = r11;
        this.remotePort = r12;
        this.protocol = r13;
        this.typeOfServiceMask = r14;
        this.flowLabel = r15;
        this.securityParameterIndex = r16;
        this.filterDirection = r17;
        this.precedence = r18;
    }
}
