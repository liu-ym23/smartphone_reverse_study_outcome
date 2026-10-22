package com.ss.android.lark.export.engine;

import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.Type;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001:\u0001\fB\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/export/engine/EngineProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "engineType", "Lcom/ss/android/lark/export/engine/EngineProperty$EngineType;", "body", "Lokio/ByteString;", "<init>", "(Lcom/ss/android/lark/export/engine/EngineProperty$EngineType;Lokio/ByteString;)V", "getEngineType", "()Lcom/ss/android/lark/export/engine/EngineProperty$EngineType;", "getBody", "()Lokio/ByteString;", "EngineType", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class EngineProperty extends BaseProperty {
    private final ByteString body;
    private final EngineType engineType;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/export/engine/EngineProperty$EngineType;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "MESSAGE", "DOC_COMPONENT", "TURTLE_CANVAS", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum EngineType extends Enum<EngineType> {
        public static final a Companion = null;
        public static final EngineType DOC_COMPONENT = null;
        public static final EngineType MESSAGE = null;
        public static final EngineType TURTLE_CANVAS = null;
        public static final /* synthetic */ EngineType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<EngineType> getEntries() {
            return b;
        }

        static {
            EngineType r0 = new EngineType("MESSAGE", 0, 0);
            MESSAGE = r0;
            EngineType r1 = new EngineType("DOC_COMPONENT", 1, 1);
            DOC_COMPONENT = r1;
            EngineType r3 = new EngineType("TURTLE_CANVAS", 2, 2);
            TURTLE_CANVAS = r3;
            EngineType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new a();
        }

        public static EngineType[] values() {
            return (EngineType[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static EngineType valueOf(String r1) {
            return (EngineType) r27.a.a(EngineType.class, r1);
        }

        public EngineType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public EngineProperty() {
        EngineType r0 = null;
        this(r0, r0, 3, r0);
    }

    public final ByteString getBody() {
        return this.body;
    }

    public final EngineType getEngineType() {
        return this.engineType;
    }

    public EngineProperty(EngineType r2, ByteString r3) {
        Intrinsics.checkNotNullParameter(r2, "engineType");
        super(Type.ENGINE);
        this.engineType = r2;
        this.body = r3;
    }

    public /* synthetic */ EngineProperty(EngineType r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = EngineType.MESSAGE;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = null;
    L8:
        this(r1, r2);
    }
}
