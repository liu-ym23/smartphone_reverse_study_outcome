package com.ss.android.lark.pb.videochat;

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
public final class SegmentIndex extends Message<SegmentIndex, Builder> {
    public static final ProtoAdapter<SegmentIndex> ADAPTER = null;
    public static final Long DEFAULT_SEGMENT_ID = null;
    private static final long serialVersionUID = 0;
    public final Long msegment_id;
    public final List<Long> msource_indexs;
    public final List<Long> mtarget_indexs;

    public static final class Builder extends Message.Builder<SegmentIndex, Builder> {
        public Long msegment_id;
        public List<Long> msource_indexs;
        public List<Long> mtarget_indexs;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SegmentIndex m3182build() {
            return new SegmentIndex(this.msegment_id, this.msource_indexs, this.mtarget_indexs, super.buildUnknownFields());
        }

        public Builder() {
            this.msource_indexs = Internal.newMutableList();
            this.mtarget_indexs = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3182build();
        }

        public Builder segment_id(Long r1) {
            this.msegment_id = r1;
            return this;
        }

        public Builder source_indexs(List<Long> r1) {
            Internal.checkElementsNotNull(r1);
            this.msource_indexs = r1;
            return this;
        }

        public Builder target_indexs(List<Long> r1) {
            Internal.checkElementsNotNull(r1);
            this.mtarget_indexs = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SegmentIndex extends ProtoAdapter<SegmentIndex> {
        public ProtoAdapter_SegmentIndex() {
            super(FieldEncoding.LENGTH_DELIMITED, SegmentIndex.class);
        }

        public SegmentIndex decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.msegment_id = 0L;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.msegment_id = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.msource_indexs.add((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mtarget_indexs.add((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m3182build();
        }

        public int encodedSize(SegmentIndex r6) {
            Long r0 = r6.msegment_id;
            if (r0 == null) goto L5;
            int r1 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
        L6:
            ProtoAdapter r2 = ProtoAdapter.INT64;
            return ((r1 + r2.asRepeated().encodedSizeWithTag(2, r6.msource_indexs)) + r2.asRepeated().encodedSizeWithTag(3, r6.mtarget_indexs)) + r6.unknownFields().size();
        L5:
            r1 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3183decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SegmentIndex) r1);
        }

        public void encode(ProtoWriter r5, SegmentIndex r6) throws IOException {
            Long r0 = r6.msegment_id;
            if (r0 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r5, 1, r0);
        L5:
            ProtoAdapter r1 = ProtoAdapter.INT64;
            r1.asRepeated().encodeWithTag(r5, 2, r6.msource_indexs);
            r1.asRepeated().encodeWithTag(r5, 3, r6.mtarget_indexs);
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SegmentIndex) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SegmentIndex();
        DEFAULT_SEGMENT_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3181newBuilder() {
        Builder r0 = new Builder();
        r0.msegment_id = this.msegment_id;
        r0.msource_indexs = Internal.copyOf("msource_indexs", this.msource_indexs);
        r0.mtarget_indexs = Internal.copyOf("mtarget_indexs", this.mtarget_indexs);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SegmentIndex.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3181newBuilder();
    }

    public SegmentIndex(Long r2, List<Long> r3, List<Long> r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public SegmentIndex(Long r2, List<Long> r3, List<Long> r4, ByteString r5) {
        super(ADAPTER, r5);
        this.msegment_id = r2;
        this.msource_indexs = Internal.immutableCopyOf("msource_indexs", r3);
        this.mtarget_indexs = Internal.immutableCopyOf("mtarget_indexs", r4);
    }
}
