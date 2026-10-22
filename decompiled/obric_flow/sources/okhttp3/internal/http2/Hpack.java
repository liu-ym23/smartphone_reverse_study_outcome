package okhttp3.internal.http2;

import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import f4.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nu.c0;
import nu.j;
import nu.l;
import okhttp3.internal.Util;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lokhttp3/internal/http2/Hpack;", "", "()V", "NAME_TO_FIRST_INDEX", "", "Lokio/ByteString;", "", "getNAME_TO_FIRST_INDEX", "()Ljava/util/Map;", "PREFIX_4_BITS", "PREFIX_5_BITS", "PREFIX_6_BITS", "PREFIX_7_BITS", "SETTINGS_HEADER_TABLE_SIZE", "SETTINGS_HEADER_TABLE_SIZE_LIMIT", "STATIC_HEADER_TABLE", "", "Lokhttp3/internal/http2/Header;", "getSTATIC_HEADER_TABLE", "()[Lokhttp3/internal/http2/Header;", "[Lokhttp3/internal/http2/Header;", "checkLowercase", "name", "nameToFirstIndex", "Reader", "Writer", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Hpack {
    public static final Hpack INSTANCE = null;
    private static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX = null;
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
    private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
    private static final Header[] STATIC_HEADER_TABLE = null;

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u000fJ\u0017\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0015\u0010\u000bJ\u0017\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0012J\u000f\u0010\u0018\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0018\u0010\u000bJ\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010!\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0004H\u0002¢\u0006\u0004\b#\u0010$J\u0013\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001f0%¢\u0006\u0004\b&\u0010'J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010$J\r\u0010(\u001a\u00020\t¢\u0006\u0004\b(\u0010\u000bJ\u001d\u0010+\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0004¢\u0006\u0004\b+\u0010,J\r\u0010-\u001a\u00020\u0019¢\u0006\u0004\b-\u0010.R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u001f0/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u0010\u0003\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00103R\u001e\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b9\u00108R\u0016\u0010:\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b:\u00108R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00108R\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u00108¨\u0006;"}, d2 = {"Lokhttp3/internal/http2/Hpack$Reader;", "", "Lnu/c0;", "source", "", "headerTableSizeSetting", "maxDynamicTableByteCount", "<init>", "(Lnu/c0;II)V", "", "adjustDynamicTableByteCount", "()V", "clearDynamicTable", "bytesToRecover", "evictToRecoverBytes", "(I)I", "index", "readIndexedHeader", "(I)V", "dynamicTableIndex", "readLiteralHeaderWithoutIndexingIndexedName", "readLiteralHeaderWithoutIndexingNewName", "nameIndex", "readLiteralHeaderWithIncrementalIndexingIndexedName", "readLiteralHeaderWithIncrementalIndexingNewName", "Lokio/ByteString;", "getName", "(I)Lokio/ByteString;", "", "isStaticHeader", "(I)Z", "Lokhttp3/internal/http2/Header;", "entry", "insertIntoDynamicTable", "(ILokhttp3/internal/http2/Header;)V", "readByte", "()I", "", "getAndResetHeaderList", "()Ljava/util/List;", "readHeaders", "firstByte", "prefixMask", "readInt", "(II)I", "readByteString", "()Lokio/ByteString;", "", "headerList", "Ljava/util/List;", "Lnu/l;", "Lnu/l;", "", "dynamicTable", "[Lokhttp3/internal/http2/Header;", "nextHeaderIndex", "I", "headerCount", "dynamicTableByteCount", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Reader {

        @JvmField
        public Header[] dynamicTable;

        @JvmField
        public int dynamicTableByteCount;

        @JvmField
        public int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final l source;

        @JvmOverloads
        public Reader(c0 r10, int r11) {
            int r5 = 0;
            this(r10, r11, r5, 4, null);
        }

        private final void adjustDynamicTableByteCount() {
            int r5 = this.maxDynamicTableByteCount;
            int r10 = this.dynamicTableByteCount;
            if (r5 >= r10) goto L8;
            if (r5 != 0) goto L6;
            clearDynamicTable();
            return;
        L6:
            evictToRecoverBytes(r10 - r5);
            return;
        }

        private final void clearDynamicTable() {
            ArraysKt.j(this.dynamicTable, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int dynamicTableIndex(int r5) {
            return (this.nextHeaderIndex + 1) + r5;
        }

        private final int evictToRecoverBytes(int r5) {
            int r10 = 0;
            if (r5 <= 0) goto L10;
            int r11 = this.dynamicTable.length;
        L5:
            r11 = r11 - 1;
            int r12 = this.nextHeaderIndex;
            if (r11 < r12) goto L9;
            if (r5 <= 0) goto L9;
            Header r13 = this.dynamicTable[r11];
            Intrinsics.checkNotNull(r13);
            int r14 = r13.hpackSize;
            r5 = r5 - r14;
            this.dynamicTableByteCount -= r14;
            this.headerCount--;
            r10 = r10 + 1;
        L9:
            Header[] r15 = this.dynamicTable;
            System.arraycopy(r15, r12 + 1, r15, (r12 + 1) + r10, this.headerCount);
            this.nextHeaderIndex += r10;
        L10:
            return r10;
        }

        private final ByteString getName(int r5) throws IOException {
            if (isStaticHeader(r5) == true) goto L13;
            int r10 = dynamicTableIndex(r5 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (r10 < 0) goto L12;
            Header[] r11 = this.dynamicTable;
            if (r10 >= r11.length) goto L12;
            Header r12 = r11[r10];
            Intrinsics.checkNotNull(r12);
            return r12.name;
        L12:
            throw new IOException("Header index too large " + (r5 + 1));
        L13:
            return Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[r5].name;
        }

        private final void insertIntoDynamicTable(int r10, Header r11) {
            this.headerList.add(r11);
            int r5 = r11.hpackSize;
            if (r10 == (-1)) goto L5;
            Header r12 = this.dynamicTable[dynamicTableIndex(r10)];
            Intrinsics.checkNotNull(r12);
            r5 = r5 - r12.hpackSize;
        L5:
            int r13 = this.maxDynamicTableByteCount;
            if (r5 <= r13) goto L9;
            clearDynamicTable();
            return;
        L9:
            int r14 = evictToRecoverBytes((this.dynamicTableByteCount + r5) - r13);
            if (r10 != (-1)) goto L15;
            int r15 = this.headerCount + 1;
            Header[] r16 = this.dynamicTable;
            if (r15 <= r16.length) goto L14;
            Header[] r17 = new Header[r16.length * 2];
            System.arraycopy(r16, 0, r17, r16.length, r16.length);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.dynamicTable = r17;
        L14:
            int r18 = this.nextHeaderIndex;
            this.nextHeaderIndex = r18 - 1;
            this.dynamicTable[r18] = r11;
            this.headerCount++;
        L16:
            this.dynamicTableByteCount += r5;
            return;
        L15:
            this.dynamicTable[(dynamicTableIndex(r10) + r14) + r10] = r11;
            goto L16
        }

        private final boolean isStaticHeader(int r5) {
            if (r5 >= 0) goto L4;
        L6:
            return false;
        L4:
            if (r5 > (Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length - 1)) goto L6;
            return true;
        }

        private final int readByte() throws IOException {
            return Util.and(this.source.readByte(), 255);
        }

        private final void readIndexedHeader(int r5) throws IOException {
            if (isStaticHeader(r5) == false) goto L5;
            this.headerList.add(Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[r5]);
            return;
        L5:
            int r10 = dynamicTableIndex(r5 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (r10 < 0) goto L12;
            Header[] r11 = this.dynamicTable;
            if (r10 >= r11.length) goto L12;
            List<Header> r12 = this.headerList;
            Header r13 = r11[r10];
            Intrinsics.checkNotNull(r13);
            r12.add(r13);
            return;
        L12:
            throw new IOException("Header index too large " + (r5 + 1));
        }

        private final void readLiteralHeaderWithIncrementalIndexingIndexedName(int r5) throws IOException {
            insertIntoDynamicTable(-1, new Header(getName(r5), readByteString()));
        }

        private final void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            insertIntoDynamicTable(-1, new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingIndexedName(int r5) throws IOException {
            ByteString r10 = getName(r5);
            ByteString r11 = readByteString();
            this.headerList.add(new Header(r10, r11));
        }

        private final void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            ByteString r5 = Hpack.INSTANCE.checkLowercase(readByteString());
            ByteString r10 = readByteString();
            this.headerList.add(new Header(r5, r10));
        }

        public final List<Header> getAndResetHeaderList() {
            List<Header> r5 = CollectionsKt.toList(this.headerList);
            this.headerList.clear();
            return r5;
        }

        public final int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        public final ByteString readByteString() throws IOException {
            int r5 = readByte();
            if ((r5 & 128) != 128) goto L5;
            boolean r10 = true;
        L6:
            long r11 = readInt(r5, 127);
            if (r10 == false) goto L10;
            j r12 = new j();
            Huffman.INSTANCE.decode(this.source, r11, r12);
            return r12.v(r12.f20328b);
        L10:
            return this.source.v(r11);
        L5:
            r10 = false;
            goto L6
        }

        public final void readHeaders() throws IOException {
        L3:
            if (this.source.y() == true) goto L32;
            int r5 = Util.and(this.source.readByte(), 255);
            if (r5 == 128) goto L31;
            if ((r5 & 128) == 128) goto L8;
            if (r5 == 64) goto L11;
            if ((r5 & 64) == 64) goto L14;
            if ((r5 & 32) == 32) goto L17;
            if (r5 == 16) goto L29;
            if (r5 == 0) goto L29;
            readLiteralHeaderWithoutIndexingIndexedName(readInt(r5, 15) - 1);
        L29:
            readLiteralHeaderWithoutIndexingNewName();
            goto L3
        L17:
            int r10 = readInt(r5, 31);
            this.maxDynamicTableByteCount = r10;
            if (r10 < 0) goto L23;
            if (r10 > this.headerTableSizeSetting) goto L23;
            adjustDynamicTableByteCount();
        L23:
            throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
        L14:
            readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(r5, 63) - 1);
            goto L3
        L11:
            readLiteralHeaderWithIncrementalIndexingNewName();
            goto L3
        L8:
            readIndexedHeader(readInt(r5, 127) - 1);
            goto L3
        L31:
            throw new IOException("index == 0");
        }

        public final int readInt(int r5, int r10) throws IOException {
            int r11 = r5 & r10;
            if (r11 >= r10) goto L5;
            return r11;
        L5:
            int r12 = 0;
        L6:
            int r13 = readByte();
            if ((r13 & 128) == 0) goto L10;
            r10 = r10 + ((r13 & 127) << r12);
            r12 = r12 + 7;
            goto L6
        L10:
            return r10 + (r13 << r12);
        }

        @JvmOverloads
        public Reader(c0 r5, int r10, int r11) {
            Intrinsics.checkNotNullParameter(r5, "source");
            this.headerTableSizeSetting = r10;
            this.maxDynamicTableByteCount = r11;
            this.headerList = new ArrayList();
            this.source = b.e(r5);
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = 7;
        }

        public /* synthetic */ Reader(c0 r5, int r10, int r11, int r12, DefaultConstructorMarker r13) {
            if ((r12 & 4) == 0) goto L5;
            r11 = r10;
        L5:
            this(r5, r10, r11);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\fJ\u001b\u0010\u0017\u001a\u00020\n2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b(\u0010%R\u001e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100)8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010%R\u0016\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b-\u0010%R\u0016\u0010.\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b.\u0010%R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010%R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010'R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010/¨\u00060"}, d2 = {"Lokhttp3/internal/http2/Hpack$Writer;", "", "", "headerTableSizeSetting", "", "useCompression", "Lnu/j;", "out", "<init>", "(IZLnu/j;)V", "", "clearDynamicTable", "()V", "bytesToRecover", "evictToRecoverBytes", "(I)I", "Lokhttp3/internal/http2/Header;", "entry", "insertIntoDynamicTable", "(Lokhttp3/internal/http2/Header;)V", "adjustDynamicTableByteCount", "", "headerBlock", "writeHeaders", "(Ljava/util/List;)V", "value", "prefixMask", "bits", "writeInt", "(III)V", "Lokio/ByteString;", "data", "writeByteString", "(Lokio/ByteString;)V", "resizeHeaderTable", "(I)V", "smallestHeaderTableSizeSetting", "I", "emitDynamicTableSizeUpdate", "Z", "maxDynamicTableByteCount", "", "dynamicTable", "[Lokhttp3/internal/http2/Header;", "nextHeaderIndex", "headerCount", "dynamicTableByteCount", "Lnu/j;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Writer {

        @JvmField
        public Header[] dynamicTable;

        @JvmField
        public int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;

        @JvmField
        public int headerCount;

        @JvmField
        public int headerTableSizeSetting;

        @JvmField
        public int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final j out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        @JvmOverloads
        public Writer(int r10, j r11) {
            boolean r5 = false;
            this(r10, r5, r11, 2, null);
        }

        private final void adjustDynamicTableByteCount() {
            int r5 = this.maxDynamicTableByteCount;
            int r10 = this.dynamicTableByteCount;
            if (r5 >= r10) goto L8;
            if (r5 != 0) goto L6;
            clearDynamicTable();
            return;
        L6:
            evictToRecoverBytes(r10 - r5);
            return;
        }

        private final void clearDynamicTable() {
            ArraysKt.j(this.dynamicTable, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int evictToRecoverBytes(int r5) {
            int r10 = 0;
            if (r5 <= 0) goto L10;
            int r11 = this.dynamicTable.length;
        L5:
            r11 = r11 - 1;
            int r12 = this.nextHeaderIndex;
            if (r11 < r12) goto L9;
            if (r5 <= 0) goto L9;
            Header r13 = this.dynamicTable[r11];
            Intrinsics.checkNotNull(r13);
            r5 = r5 - r13.hpackSize;
            int r14 = this.dynamicTableByteCount;
            Header r15 = this.dynamicTable[r11];
            Intrinsics.checkNotNull(r15);
            this.dynamicTableByteCount = r14 - r15.hpackSize;
            this.headerCount--;
            r10 = r10 + 1;
        L9:
            Header[] r16 = this.dynamicTable;
            System.arraycopy(r16, r12 + 1, r16, (r12 + 1) + r10, this.headerCount);
            Header[] r17 = this.dynamicTable;
            int r18 = this.nextHeaderIndex;
            Arrays.fill(r17, r18 + 1, (r18 + 1) + r10, null);
            this.nextHeaderIndex += r10;
        L10:
            return r10;
        }

        private final void insertIntoDynamicTable(Header r10) {
            int r5 = r10.hpackSize;
            int r11 = this.maxDynamicTableByteCount;
            if (r5 <= r11) goto L6;
            clearDynamicTable();
            return;
        L6:
            evictToRecoverBytes((this.dynamicTableByteCount + r5) - r11);
            int r12 = this.headerCount + 1;
            Header[] r13 = this.dynamicTable;
            if (r12 <= r13.length) goto L9;
            Header[] r14 = new Header[r13.length * 2];
            System.arraycopy(r13, 0, r14, r13.length, r13.length);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.dynamicTable = r14;
        L9:
            int r15 = this.nextHeaderIndex;
            this.nextHeaderIndex = r15 - 1;
            this.dynamicTable[r15] = r10;
            this.headerCount++;
            this.dynamicTableByteCount += r5;
        }

        public final void resizeHeaderTable(int r5) {
            this.headerTableSizeSetting = r5;
            int r10 = Math.min(r5, 16384);
            int r11 = this.maxDynamicTableByteCount;
            if (r11 != r10) goto L5;
            return;
        L5:
            if (r10 >= r11) goto L7;
            this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, r10);
        L7:
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = r10;
            adjustDynamicTableByteCount();
        }

        public final void writeByteString(ByteString r10) throws IOException {
            Intrinsics.checkNotNullParameter(r10, "data");
            if (this.useCompression == false) goto L7;
            Huffman r5 = Huffman.INSTANCE;
            if (r5.encodedLength(r10) >= r10.size()) goto L7;
            j r11 = new j();
            r5.encode(r10, r11);
            ByteString r12 = r11.v(r11.f20328b);
            writeInt(r12.size(), 127, 128);
            this.out.Q(r12);
            return;
        L7:
            writeInt(r10.size(), 127, 0);
            this.out.Q(r10);
        }

        public final void writeHeaders(List<Header> r13) throws IOException {
            Intrinsics.checkNotNullParameter(r13, "headerBlock");
            if (this.emitDynamicTableSizeUpdate == false) goto L8;
            int r5 = this.smallestHeaderTableSizeSetting;
            if (r5 >= this.maxDynamicTableByteCount) goto L7;
            writeInt(r5, 31, 32);
        L7:
            this.emitDynamicTableSizeUpdate = false;
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            writeInt(this.maxDynamicTableByteCount, 31, 32);
        L8:
            int r10 = r13.size();
            int r11 = 0;
        L9:
            if (r11 >= r10) goto L48;
            Header r12 = r13.get(r11);
            ByteString r14 = r12.name.toAsciiLowercase();
            ByteString r15 = r12.value;
            Hpack r16 = Hpack.INSTANCE;
            Integer r17 = r16.getNAME_TO_FIRST_INDEX().get(r14);
            if (r17 == null) goto L24;
            int r18 = r17.intValue();
            int r19 = r18 + 1;
            if (2 <= r19) goto L16;
        L23:
            int r20 = r19;
            r19 = -1;
        L25:
            if (r19 != (-1)) goto L36;
            int r21 = this.nextHeaderIndex + 1;
            int r110 = this.dynamicTable.length;
        L27:
            if (r21 >= r110) goto L36;
            Header r111 = this.dynamicTable[r21];
            Intrinsics.checkNotNull(r111);
            if (Intrinsics.areEqual(r111.name, r14) == false) goto L35;
            Header r112 = this.dynamicTable[r21];
            Intrinsics.checkNotNull(r112);
            if (Intrinsics.areEqual(r112.value, r15) == true) goto L32;
            if (r20 != (-1)) goto L35;
            r20 = (r21 - this.nextHeaderIndex) + Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length;
            goto L35
        L32:
            r19 = Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length + (r21 - this.nextHeaderIndex);
        L35:
            r21 = r21 + 1;
        L36:
            if (r19 == (-1)) goto L39;
            writeInt(r19, 127, 128);
        L47:
            r11 = r11 + 1;
            goto L9
        L39:
            if (r20 != (-1)) goto L42;
            this.out.T(64);
            writeByteString(r14);
            writeByteString(r15);
            insertIntoDynamicTable(r12);
            goto L47
        L42:
            if (r14.startsWith(Header.PSEUDO_PREFIX) == true) goto L44;
        L46:
            writeInt(r20, 63, 64);
            writeByteString(r15);
            insertIntoDynamicTable(r12);
            goto L47
        L44:
            if (Intrinsics.areEqual(Header.TARGET_AUTHORITY, r14) == true) goto L46;
            writeInt(r20, 15, 0);
            writeByteString(r15);
            goto L47
        L16:
            if (7 < r19) goto L23;
            if (Intrinsics.areEqual(r16.getSTATIC_HEADER_TABLE()[r18].value, r15) == false) goto L21;
            r20 = r19;
            goto L25
        L21:
            if (Intrinsics.areEqual(r16.getSTATIC_HEADER_TABLE()[r19].value, r15) == false) goto L23;
            r20 = r19;
            r19 = r18 + 2;
            goto L25
        L24:
            r20 = -1;
            r19 = -1;
            goto L25
        }

        public final void writeInt(int r5, int r10, int r11) {
            if (r5 >= r10) goto L5;
            this.out.T(r5 | r11);
            return;
        L5:
            this.out.T(r11 | r10);
            int r12 = r5 - r10;
        L7:
            if (r12 < 128) goto L9;
            this.out.T(128 | (r12 & 127));
            r12 = r12 >>> 7;
            goto L7
        L9:
            this.out.T(r12);
        }

        @JvmOverloads
        public Writer(j r10) {
            int r5 = 0;
            boolean r11 = false;
            this(r5, r11, r10, 3, null);
        }

        @JvmOverloads
        public Writer(int r5, boolean r10, j r11) {
            Intrinsics.checkNotNullParameter(r11, "out");
            this.headerTableSizeSetting = r5;
            this.useCompression = r10;
            this.out = r11;
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            this.maxDynamicTableByteCount = r5;
            Header[] r12 = new Header[8];
            this.dynamicTable = r12;
            this.nextHeaderIndex = r12.length - 1;
        }

        public /* synthetic */ Writer(int r5, boolean r10, j r11, int r12, DefaultConstructorMarker r13) {
            if ((r12 & 1) == 0) goto L6;
            r5 = 4096;
        L6:
            if ((r12 & 2) == 0) goto L8;
            r10 = true;
        L8:
            this(r5, r10, r11);
        }
    }

    static {
        Hpack r5 = new Hpack();
        INSTANCE = r5;
        Header r10 = new Header(Header.TARGET_AUTHORITY, "");
        ByteString r11 = Header.TARGET_METHOD;
        Header r12 = new Header(r11, "GET");
        Header r13 = new Header(r11, "POST");
        ByteString r14 = Header.TARGET_PATH;
        Header r15 = new Header(r14, "/");
        Header r16 = new Header(r14, "/index.html");
        ByteString r17 = Header.TARGET_SCHEME;
        Header r18 = new Header(r17, "http");
        Header r19 = new Header(r17, IIvyAIPackageResourceService.SCHEMA);
        ByteString r110 = Header.RESPONSE_STATUS;
        STATIC_HEADER_TABLE = new Header[]{r10, r12, r13, r15, r16, r18, r19, new Header(r110, "200"), new Header(r110, "204"), new Header(r110, "206"), new Header(r110, "304"), new Header(r110, "400"), new Header(r110, "404"), new Header(r110, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
        NAME_TO_FIRST_INDEX = r5.nameToFirstIndex();
    }

    private Hpack() {
    }

    private final Map<ByteString, Integer> nameToFirstIndex() {
        Header[] r5 = STATIC_HEADER_TABLE;
        LinkedHashMap r10 = new LinkedHashMap(r5.length);
        int r11 = r5.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        Header[] r13 = STATIC_HEADER_TABLE;
        if (r10.containsKey(r13[r12].name) == true) goto L7;
        r10.put(r13[r12].name, Integer.valueOf(r12));
    L7:
        r12 = r12 + 1;
        goto L3
    L9:
        return Collections.unmodifiableMap(r10);
    }

    public final ByteString checkLowercase(ByteString r5) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "name");
        int r10 = r5.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L11;
        byte r12 = (byte) 65;
        byte r13 = (byte) 90;
        byte r14 = r5.getByte(r11);
        if (r12 > r14) goto L8;
        if (r13 < r14) goto L8;
        throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + r5.utf8());
    L8:
        r11 = r11 + 1;
        goto L3
    L11:
        return r5;
    }

    public final Map<ByteString, Integer> getNAME_TO_FIRST_INDEX() {
        return NAME_TO_FIRST_INDEX;
    }

    public final Header[] getSTATIC_HEADER_TABLE() {
        return STATIC_HEADER_TABLE;
    }
}
