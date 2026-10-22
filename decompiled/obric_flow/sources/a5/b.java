package a5;

import android.content.ComponentName;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.media.session.f;
import android.support.v4.os.ResultReceiver;
import com.bytedance.ai.applet.components.page.RenderUrlData;
import com.bytedance.ai.applet.render.core.RenderType;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Icons;
import com.bytedance.ai.model.objects.MainInitData;
import com.bytedance.ai.model.objects.Page;
import com.bytedance.ai.model.objects.Plugin;
import com.bytedance.ai.model.objects.ServiceInfo;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.android.monitorV2.hybridSetting.entity.CheckFilter;
import com.bytedance.apm.core.SpPair;
import com.bytedance.common.wschannel.model.IntegerParcelable;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.obric.oui.calendar.CalendarDay;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f97a;

    public /* synthetic */ b(int r5) {
        this.f97a = r5;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel r32) {
        int r5 = 0;
        String r10 = "";
        b.b r11 = null;
        switch(this.f97a) {
            case 0: goto L202;
            case 1: goto L201;
            case 2: goto L181;
            case 3: goto L180;
            case 4: goto L178;
            case 5: goto L176;
            case 6: goto L173;
            case 7: goto L172;
            case 8: goto L169;
            case 9: goto L168;
            case 10: goto L156;
            case 11: goto L143;
            case 12: goto L141;
            case 13: goto L140;
            case 14: goto L137;
            case 15: goto L136;
            case 16: goto L133;
            case 17: goto L132;
            case 18: goto L129;
            case 19: goto L69;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r32, "parcel");
        Intrinsics.checkNotNullParameter(r32, "parcel");
        String r12 = r32.readString();
        if (r12 != null) goto L7;
        String r13 = "";
    L8:
        String r14 = r32.readString();
        if (r14 != null) goto L11;
        String r15 = "";
    L12:
        long r16 = r32.readLong();
        String r17 = r32.readString();
        String r18 = r32.readString();
        if (r18 != null) goto L15;
        String r19 = "";
    L16:
        String r20 = r32.readString();
        if (r20 != null) goto L19;
        String r110 = "";
    L20:
        Icons r111 = (Icons) r32.readParcelable(Icons.class.getClassLoader());
        String r21 = r32.readString();
        if (r21 != null) goto L23;
        String r112 = "";
    L24:
        String r22 = r32.readString();
        if (r22 != null) goto L27;
        String r113 = "";
    L28:
        String r23 = r32.readString();
        if (r23 != null) goto L31;
        String r114 = "";
    L32:
        ArrayList<String> r24 = r32.createStringArrayList();
        String r25 = r32.readString();
        if (r25 != null) goto L35;
        String r26 = "";
    L36:
        String r27 = r32.readString();
        if (r27 != null) goto L39;
        String r28 = "";
    L40:
        String r29 = r32.readString();
        if (r29 != null) goto L43;
        String r210 = "";
    L44:
        String r30 = r32.readString();
        if (r30 != null) goto L47;
        String r211 = "";
    L48:
        String r31 = r32.readString();
        if (r31 != null) goto L51;
        String r212 = "";
    L53:
        if (r32.readByte() == 0) goto L55;
        boolean r213 = true;
    L56:
        Widget r33 = new Widget(r13, r15, r16, r17, r19, r110, r111, r112, r113, r114, r24, r26, r28, r210, r211, r212, r213, r32.readInt(), Integer.valueOf(r32.readInt()), null, 524288);
        String r34 = r32.readString();
        if (r34 != null) goto L59;
        r34 = "";
    L59:
        r33.M = r34;
        String r35 = r32.readString();
        if (r35 == null) goto L63;
        r10 = r35;
    L63:
        r33.N = r10;
        ArrayList<String> r36 = r32.createStringArrayList();
        if (r36 != null) goto L67;
        r36 = new ArrayList();
    L67:
        r33.O = r36;
        r33.d(r32);
        return r33;
    L55:
        r213 = false;
        goto L56
    L51:
        r212 = r31;
        goto L53
    L47:
        r211 = r30;
        goto L48
    L43:
        r210 = r29;
        goto L44
    L39:
        r28 = r27;
        goto L40
    L35:
        r26 = r25;
        goto L36
    L31:
        r114 = r23;
        goto L32
    L27:
        r113 = r22;
        goto L28
    L23:
        r112 = r21;
        goto L24
    L19:
        r110 = r20;
        goto L20
    L15:
        r19 = r18;
        goto L16
    L11:
        r15 = r14;
        goto L12
    L7:
        r13 = r12;
        goto L8
    L69:
        Intrinsics.checkNotNullParameter(r32, "parcel");
        Intrinsics.checkNotNullParameter(r32, "parcel");
        String r37 = r32.readString();
        if (r37 != null) goto L72;
        String r38 = "";
    L73:
        String r39 = r32.readString();
        if (r39 != null) goto L76;
        String r40 = "";
    L77:
        long r41 = r32.readLong();
        String r115 = r32.readString();
        String r42 = r32.readString();
        if (r42 != null) goto L80;
        String r116 = "";
    L81:
        String r43 = r32.readString();
        if (r43 != null) goto L84;
        String r117 = "";
    L85:
        Icons r118 = (Icons) r32.readParcelable(Icons.class.getClassLoader());
        String r44 = r32.readString();
        if (r44 != null) goto L88;
        String r119 = "";
    L89:
        String r45 = r32.readString();
        if (r45 != null) goto L92;
        String r120 = "";
    L93:
        String r46 = r32.readString();
        if (r46 != null) goto L96;
        String r121 = "";
    L97:
        ArrayList<String> r122 = r32.createStringArrayList();
        String r47 = r32.readString();
        if (r47 != null) goto L100;
        String r123 = "";
    L101:
        String r48 = r32.readString();
        if (r48 != null) goto L104;
        String r124 = "";
    L105:
        ArrayList r214 = r32.createTypedArrayList(Page.CREATOR);
        ArrayList r215 = r32.createTypedArrayList(Plugin.CREATOR);
        String r49 = r32.readString();
        if (r49 != null) goto L108;
        String r216 = "";
    L109:
        String r50 = r32.readString();
        if (r50 != null) goto L112;
        String r217 = "";
    L113:
        String r51 = r32.readString();
        if (r51 != null) goto L116;
        String r218 = "";
    L117:
        Applet r52 = new Applet(r38, r40, r41, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r214, r215, r216, r217, r218, "");
        String r53 = r32.readString();
        if (r53 != null) goto L120;
        r53 = "";
    L120:
        r52.L = r53;
        String r54 = r32.readString();
        if (r54 != null) goto L123;
        r54 = "";
    L123:
        r52.M = r54;
        String r55 = r32.readString();
        if (r55 == null) goto L127;
        r10 = r55;
    L127:
        r52.O = r10;
        r52.P = (MainInitData) r32.readParcelable(MainInitData.class.getClassLoader());
        r52.Q = r32.createTypedArrayList(ServiceInfo.CREATOR);
        r52.d(r32);
        return r52;
    L116:
        r218 = r51;
        goto L117
    L112:
        r217 = r50;
        goto L113
    L108:
        r216 = r49;
        goto L109
    L104:
        r124 = r48;
        goto L105
    L100:
        r123 = r47;
        goto L101
    L96:
        r121 = r46;
        goto L97
    L92:
        r120 = r45;
        goto L93
    L88:
        r119 = r44;
        goto L89
    L84:
        r117 = r43;
        goto L85
    L80:
        r116 = r42;
        goto L81
    L76:
        r40 = r39;
        goto L77
    L72:
        r38 = r37;
        goto L73
    L129:
        SpPair r56 = new SpPair();
        r56.f3860a = r32.readString();
        r56.f3861b = r32.readValue(SpPair.class.getClassLoader());
        return r56;
    L133:
        WsChannelMsg r57 = new WsChannelMsg();
        r57.f4006a = r32.readLong();
        r57.f4007b = r32.readLong();
        r57.f4008c = r32.readInt();
        r57.d = r32.readInt();
        r57.e = r32.createTypedArrayList(WsChannelMsg.MsgHeader.CREATOR);
        r57.f = r32.readString();
        r57.g = r32.readString();
        r57.f4009h = r32.createByteArray();
        r57.f4010i = (ComponentName) r32.readParcelable(ComponentName.class.getClassLoader());
        r57.f4011j = r32.readInt();
        return r57;
    L137:
        SocketState r58 = new SocketState();
        r58.f3996a = r32.readInt();
        r58.f3997b = r32.readInt();
        r58.f3998c = r32.readString();
        r58.d = r32.readInt();
        r58.e = r32.readInt();
        r58.f = r32.readString();
        r58.g = r32.readInt();
        return r58;
    L141:
        com.bytedance.apm.util.SpPair r59 = new com.bytedance.apm.util.SpPair();
        r59.f3902a = r32.readString();
        r59.f3903b = r32.readValue(com.bytedance.apm.util.SpPair.class.getClassLoader());
        return r59;
    L143:
        Intrinsics.checkNotNullParameter(r32, "parcel");
        RenderType r60 = RenderType.valueOf(r32.readString());
        if (r32.readInt() == 0) goto L146;
        boolean r61 = true;
    L148:
        if (r32.readInt() == 0) goto L150;
        boolean r62 = true;
    L151:
        String r125 = r32.readString();
        int r63 = r32.readInt();
        LinkedHashMap r126 = new LinkedHashMap(r63);
    L152:
        if (r5 == r63) goto L155;
        r126.put(r32.readString(), r32.readString());
        r5 = r5 + 1;
        goto L152
    L155:
        return new RenderUrlData(r60, r61, r62, r125, r126);
    L150:
        r62 = false;
        goto L151
    L146:
        r61 = false;
        goto L148
    L156:
        ResultReceiver r64 = new ResultReceiver();
        IBinder r65 = r32.readStrongBinder();
        int r66 = b.c.f803b;
        if (r65 == null) goto L165;
        IInterface r67 = r65.queryLocalInterface(b.b.f802g1);
        if (r67 != null) goto L162;
    L164:
        b.a r68 = new b.a();
        r68.f801a = r65;
        r11 = r68;
        goto L165
    L162:
        if ((r67 instanceof b.b) == false) goto L164;
        r11 = (b.b) r67;
    L165:
        r64.f400a = r11;
        return r64;
    L169:
        ParcelableVolumeInfo r69 = new ParcelableVolumeInfo();
        r69.f381a = r32.readInt();
        r69.f383c = r32.readInt();
        r69.d = r32.readInt();
        r69.e = r32.readInt();
        r69.f382b = r32.readInt();
        return r69;
    L173:
        MediaSessionCompat$ResultReceiverWrapper r70 = new MediaSessionCompat$ResultReceiverWrapper();
        r70.f378a = (android.os.ResultReceiver) android.os.ResultReceiver.CREATOR.createFromParcel(r32);
        return r70;
    L181:
        Object r71 = MediaDescription.CREATOR.createFromParcel(r32);
        if (r71 == null) goto L205;
        MediaDescription r72 = (MediaDescription) r71;
        String r73 = r72.getMediaId();
        CharSequence r74 = r72.getTitle();
        CharSequence r75 = r72.getSubtitle();
        CharSequence r76 = r72.getDescription();
        Bitmap r127 = r72.getIconBitmap();
        Uri r128 = r72.getIconUri();
        Bundle r77 = r72.getExtras();
        if (r77 == null) goto L186;
        f.a(r77);
        Uri r78 = (Uri) r77.getParcelable("android.support.v4.media.description.MEDIA_URI");
    L187:
        if (r78 != null) goto L189;
    L194:
        Bundle r129 = r77;
    L195:
        if (r78 == null) goto L197;
        Uri r130 = r78;
    L198:
        MediaDescriptionCompat r79 = new MediaDescriptionCompat(r73, r74, r75, r76, r127, r128, r129, r130);
        r79.f360i = r71;
        return r79;
    L197:
        r130 = r72.getMediaUri();
        goto L198
    L189:
        if (r77.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") == true) goto L191;
    L193:
        r77.remove("android.support.v4.media.description.MEDIA_URI");
        r77.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
        goto L194
    L191:
        if (r77.size() != 2) goto L193;
        r129 = null;
        goto L195
    L186:
        r78 = null;
        goto L187
    L205:
        return null;
    L202:
        Intrinsics.checkNotNullParameter(r32, "source");
        return new CheckFilter(r32);
    L132:
        return new CalendarDay(r32.readInt(), r32.readInt(), r32.readInt());
    L136:
        return new SsWsApp(r32);
    L140:
        return new IntegerParcelable(r32);
    L168:
        return new PlaybackStateCompat(r32);
    L172:
        return new MediaSessionCompat$Token(r32.readParcelable(null), null);
    L176:
        return new MediaSessionCompat$QueueItem(r32);
    L178:
        return new RatingCompat(r32.readFloat(), r32.readInt());
    L180:
        return new MediaMetadataCompat(r32);
    L201:
        return new MediaBrowserCompat$MediaItem(r32);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int r5) {
        switch(this.f97a) {
            case 0: goto L45;
            case 1: goto L43;
            case 2: goto L41;
            case 3: goto L39;
            case 4: goto L37;
            case 5: goto L35;
            case 6: goto L33;
            case 7: goto L31;
            case 8: goto L29;
            case 9: goto L27;
            case 10: goto L25;
            case 11: goto L23;
            case 12: goto L21;
            case 13: goto L19;
            case 14: goto L17;
            case 15: goto L15;
            case 16: goto L13;
            case 17: goto L11;
            case 18: goto L9;
            case 19: goto L7;
            default: goto L5;
        };
    L5:
        return new Widget[r5];
    L7:
        return new Applet[r5];
    L9:
        return new SpPair[r5];
    L11:
        return new CalendarDay[r5];
    L13:
        return new WsChannelMsg[r5];
    L15:
        return new SsWsApp[r5];
    L17:
        return new SocketState[r5];
    L19:
        return new IntegerParcelable[r5];
    L21:
        return new com.bytedance.apm.util.SpPair[r5];
    L23:
        return new RenderUrlData[r5];
    L25:
        return new ResultReceiver[r5];
    L27:
        return new PlaybackStateCompat[r5];
    L29:
        return new ParcelableVolumeInfo[r5];
    L31:
        return new MediaSessionCompat$Token[r5];
    L33:
        return new MediaSessionCompat$ResultReceiverWrapper[r5];
    L35:
        return new MediaSessionCompat$QueueItem[r5];
    L37:
        return new RatingCompat[r5];
    L39:
        return new MediaMetadataCompat[r5];
    L41:
        return new MediaDescriptionCompat[r5];
    L43:
        return new MediaBrowserCompat$MediaItem[r5];
    L45:
        return new CheckFilter[r5];
    }
}
