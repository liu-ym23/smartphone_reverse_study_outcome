package com.larus.audioplayer.api.stream;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface IStreamPlayerInterceptor {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/audioplayer/api/stream/IStreamPlayerInterceptor$StreamType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "DOC", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum StreamType extends Enum<StreamType> {
        public static final StreamType DOC = null;
        public static final /* synthetic */ StreamType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String type;

        public static EnumEntries<StreamType> getEntries() {
            return b;
        }

        static {
            StreamType r0 = new StreamType();
            DOC = r0;
            StreamType[] r1 = {r0};
            a = r1;
            b = EnumEntriesKt.enumEntries(r1);
        }

        public StreamType() {
            super("DOC", 0);
            this.type = "AIDoc";
        }

        public static StreamType[] values() {
            return (StreamType[]) a.clone();
        }

        public final String getType() {
            return this.type;
        }

        public static StreamType valueOf(String r1) {
            return (StreamType) a.a(StreamType.class, r1);
        }
    }

    boolean a(JSONObject r1);

    void b();

    StreamType c();
}
