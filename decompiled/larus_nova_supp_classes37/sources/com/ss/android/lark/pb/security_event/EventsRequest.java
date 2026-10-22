package com.ss.android.lark.pb.security_event;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class EventsRequest extends Message<EventsRequest, Builder> {
    public static final ProtoAdapter<EventsRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Event> mEvents;

    public static final class Builder extends Message.Builder<EventsRequest, Builder> {
        public List<Event> mEvents;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public EventsRequest m2171build() {
            return new EventsRequest(this.mEvents, super.buildUnknownFields());
        }

        public Builder() {
            this.mEvents = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2171build();
        }

        public Builder Events(List<Event> r1) {
            Internal.checkElementsNotNull(r1);
            this.mEvents = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_EventsRequest extends ProtoAdapter<EventsRequest> {
        public ProtoAdapter_EventsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, EventsRequest.class);
        }

        public EventsRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mEvents.add((Event) Event.ADAPTER.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m2171build();
        }

        public int encodedSize(EventsRequest r4) {
            return Event.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.mEvents) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2172decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((EventsRequest) r1);
        }

        public void encode(ProtoWriter r4, EventsRequest r5) throws IOException {
            Event.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mEvents);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (EventsRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EventsRequest();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2170newBuilder() {
        Builder r0 = new Builder();
        r0.mEvents = Internal.copyOf("mEvents", this.mEvents);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return EventsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2170newBuilder();
    }

    public EventsRequest(List<Event> r2) {
        this(r2, ByteString.EMPTY);
    }

    public EventsRequest(List<Event> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mEvents = Internal.immutableCopyOf("mEvents", r2);
    }
}
