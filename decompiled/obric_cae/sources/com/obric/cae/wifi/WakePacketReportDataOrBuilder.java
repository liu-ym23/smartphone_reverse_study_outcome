package com.obric.cae.wifi;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface WakePacketReportDataOrBuilder extends MessageOrBuilder {
    int getDelayedPktCount();

    String getDeviceDate();

    ByteString getDeviceDateBytes();

    long getDeviceTime();

    String getDstIp();

    ByteString getDstIpBytes();

    int getDstPort();

    int getDstType();

    String getDstTypeStr();

    ByteString getDstTypeStrBytes();

    String getEventType();

    ByteString getEventTypeBytes();

    int getIpProtocol();

    String getIpProtocolStr();

    ByteString getIpProtocolStrBytes();

    int getPacketLen();

    int getPacketType();

    String getPacketTypeStr();

    ByteString getPacketTypeStrBytes();

    String getProtocolName();

    ByteString getProtocolNameBytes();

    int getProtocolType();

    ByteString getRawFrame();

    int getRawFrameLen();

    boolean getRawFrameTruncated();

    String getServiceName();

    ByteString getServiceNameBytes();

    String getSrcIp();

    ByteString getSrcIpBytes();

    int getSrcPort();

    int getVdevId();

    int getWakeReason();

    String getWakeReasonStr();

    ByteString getWakeReasonStrBytes();

    boolean hasDelayedPktCount();

    boolean hasDeviceDate();

    boolean hasDeviceTime();

    boolean hasDstIp();

    boolean hasDstPort();

    boolean hasDstType();

    boolean hasDstTypeStr();

    boolean hasEventType();

    boolean hasIpProtocol();

    boolean hasIpProtocolStr();

    boolean hasPacketLen();

    boolean hasPacketType();

    boolean hasPacketTypeStr();

    boolean hasProtocolName();

    boolean hasProtocolType();

    boolean hasRawFrame();

    boolean hasRawFrameLen();

    boolean hasRawFrameTruncated();

    boolean hasServiceName();

    boolean hasSrcIp();

    boolean hasSrcPort();

    boolean hasVdevId();

    boolean hasWakeReason();

    boolean hasWakeReasonStr();
}
