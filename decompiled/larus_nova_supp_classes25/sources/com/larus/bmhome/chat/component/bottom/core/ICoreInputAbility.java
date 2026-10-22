package com.larus.bmhome.chat.component.bottom.core;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.ViewGroup;
import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.bmhome.chat.MultiAttachmentInfo;
import com.larus.bmhome.chat.adapter.MessageModifyMode;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.taskskill.SkillComponent;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.platform.api.FlowDriveFileSendInfo;
import com.larus.platform.model.EditPos;
import com.larus.platform.model.action.SuggestedAction;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface ICoreInputAbility extends m1a.a {
    public static final a A1 = null;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u001f\u0010\n\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0006\u0010\u000b\u001a\u00020\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\fHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$MessageExtMap;", "Landroid/os/Parcelable;", "extMap", "", "", "<init>", "(Ljava/util/Map;)V", "getExtMap", "()Ljava/util/Map;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class MessageExtMap implements Parcelable {
        public static final Parcelable.Creator<MessageExtMap> CREATOR = null;
        public final Map<String, String> a;

        public static final class a implements Parcelable.Creator<MessageExtMap> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final MessageExtMap createFromParcel(Parcel r6) {
                Intrinsics.checkNotNullParameter(r6, "parcel");
                int r0 = r6.readInt();
                LinkedHashMap r1 = new LinkedHashMap(r0);
                int r2 = 0;
            L3:
                if (r2 == r0) goto L6;
                r1.put(r6.readString(), r6.readString());
                r2 = r2 + 1;
                goto L3
            L6:
                return new MessageExtMap(r1);
            }

            @Override // android.os.Parcelable.Creator
            public final MessageExtMap[] newArray(int r1) {
                return new MessageExtMap[r1];
            }
        }

        static {
            CREATOR = new a();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof MessageExtMap) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((MessageExtMap) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "MessageExtMap(extMap=" + this.a + ')';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "dest");
            Map<String, String> r5 = this.a;
            r3.writeInt(r5.size());
            Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            Map.Entry<String, String> r0 = r6.next();
            r3.writeString(r0.getKey());
            r3.writeString(r0.getValue());
            goto L4
        }

        public MessageExtMap(Map<String, String> r2) {
            Intrinsics.checkNotNullParameter(r2, "extMap");
            this.a = r2;
        }
    }

    @Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\bK\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u00ad\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+\u0012\u0018\b\u0002\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f\u0012\u0018\b\u0002\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/¢\u0006\u0004\b0\u00101J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0017\u0010[\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0003J\u0010\u0010\\\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010=J\u0010\u0010]\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010=J\t\u0010^\u001a\u00020\u0011HÆ\u0003J\t\u0010_\u001a\u00020\u000eHÆ\u0003J\t\u0010`\u001a\u00020\u0003HÆ\u0003J\t\u0010a\u001a\u00020\u000eHÆ\u0003J\t\u0010b\u001a\u00020\u000eHÆ\u0003J\t\u0010c\u001a\u00020\u000eHÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001aHÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010h\u001a\u00020\u000eHÆ\u0003J\t\u0010i\u001a\u00020\u0003HÆ\u0003J\u0017\u0010j\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010 HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010o\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010=J\u000b\u0010p\u001a\u0004\u0018\u00010&HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010(HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010+HÆ\u0003J\u0019\u0010t\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\fHÆ\u0003J\u0019\u0010u\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\fHÆ\u0003J\u0010\u0010v\u001a\u0004\u0018\u00010/HÆ\u0003¢\u0006\u0002\u0010TJÀ\u0003\u0010w\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u000e2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u000e2\b\b\u0002\u0010\u001d\u001a\u00020\u00032\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\u0018\b\u0002\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f2\u0018\b\u0002\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/HÆ\u0001¢\u0006\u0002\u0010xJ\u0013\u0010y\u001a\u00020\u000e2\b\u0010z\u001a\u0004\u0018\u00010{HÖ\u0003J\t\u0010|\u001a\u00020\u0011HÖ\u0001J\t\u0010}\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u00103R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u001f\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010>\u001a\u0004\b\r\u0010=R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010>\u001a\u0004\b\u000f\u0010=R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0011\u0010\u0012\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u00103R\u0011\u0010\u0014\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bD\u0010BR\u0011\u0010\u0015\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010BR\u0011\u0010\u0016\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010BR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bE\u00103R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u00103R\u0018\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u00103R\u001e\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0013\u0010!\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bJ\u00103R\u0013\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bK\u00103R\u0013\u0010#\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bL\u00103R\u0015\u0010$\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010>\u001a\u0004\bM\u0010=R\u0013\u0010%\u001a\u0004\u0018\u00010&¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0013\u0010'\u001a\u0004\u0018\u00010(¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0013\u0010)\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bR\u00103R\u0012\u0010*\u001a\u0004\u0018\u00010+8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R \u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R \u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0015\u0010.\u001a\u0004\u0018\u00010/¢\u0006\n\n\u0002\u0010U\u001a\u0004\bS\u0010T¨\u0006~"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "Ljava/io/Serializable;", "content", "", "hint", "attachment", "Lcom/larus/bmhome/view/AttachmentInfo;", "multiAttachment", "Lcom/larus/bmhome/chat/MultiAttachmentInfo;", "referenceInfo", "Lcom/larus/im/bean/message/ReferenceInfo;", "actionBarInstructionMap", "", "isShowFullInputBox", "", "isUseFullInputBox", "actionInstruction", "", "localIntercepted", "localInterceptInfo", "textFromAudio", "isReedit", "isInquiryText", "selectionTextAction", "lyricCreateType", "attachmentLocalMsgIds", "", "textLocalMsgId", "clearInputContent", "enterMethod", "messageExt", "suggestedAction", "Lcom/larus/platform/model/action/SuggestedAction;", "scene", "txtScene", "previousPage", "voiceMixInput", "customMultiAttachment", "Lcom/larus/bmhome/chat/CustomMultiAttachmentInfo;", "driveFileSendInfo", "Lcom/larus/platform/api/FlowDriveFileSendInfo;", "creationSendTraceId", "chatPageContext", "Lcom/larus/bmhome/chat/bean/ChatPageContext;", "fileForceTraceMap", "textForceTraceMap", "sendClickTimestamp", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/view/AttachmentInfo;Lcom/larus/bmhome/chat/MultiAttachmentInfo;Lcom/larus/im/bean/message/ReferenceInfo;Ljava/util/Map;Ljava/lang/Boolean;Ljava/lang/Boolean;IZLjava/lang/String;ZZZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;Ljava/util/Map;Lcom/larus/platform/model/action/SuggestedAction;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/CustomMultiAttachmentInfo;Lcom/larus/platform/api/FlowDriveFileSendInfo;Ljava/lang/String;Lcom/larus/bmhome/chat/bean/ChatPageContext;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Long;)V", "getContent", "()Ljava/lang/String;", "getHint", "getAttachment", "()Lcom/larus/bmhome/view/AttachmentInfo;", "getMultiAttachment", "()Lcom/larus/bmhome/chat/MultiAttachmentInfo;", "getReferenceInfo", "()Lcom/larus/im/bean/message/ReferenceInfo;", "getActionBarInstructionMap", "()Ljava/util/Map;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getActionInstruction", "()I", "getLocalIntercepted", "()Z", "getLocalInterceptInfo", "getTextFromAudio", "getSelectionTextAction", "getLyricCreateType", "getEnterMethod", "getSuggestedAction", "()Lcom/larus/platform/model/action/SuggestedAction;", "getScene", "getTxtScene", "getPreviousPage", "getVoiceMixInput", "getCustomMultiAttachment", "()Lcom/larus/bmhome/chat/CustomMultiAttachmentInfo;", "getDriveFileSendInfo", "()Lcom/larus/platform/api/FlowDriveFileSendInfo;", "getCreationSendTraceId", "getSendClickTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/view/AttachmentInfo;Lcom/larus/bmhome/chat/MultiAttachmentInfo;Lcom/larus/im/bean/message/ReferenceInfo;Ljava/util/Map;Ljava/lang/Boolean;Ljava/lang/Boolean;IZLjava/lang/String;ZZZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;Ljava/util/Map;Lcom/larus/platform/model/action/SuggestedAction;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/CustomMultiAttachmentInfo;Lcom/larus/platform/api/FlowDriveFileSendInfo;Ljava/lang/String;Lcom/larus/bmhome/chat/bean/ChatPageContext;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Long;)Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "equals", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class OnSendParams implements Serializable {
        private final Map<String, String> actionBarInstructionMap;
        private final int actionInstruction;
        private final AttachmentInfo attachment;
        public final List<String> attachmentLocalMsgIds;
        public final ChatPageContext chatPageContext;
        public final boolean clearInputContent;
        private final String content;
        private final String creationSendTraceId;
        private final CustomMultiAttachmentInfo customMultiAttachment;
        private final FlowDriveFileSendInfo driveFileSendInfo;
        private final String enterMethod;
        public final Map<String, String> fileForceTraceMap;
        private final String hint;
        private final boolean isInquiryText;
        private final boolean isReedit;
        private final Boolean isShowFullInputBox;
        private final Boolean isUseFullInputBox;
        private final String localInterceptInfo;
        private final boolean localIntercepted;
        private final String lyricCreateType;
        public final Map<String, String> messageExt;
        private final MultiAttachmentInfo multiAttachment;
        private final String previousPage;
        private final ReferenceInfo referenceInfo;
        private final String scene;
        private final String selectionTextAction;
        private final Long sendClickTimestamp;
        private final SuggestedAction suggestedAction;
        public final Map<String, String> textForceTraceMap;
        private final boolean textFromAudio;
        public final String textLocalMsgId;
        private final String txtScene;
        private final Boolean voiceMixInput;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ OnSendParams copy$default(OnSendParams r17, String r18, String r19, AttachmentInfo r20, MultiAttachmentInfo r21, ReferenceInfo r22, Map r23, Boolean r24, Boolean r25, int r26, boolean r27, String r28, boolean r29, boolean r30, boolean r31, String r32, String r33, List r34, String r35, boolean r36, String r37, Map r38, SuggestedAction r39, String r40, String r41, String r42, Boolean r43, CustomMultiAttachmentInfo r44, FlowDriveFileSendInfo r45, String r46, ChatPageContext r47, Map r48, Map r49, Long r50, int r51, int r52, Object r53) {
            if ((r51 & 1) == 0) goto L5;
            String r2 = r17.content;
        L7:
            if ((r51 & 2) == 0) goto L9;
            String r3 = r17.hint;
        L11:
            if ((r51 & 4) == 0) goto L13;
            AttachmentInfo r4 = r17.attachment;
        L15:
            if ((r51 & 8) == 0) goto L17;
            MultiAttachmentInfo r5 = r17.multiAttachment;
        L19:
            if ((r51 & 16) == 0) goto L21;
            ReferenceInfo r6 = r17.referenceInfo;
        L23:
            if ((r51 & 32) == 0) goto L25;
            Map r7 = r17.actionBarInstructionMap;
        L27:
            if ((r51 & 64) == 0) goto L29;
            Boolean r8 = r17.isShowFullInputBox;
        L31:
            if ((r51 & 128) == 0) goto L33;
            Boolean r9 = r17.isUseFullInputBox;
        L35:
            if ((r51 & 256) == 0) goto L37;
            int r10 = r17.actionInstruction;
        L39:
            if ((r51 & 512) == 0) goto L41;
            boolean r11 = r17.localIntercepted;
        L43:
            if ((r51 & 1024) == 0) goto L45;
            String r12 = r17.localInterceptInfo;
        L47:
            if ((r51 & 2048) == 0) goto L49;
            boolean r13 = r17.textFromAudio;
        L51:
            if ((r51 & 4096) == 0) goto L53;
            boolean r14 = r17.isReedit;
        L55:
            if ((r51 & 8192) == 0) goto L57;
            boolean r15 = r17.isInquiryText;
        L58:
            boolean r310 = r15;
            if ((r51 & 16384) == 0) goto L61;
            String r16 = r17.selectionTextAction;
        L62:
            String r311 = r16;
            if ((r51 & 32768) == 0) goto L65;
            String r110 = r17.lyricCreateType;
        L66:
            String r312 = r110;
            if ((r51 & 65536) == 0) goto L69;
            List r111 = r17.attachmentLocalMsgIds;
        L70:
            List r313 = r111;
            if ((r51 & 131072) == 0) goto L73;
            String r112 = r17.textLocalMsgId;
        L74:
            String r314 = r112;
            if ((r51 & 262144) == 0) goto L77;
            boolean r113 = r17.clearInputContent;
        L78:
            boolean r315 = r113;
            if ((r51 & 524288) == 0) goto L81;
            String r114 = r17.enterMethod;
        L82:
            String r316 = r114;
            if ((r51 & 1048576) == 0) goto L85;
            Map r115 = r17.messageExt;
        L86:
            Map r317 = r115;
            if ((r51 & 2097152) == 0) goto L89;
            SuggestedAction r116 = r17.suggestedAction;
        L90:
            SuggestedAction r318 = r116;
            if ((r51 & 4194304) == 0) goto L93;
            String r117 = r17.scene;
        L94:
            String r410 = r117;
            if ((r51 & 8388608) == 0) goto L97;
            String r118 = r17.txtScene;
        L98:
            String r411 = r118;
            if ((r51 & 16777216) == 0) goto L101;
            String r119 = r17.previousPage;
        L102:
            String r412 = r119;
            if ((r51 & 33554432) == 0) goto L105;
            Boolean r120 = r17.voiceMixInput;
        L106:
            Boolean r413 = r120;
            if ((r51 & 67108864) == 0) goto L109;
            CustomMultiAttachmentInfo r121 = r17.customMultiAttachment;
        L110:
            CustomMultiAttachmentInfo r414 = r121;
            if ((r51 & 134217728) == 0) goto L113;
            FlowDriveFileSendInfo r122 = r17.driveFileSendInfo;
        L114:
            FlowDriveFileSendInfo r415 = r122;
            if ((r51 & 268435456) == 0) goto L117;
            String r123 = r17.creationSendTraceId;
        L118:
            String r416 = r123;
            if ((r51 & 536870912) == 0) goto L121;
            ChatPageContext r124 = r17.chatPageContext;
        L122:
            ChatPageContext r417 = r124;
            if ((r51 & 1073741824) == 0) goto L125;
            Map r125 = r17.fileForceTraceMap;
        L127:
            if ((r51 & Integer.MIN_VALUE) == 0) goto L129;
            Map r1 = r17.textForceTraceMap;
        L130:
            Map r418 = r1;
            if ((r52 & 1) == 0) goto L133;
            Long r54 = r17.sendClickTimestamp;
        L135:
            return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r413, r414, r415, r416, r417, r125, r418, r54);
        L133:
            r54 = r50;
            goto L135
        L129:
            r1 = r49;
            goto L130
        L125:
            r125 = r48;
            goto L127
        L121:
            r124 = r47;
            goto L122
        L117:
            r123 = r46;
            goto L118
        L113:
            r122 = r45;
            goto L114
        L109:
            r121 = r44;
            goto L110
        L105:
            r120 = r43;
            goto L106
        L101:
            r119 = r42;
            goto L102
        L97:
            r118 = r41;
            goto L98
        L93:
            r117 = r40;
            goto L94
        L89:
            r116 = r39;
            goto L90
        L85:
            r115 = r38;
            goto L86
        L81:
            r114 = r37;
            goto L82
        L77:
            r113 = r36;
            goto L78
        L73:
            r112 = r35;
            goto L74
        L69:
            r111 = r34;
            goto L70
        L65:
            r110 = r33;
            goto L66
        L61:
            r16 = r32;
            goto L62
        L57:
            r15 = r31;
            goto L58
        L53:
            r14 = r30;
            goto L55
        L49:
            r13 = r29;
            goto L51
        L45:
            r12 = r28;
            goto L47
        L41:
            r11 = r27;
            goto L43
        L37:
            r10 = r26;
            goto L39
        L33:
            r9 = r25;
            goto L35
        L29:
            r8 = r24;
            goto L31
        L25:
            r7 = r23;
            goto L27
        L21:
            r6 = r22;
            goto L23
        L17:
            r5 = r21;
            goto L19
        L13:
            r4 = r20;
            goto L15
        L9:
            r3 = r19;
            goto L11
        L5:
            r2 = r18;
            goto L7
        }

        public final String component1() {
            return this.content;
        }

        public final boolean component10() {
            return this.localIntercepted;
        }

        public final String component11() {
            return this.localInterceptInfo;
        }

        public final boolean component12() {
            return this.textFromAudio;
        }

        public final boolean component13() {
            return this.isReedit;
        }

        public final boolean component14() {
            return this.isInquiryText;
        }

        public final String component15() {
            return this.selectionTextAction;
        }

        public final String component16() {
            return this.lyricCreateType;
        }

        public final List<String> component17() {
            return this.attachmentLocalMsgIds;
        }

        public final String component18() {
            return this.textLocalMsgId;
        }

        public final boolean component19() {
            return this.clearInputContent;
        }

        public final String component2() {
            return this.hint;
        }

        public final String component20() {
            return this.enterMethod;
        }

        public final Map<String, String> component21() {
            return this.messageExt;
        }

        public final SuggestedAction component22() {
            return this.suggestedAction;
        }

        public final String component23() {
            return this.scene;
        }

        public final String component24() {
            return this.txtScene;
        }

        public final String component25() {
            return this.previousPage;
        }

        public final Boolean component26() {
            return this.voiceMixInput;
        }

        public final CustomMultiAttachmentInfo component27() {
            return this.customMultiAttachment;
        }

        public final FlowDriveFileSendInfo component28() {
            return this.driveFileSendInfo;
        }

        public final String component29() {
            return this.creationSendTraceId;
        }

        public final AttachmentInfo component3() {
            return this.attachment;
        }

        public final ChatPageContext component30() {
            return this.chatPageContext;
        }

        public final Map<String, String> component31() {
            return this.fileForceTraceMap;
        }

        public final Map<String, String> component32() {
            return this.textForceTraceMap;
        }

        public final Long component33() {
            return this.sendClickTimestamp;
        }

        public final MultiAttachmentInfo component4() {
            return this.multiAttachment;
        }

        public final ReferenceInfo component5() {
            return this.referenceInfo;
        }

        public final Map<String, String> component6() {
            return this.actionBarInstructionMap;
        }

        public final Boolean component7() {
            return this.isShowFullInputBox;
        }

        public final Boolean component8() {
            return this.isUseFullInputBox;
        }

        public final int component9() {
            return this.actionInstruction;
        }

        public final OnSendParams copy(String r37, String r38, AttachmentInfo r39, MultiAttachmentInfo r40, ReferenceInfo r41, Map<String, String> r42, Boolean r43, Boolean r44, int r45, boolean r46, String r47, boolean r48, boolean r49, boolean r50, String r51, String r52, List<String> r53, String r54, boolean r55, String r56, Map<String, String> r57, SuggestedAction r58, String r59, String r60, String r61, Boolean r62, CustomMultiAttachmentInfo r63, FlowDriveFileSendInfo r64, String r65, ChatPageContext r66, Map<String, String> r67, Map<String, String> r68, Long r69) {
            Intrinsics.checkNotNullParameter(r37, "content");
            Intrinsics.checkNotNullParameter(r38, "hint");
            Intrinsics.checkNotNullParameter(r47, "localInterceptInfo");
            Intrinsics.checkNotNullParameter(r56, "enterMethod");
            return new OnSendParams(r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof OnSendParams) == true) goto L8;
            return false;
        L8:
            OnSendParams r6 = (OnSendParams) r5;
            if (Intrinsics.areEqual(this.content, r6.content) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.hint, r6.hint) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.attachment, r6.attachment) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.multiAttachment, r6.multiAttachment) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.referenceInfo, r6.referenceInfo) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.actionBarInstructionMap, r6.actionBarInstructionMap) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.isShowFullInputBox, r6.isShowFullInputBox) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.isUseFullInputBox, r6.isUseFullInputBox) == true) goto L33;
            return false;
        L33:
            if (this.actionInstruction == r6.actionInstruction) goto L36;
            return false;
        L36:
            if (this.localIntercepted == r6.localIntercepted) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.localInterceptInfo, r6.localInterceptInfo) == true) goto L42;
            return false;
        L42:
            if (this.textFromAudio == r6.textFromAudio) goto L45;
            return false;
        L45:
            if (this.isReedit == r6.isReedit) goto L48;
            return false;
        L48:
            if (this.isInquiryText == r6.isInquiryText) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.selectionTextAction, r6.selectionTextAction) == true) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.lyricCreateType, r6.lyricCreateType) == true) goto L57;
            return false;
        L57:
            if (Intrinsics.areEqual(this.attachmentLocalMsgIds, r6.attachmentLocalMsgIds) == true) goto L60;
            return false;
        L60:
            if (Intrinsics.areEqual(this.textLocalMsgId, r6.textLocalMsgId) == true) goto L63;
            return false;
        L63:
            if (this.clearInputContent == r6.clearInputContent) goto L66;
            return false;
        L66:
            if (Intrinsics.areEqual(this.enterMethod, r6.enterMethod) == true) goto L69;
            return false;
        L69:
            if (Intrinsics.areEqual(this.messageExt, r6.messageExt) == true) goto L72;
            return false;
        L72:
            if (Intrinsics.areEqual(this.suggestedAction, r6.suggestedAction) == true) goto L75;
            return false;
        L75:
            if (Intrinsics.areEqual(this.scene, r6.scene) == true) goto L78;
            return false;
        L78:
            if (Intrinsics.areEqual(this.txtScene, r6.txtScene) == true) goto L81;
            return false;
        L81:
            if (Intrinsics.areEqual(this.previousPage, r6.previousPage) == true) goto L84;
            return false;
        L84:
            if (Intrinsics.areEqual(this.voiceMixInput, r6.voiceMixInput) == true) goto L87;
            return false;
        L87:
            if (Intrinsics.areEqual(this.customMultiAttachment, r6.customMultiAttachment) == true) goto L90;
            return false;
        L90:
            if (Intrinsics.areEqual(this.driveFileSendInfo, r6.driveFileSendInfo) == true) goto L93;
            return false;
        L93:
            if (Intrinsics.areEqual(this.creationSendTraceId, r6.creationSendTraceId) == true) goto L96;
            return false;
        L96:
            if (Intrinsics.areEqual(this.chatPageContext, r6.chatPageContext) == true) goto L99;
            return false;
        L99:
            if (Intrinsics.areEqual(this.fileForceTraceMap, r6.fileForceTraceMap) == true) goto L102;
            return false;
        L102:
            if (Intrinsics.areEqual(this.textForceTraceMap, r6.textForceTraceMap) == true) goto L105;
            return false;
        L105:
            if (Intrinsics.areEqual(this.sendClickTimestamp, r6.sendClickTimestamp) == true) goto L107;
            return false;
        L107:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.content.hashCode() * 31) + this.hint.hashCode()) * 31;
            AttachmentInfo r1 = this.attachment;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            MultiAttachmentInfo r5 = this.multiAttachment;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            ReferenceInfo r8 = this.referenceInfo;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            Map<String, String> r11 = this.actionBarInstructionMap;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            Boolean r14 = this.isShowFullInputBox;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            Boolean r17 = this.isUseFullInputBox;
            if (r17 != null) goto L25;
            int r18 = 0;
        L26:
            int r19 = (((r16 + r18) * 31) + this.actionInstruction) * 31;
            int r20 = 1231;
            if (this.localIntercepted == false) goto L29;
            int r21 = 1231;
        L30:
            int r22 = (((r19 + r21) * 31) + this.localInterceptInfo.hashCode()) * 31;
            if (this.textFromAudio == false) goto L33;
            int r23 = 1231;
        L34:
            int r24 = (r22 + r23) * 31;
            if (this.isReedit == false) goto L37;
            int r25 = 1231;
        L38:
            int r26 = (r24 + r25) * 31;
            if (this.isInquiryText == false) goto L41;
            int r27 = 1231;
        L42:
            int r28 = (r26 + r27) * 31;
            String r29 = this.selectionTextAction;
            if (r29 != null) goto L45;
            int r30 = 0;
        L46:
            int r31 = (r28 + r30) * 31;
            String r32 = this.lyricCreateType;
            if (r32 != null) goto L49;
            int r33 = 0;
        L50:
            int r34 = (r31 + r33) * 31;
            List<String> r35 = this.attachmentLocalMsgIds;
            if (r35 != null) goto L53;
            int r36 = 0;
        L54:
            int r37 = (r34 + r36) * 31;
            String r38 = this.textLocalMsgId;
            if (r38 != null) goto L57;
            int r39 = 0;
        L58:
            int r40 = (r37 + r39) * 31;
            if (this.clearInputContent == true) goto L62;
            r20 = 1237;
        L62:
            int r41 = (((r40 + r20) * 31) + this.enterMethod.hashCode()) * 31;
            Map<String, String> r42 = this.messageExt;
            if (r42 != null) goto L65;
            int r43 = 0;
        L66:
            int r44 = (r41 + r43) * 31;
            SuggestedAction r45 = this.suggestedAction;
            if (r45 != null) goto L69;
            int r46 = 0;
        L70:
            int r47 = (r44 + r46) * 31;
            String r48 = this.scene;
            if (r48 != null) goto L73;
            int r49 = 0;
        L74:
            int r50 = (r47 + r49) * 31;
            String r51 = this.txtScene;
            if (r51 != null) goto L77;
            int r52 = 0;
        L78:
            int r53 = (r50 + r52) * 31;
            String r54 = this.previousPage;
            if (r54 != null) goto L81;
            int r55 = 0;
        L82:
            int r56 = (r53 + r55) * 31;
            Boolean r57 = this.voiceMixInput;
            if (r57 != null) goto L85;
            int r58 = 0;
        L86:
            int r59 = (r56 + r58) * 31;
            CustomMultiAttachmentInfo r60 = this.customMultiAttachment;
            if (r60 != null) goto L89;
            int r61 = 0;
        L90:
            int r62 = (r59 + r61) * 31;
            FlowDriveFileSendInfo r63 = this.driveFileSendInfo;
            if (r63 != null) goto L93;
            int r64 = 0;
        L94:
            int r65 = (r62 + r64) * 31;
            String r66 = this.creationSendTraceId;
            if (r66 != null) goto L97;
            int r67 = 0;
        L98:
            int r68 = (r65 + r67) * 31;
            ChatPageContext r69 = this.chatPageContext;
            if (r69 != null) goto L101;
            int r70 = 0;
        L102:
            int r71 = (r68 + r70) * 31;
            Map<String, String> r72 = this.fileForceTraceMap;
            if (r72 != null) goto L105;
            int r73 = 0;
        L106:
            int r74 = (r71 + r73) * 31;
            Map<String, String> r75 = this.textForceTraceMap;
            if (r75 != null) goto L109;
            int r76 = 0;
        L110:
            int r77 = (r74 + r76) * 31;
            Long r78 = this.sendClickTimestamp;
            if (r78 == null) goto L115;
            r2 = r78.hashCode();
        L115:
            return r77 + r2;
        L109:
            r76 = r75.hashCode();
            goto L110
        L105:
            r73 = r72.hashCode();
            goto L106
        L101:
            r70 = r69.hashCode();
            goto L102
        L97:
            r67 = r66.hashCode();
            goto L98
        L93:
            r64 = r63.hashCode();
            goto L94
        L89:
            r61 = r60.hashCode();
            goto L90
        L85:
            r58 = r57.hashCode();
            goto L86
        L81:
            r55 = r54.hashCode();
            goto L82
        L77:
            r52 = r51.hashCode();
            goto L78
        L73:
            r49 = r48.hashCode();
            goto L74
        L69:
            r46 = r45.hashCode();
            goto L70
        L65:
            r43 = r42.hashCode();
            goto L66
        L57:
            r39 = r38.hashCode();
            goto L58
        L53:
            r36 = r35.hashCode();
            goto L54
        L49:
            r33 = r32.hashCode();
            goto L50
        L45:
            r30 = r29.hashCode();
            goto L46
        L41:
            r27 = 1237;
            goto L42
        L37:
            r25 = 1237;
            goto L38
        L33:
            r23 = 1237;
            goto L34
        L29:
            r21 = 1237;
            goto L30
        L25:
            r18 = r17.hashCode();
            goto L26
        L21:
            r15 = r14.hashCode();
            goto L22
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "OnSendParams(content=" + this.content + ", hint=" + this.hint + ", attachment=" + this.attachment + ", multiAttachment=" + this.multiAttachment + ", referenceInfo=" + this.referenceInfo + ", actionBarInstructionMap=" + this.actionBarInstructionMap + ", isShowFullInputBox=" + this.isShowFullInputBox + ", isUseFullInputBox=" + this.isUseFullInputBox + ", actionInstruction=" + this.actionInstruction + ", localIntercepted=" + this.localIntercepted + ", localInterceptInfo=" + this.localInterceptInfo + ", textFromAudio=" + this.textFromAudio + ", isReedit=" + this.isReedit + ", isInquiryText=" + this.isInquiryText + ", selectionTextAction=" + this.selectionTextAction + ", lyricCreateType=" + this.lyricCreateType + ", attachmentLocalMsgIds=" + this.attachmentLocalMsgIds + ", textLocalMsgId=" + this.textLocalMsgId + ", clearInputContent=" + this.clearInputContent + ", enterMethod=" + this.enterMethod + ", messageExt=" + this.messageExt + ", suggestedAction=" + this.suggestedAction + ", scene=" + this.scene + ", txtScene=" + this.txtScene + ", previousPage=" + this.previousPage + ", voiceMixInput=" + this.voiceMixInput + ", customMultiAttachment=" + this.customMultiAttachment + ", driveFileSendInfo=" + this.driveFileSendInfo + ", creationSendTraceId=" + this.creationSendTraceId + ", chatPageContext=" + this.chatPageContext + ", fileForceTraceMap=" + this.fileForceTraceMap + ", textForceTraceMap=" + this.textForceTraceMap + ", sendClickTimestamp=" + this.sendClickTimestamp + ')';
        }

        public final Map<String, String> getActionBarInstructionMap() {
            return this.actionBarInstructionMap;
        }

        public final int getActionInstruction() {
            return this.actionInstruction;
        }

        public final AttachmentInfo getAttachment() {
            return this.attachment;
        }

        public final String getContent() {
            return this.content;
        }

        public final String getCreationSendTraceId() {
            return this.creationSendTraceId;
        }

        public final CustomMultiAttachmentInfo getCustomMultiAttachment() {
            return this.customMultiAttachment;
        }

        public final FlowDriveFileSendInfo getDriveFileSendInfo() {
            return this.driveFileSendInfo;
        }

        public final String getEnterMethod() {
            return this.enterMethod;
        }

        public final String getHint() {
            return this.hint;
        }

        public final String getLocalInterceptInfo() {
            return this.localInterceptInfo;
        }

        public final boolean getLocalIntercepted() {
            return this.localIntercepted;
        }

        public final String getLyricCreateType() {
            return this.lyricCreateType;
        }

        public final MultiAttachmentInfo getMultiAttachment() {
            return this.multiAttachment;
        }

        public final String getPreviousPage() {
            return this.previousPage;
        }

        public final ReferenceInfo getReferenceInfo() {
            return this.referenceInfo;
        }

        public final String getScene() {
            return this.scene;
        }

        public final String getSelectionTextAction() {
            return this.selectionTextAction;
        }

        public final Long getSendClickTimestamp() {
            return this.sendClickTimestamp;
        }

        public final SuggestedAction getSuggestedAction() {
            return this.suggestedAction;
        }

        public final boolean getTextFromAudio() {
            return this.textFromAudio;
        }

        public final String getTxtScene() {
            return this.txtScene;
        }

        public final Boolean getVoiceMixInput() {
            return this.voiceMixInput;
        }

        public final boolean isInquiryText() {
            return this.isInquiryText;
        }

        public final boolean isReedit() {
            return this.isReedit;
        }

        public final Boolean isShowFullInputBox() {
            return this.isShowFullInputBox;
        }

        public final Boolean isUseFullInputBox() {
            return this.isUseFullInputBox;
        }

        public OnSendParams(String r7, String r8, AttachmentInfo r9, MultiAttachmentInfo r10, ReferenceInfo r11, Map<String, String> r12, Boolean r13, Boolean r14, int r15, boolean r16, String r17, boolean r18, boolean r19, boolean r20, String r21, String r22, List<String> r23, String r24, boolean r25, String r26, Map<String, String> r27, SuggestedAction r28, String r29, String r30, String r31, Boolean r32, CustomMultiAttachmentInfo r33, FlowDriveFileSendInfo r34, String r35, ChatPageContext r36, Map<String, String> r37, Map<String, String> r38, Long r39) {
            Intrinsics.checkNotNullParameter(r7, "content");
            Intrinsics.checkNotNullParameter(r8, "hint");
            Intrinsics.checkNotNullParameter(r17, "localInterceptInfo");
            Intrinsics.checkNotNullParameter(r26, "enterMethod");
            this.content = r7;
            this.hint = r8;
            this.attachment = r9;
            this.multiAttachment = r10;
            this.referenceInfo = r11;
            this.actionBarInstructionMap = r12;
            this.isShowFullInputBox = r13;
            this.isUseFullInputBox = r14;
            this.actionInstruction = r15;
            this.localIntercepted = r16;
            this.localInterceptInfo = r17;
            this.textFromAudio = r18;
            this.isReedit = r19;
            this.isInquiryText = r20;
            this.selectionTextAction = r21;
            this.lyricCreateType = r22;
            this.attachmentLocalMsgIds = r23;
            this.textLocalMsgId = r24;
            this.clearInputContent = r25;
            this.enterMethod = r26;
            this.messageExt = r27;
            this.suggestedAction = r28;
            this.scene = r29;
            this.txtScene = r30;
            this.previousPage = r31;
            this.voiceMixInput = r32;
            this.customMultiAttachment = r33;
            this.driveFileSendInfo = r34;
            this.creationSendTraceId = r35;
            this.chatPageContext = r36;
            this.fileForceTraceMap = r37;
            this.textForceTraceMap = r38;
            this.sendClickTimestamp = r39;
        }

        public /* synthetic */ OnSendParams(String r38, String r39, AttachmentInfo r40, MultiAttachmentInfo r41, ReferenceInfo r42, Map r43, Boolean r44, Boolean r45, int r46, boolean r47, String r48, boolean r49, boolean r50, boolean r51, String r52, String r53, List r54, String r55, boolean r56, String r57, Map r58, SuggestedAction r59, String r60, String r61, String r62, Boolean r63, CustomMultiAttachmentInfo r64, FlowDriveFileSendInfo r65, String r66, ChatPageContext r67, Map r68, Map r69, Long r70, int r71, int r72, DefaultConstructorMarker r73) {
            if ((r71 & 32) == 0) goto L5;
            Map r9 = null;
        L7:
            if ((r71 & 64) == 0) goto L9;
            Boolean r10 = Boolean.FALSE;
        L11:
            if ((r71 & 128) == 0) goto L13;
            Boolean r11 = Boolean.FALSE;
        L15:
            if ((r71 & 512) == 0) goto L17;
            boolean r13 = false;
        L19:
            if ((r71 & 1024) == 0) goto L21;
            String r14 = "";
        L23:
            if ((r71 & 2048) == 0) goto L25;
            boolean r15 = false;
        L27:
            if ((r71 & 4096) == 0) goto L29;
            boolean r16 = false;
        L31:
            if ((r71 & 8192) == 0) goto L33;
            boolean r17 = false;
        L35:
            if ((r71 & 16384) == 0) goto L37;
            String r18 = null;
        L39:
            if ((32768 & r71) == 0) goto L41;
            String r19 = "";
        L43:
            if ((65536 & r71) == 0) goto L45;
            List r20 = null;
        L47:
            if ((131072 & r71) == 0) goto L49;
            String r21 = null;
        L51:
            if ((262144 & r71) == 0) goto L53;
            boolean r22 = true;
        L55:
            if ((524288 & r71) == 0) goto L57;
            String r23 = "";
        L59:
            if ((1048576 & r71) == 0) goto L61;
            Map r24 = null;
        L63:
            if ((2097152 & r71) == 0) goto L65;
            SuggestedAction r25 = null;
        L67:
            if ((4194304 & r71) == 0) goto L69;
            String r26 = null;
        L71:
            if ((8388608 & r71) == 0) goto L73;
            String r27 = null;
        L75:
            if ((16777216 & r71) == 0) goto L77;
            String r28 = null;
        L79:
            if ((33554432 & r71) == 0) goto L81;
            Boolean r29 = null;
        L83:
            if ((67108864 & r71) == 0) goto L85;
            CustomMultiAttachmentInfo r30 = null;
        L87:
            if ((134217728 & r71) == 0) goto L89;
            FlowDriveFileSendInfo r31 = null;
        L91:
            if ((268435456 & r71) == 0) goto L93;
            String r32 = null;
        L95:
            if ((536870912 & r71) == 0) goto L97;
            ChatPageContext r33 = null;
        L99:
            if ((1073741824 & r71) == 0) goto L101;
            Map r34 = null;
        L103:
            if ((r71 & Integer.MIN_VALUE) == 0) goto L105;
            Map r35 = null;
        L107:
            if ((r72 & 1) == 0) goto L109;
            Long r36 = null;
        L110:
            this(r38, r39, r40, r41, r42, r9, r10, r11, r46, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36);
            return;
        L109:
            r36 = r70;
            goto L110
        L105:
            r35 = r69;
            goto L107
        L101:
            r34 = r68;
            goto L103
        L97:
            r33 = r67;
            goto L99
        L93:
            r32 = r66;
            goto L95
        L89:
            r31 = r65;
            goto L91
        L85:
            r30 = r64;
            goto L87
        L81:
            r29 = r63;
            goto L83
        L77:
            r28 = r62;
            goto L79
        L73:
            r27 = r61;
            goto L75
        L69:
            r26 = r60;
            goto L71
        L65:
            r25 = r59;
            goto L67
        L61:
            r24 = r58;
            goto L63
        L57:
            r23 = r57;
            goto L59
        L53:
            r22 = r56;
            goto L55
        L49:
            r21 = r55;
            goto L51
        L45:
            r20 = r54;
            goto L47
        L41:
            r19 = r53;
            goto L43
        L37:
            r18 = r52;
            goto L39
        L33:
            r17 = r51;
            goto L35
        L29:
            r16 = r50;
            goto L31
        L25:
            r15 = r49;
            goto L27
        L21:
            r14 = r48;
            goto L23
        L17:
            r13 = r47;
            goto L19
        L13:
            r11 = r45;
            goto L15
        L9:
            r10 = r44;
            goto L11
        L5:
            r9 = r43;
            goto L7
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003HÆ\u0003J!\u0010\n\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003HÆ\u0001J\u0006\u0010\u000b\u001a\u00020\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\fHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fR\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$SendMessageTrackExtMap;", "Landroid/os/Parcelable;", "extMap", "", "", "<init>", "(Ljava/util/Map;)V", "getExtMap", "()Ljava/util/Map;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class SendMessageTrackExtMap implements Parcelable {
        public static final Parcelable.Creator<SendMessageTrackExtMap> CREATOR = null;
        public final Map<String, String> a;

        public static final class a implements Parcelable.Creator<SendMessageTrackExtMap> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final SendMessageTrackExtMap createFromParcel(Parcel r6) {
                Intrinsics.checkNotNullParameter(r6, "parcel");
                int r0 = r6.readInt();
                LinkedHashMap r1 = new LinkedHashMap(r0);
                int r2 = 0;
            L3:
                if (r2 == r0) goto L6;
                r1.put(r6.readString(), r6.readString());
                r2 = r2 + 1;
                goto L3
            L6:
                return new SendMessageTrackExtMap(r1);
            }

            @Override // android.os.Parcelable.Creator
            public final SendMessageTrackExtMap[] newArray(int r1) {
                return new SendMessageTrackExtMap[r1];
            }
        }

        static {
            CREATOR = new a();
        }

        public SendMessageTrackExtMap() {
            this(0);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof SendMessageTrackExtMap) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((SendMessageTrackExtMap) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "SendMessageTrackExtMap(extMap=" + this.a + ')';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "dest");
            Map<String, String> r5 = this.a;
            r3.writeInt(r5.size());
            Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            Map.Entry<String, String> r0 = r6.next();
            r3.writeString(r0.getKey());
            r3.writeString(r0.getValue());
            goto L4
        }

        public SendMessageTrackExtMap(Map<String, String> r2) {
            Intrinsics.checkNotNullParameter(r2, "extMap");
            this.a = r2;
        }

        public /* synthetic */ SendMessageTrackExtMap(int r1) {
            this(MapsKt.emptyMap());
        }
    }

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b {
        public static /* synthetic */ boolean b(ICoreInputAbility r1) {
            r1.qp(false);
            return true;
        }

        public static /* synthetic */ void a(ICoreInputAbility r3, int r4) {
            boolean r1 = true;
            if ((r4 & 1) == 0) goto L5;
            boolean r0 = true;
        L7:
            if ((r4 & 2) != 0) goto L10;
            r1 = false;
        L10:
            r3.WM(r0, r1);
            return;
        L5:
            r0 = false;
            goto L7
        }

        public static /* synthetic */ void e(ICoreInputAbility r1, String r2, com.larus.uaigc.music.applet.a1 r3, boolean r4, int r5) {
            if ((r5 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 4) == 0) goto L8;
            r4 = true;
        L8:
            r1.Kh(r2, r3, r4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void c(ICoreInputAbility r8, String r9, boolean r10, SuggestedAction r11, String r12, Map r13, int r14) {
            if ((r14 & 4) == 0) goto L5;
            SuggestedAction r5 = null;
        L7:
            if ((r14 & 8) == 0) goto L9;
            String r6 = null;
        L11:
            if ((r14 & 16) == 0) goto L13;
            Map r7 = null;
        L14:
            r8.SK(r9, r10, r5, r6, r7);
            return;
        L13:
            r7 = r13;
            goto L14
        L9:
            r6 = r12;
            goto L11
        L5:
            r5 = r11;
            goto L7
        }

        public static /* synthetic */ void d(ICoreInputAbility r9, CharSequence r10, boolean r11, boolean r12, Integer r13, Integer r14, boolean r15, int r16) {
            if ((r16 & 2) == 0) goto L5;
            boolean r4 = true;
        L7:
            if ((r16 & 4) == 0) goto L9;
            boolean r5 = false;
        L11:
            if ((r16 & 8) == 0) goto L13;
            Integer r6 = null;
        L15:
            if ((r16 & 16) == 0) goto L17;
            Integer r7 = null;
        L19:
            if ((r16 & 32) == 0) goto L21;
            boolean r8 = true;
        L22:
            r9.M50(r10, r4, r5, r6, r7, r8);
            return;
        L21:
            r8 = r15;
            goto L22
        L17:
            r7 = r14;
            goto L19
        L13:
            r6 = r13;
            goto L15
        L9:
            r5 = r12;
            goto L11
        L5:
            r4 = r11;
            goto L7
        }
    }

    public static final class f {
        public final String a;
        public final boolean b;
        public final boolean c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof f) == true) goto L8;
            return false;
        L8:
            f r6 = (f) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            int r2 = 1231;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (r0 + r1) * 31;
            if (this.c == true) goto L11;
            r2 = 1237;
        L11:
            return r3 + r2;
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "MentionConfig(appId=" + this.a + ", isUserCountVisible=" + this.b + ", isInterruptAtAll=" + this.c + ')';
        }

        public f(String r2) {
            Intrinsics.checkNotNullParameter(r2, "appId");
            this.a = r2;
            this.b = false;
            this.c = true;
        }
    }

    static {
        A1 = a.a;
    }

    void BU(boolean r1, boolean r2, String r3);

    void Ba();

    boolean Bd();

    void C1(boolean r1, boolean r2, String r3);

    boolean CD(boolean r1);

    boolean CS();

    void Dh(Function1<? super Boolean, Unit> r1);

    void Dn(f r1);

    void Dr(boolean r1);

    void E0(OnSendParams r1);

    boolean E50();

    boolean EK();

    String EW();

    void F5(nr9.g r1, String r2, Map<String, String> r3, Map<String, String> r4);

    MessageModifyMode FF();

    void Fz(c r1);

    void I40();

    boolean J8();

    void JJ(wc9.e r1);

    CoreInputAbility JO();

    void Jc(Context r1);

    z8.a Jd();

    void Jm(d r1);

    void Kh(String r1, Function0<Unit> r2, boolean r3);

    com.larus.bmhome.chat.component.bottom.multimodal.sender.f Lk();

    void M5(CharSequence r1);

    void M50(CharSequence r1, boolean r2, boolean r3, Integer r4, Integer r5, boolean r6);

    String N5();

    void PZ(wc9.e r1);

    boolean Pi();

    boolean Q2();

    void Q8(String r1);

    void QG(e r1);

    boolean Qd(boolean r1);

    void Rk();

    int Rp();

    boolean SE(String r1);

    void SK(String r1, boolean r2, SuggestedAction r3, String r4, Map<String, String> r5);

    void SV(Integer r1);

    void Uu(String r1, boolean r2);

    void V40();

    void Vs(e r1);

    void WM(boolean r1, boolean r2);

    void Wy(String r1, long r2, Boolean r4);

    boolean Wz();

    void XG(d r1);

    void YT(e r1);

    void Yk(CharSequence r1);

    void aR(String r1);

    boolean b9();

    void bu(String r1, SuggestedAction r2, String r3, Map r4, Map r5, Map r6);

    boolean c1();

    boolean c2();

    void cp();

    boolean d9();

    void eQ(EditPos r1, BotModel r2);

    void eo();

    void f40(SkillComponent.l r1);

    boolean fa(be8.b r1);

    void g2(int r1, boolean r2);

    void gX(boolean r1);

    boolean gj();

    void iN(Function0<Boolean> r1);

    void jm(wq8.b r1, Message r2, boolean r3, MessageModifyMode r4);

    CoreInputAbility kO(z8.a r1);

    boolean l6();

    boolean lF();

    boolean lW(BotModel r1, String r2);

    void m1(ViewGroup r1);

    boolean m2(String r1);

    boolean m9();

    void mv(String r1, boolean r2);

    void o40();

    void oz(boolean r1);

    void p80(boolean r1);

    void pS(Function0<Boolean> r1);

    g9.c q20();

    void qB(CharSequence r1, boolean r2, boolean r3, boolean r4);

    void qp(boolean r1);

    void r7(Function1<? super Boolean, Unit> r1);

    void rE();

    void s20(int r1);

    void s3(long r1);

    void sQ(com.larus.bmhome.chat.component.title.f0 r1);

    void setEnabled(boolean r1);

    com.larus.bmhome.chat.model.b0 tO();

    void tr(Function1<? super OnSendParams, Boolean> r1);

    void tw(String r1, boolean r2);

    void uG();

    void uU(com.larus.bmhome.chat.component.list.h1 r1, com.larus.bmhome.chat.component.list.i1 r2);

    void uh(int r1);

    void uq(boolean r1);

    void uw(Function1<? super Boolean, Unit> r1);

    void v6(Function2<? super Integer, ? super Long, Unit> r1);

    CharSequence ws(Context r1, String r2);

    boolean wy();

    void zM();

    void zi();

    void zk(String r1);
}
