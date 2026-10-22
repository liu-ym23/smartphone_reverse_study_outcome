package z1b;

import com.ss.android.lark.chat.entity.message.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Message.Type.values().length];
            a = r0;
            r0[Message.Type.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L30:
            a[Message.Type.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L36:
            a[Message.Type.IMAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L50:
            a[Message.Type.MEDIA.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L32:
            a[Message.Type.FILE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L38:
            a[Message.Type.STICKER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L42:
            a[Message.Type.AUDIO.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L46:
            a[Message.Type.LOCATION.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L28:
            a[Message.Type.RED_PACKET.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L34:
            a[Message.Type.SHARE_GROUP_CHAT.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L40:
            a[Message.Type.MERGE_FORWARD.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L44:
            a[Message.Type.SHARE_USER_CARD.ordinal()] = 12;     // Catch: NoSuchFieldError -> L27
            return;
        }
    }

    public static String a(Message.Type r1) {
        switch(a.a[r1.ordinal()]) {
            case 1: goto L28;
            case 2: goto L26;
            case 3: goto L24;
            case 4: goto L22;
            case 5: goto L20;
            case 6: goto L18;
            case 7: goto L16;
            case 8: goto L14;
            case 9: goto L12;
            case 10: goto L10;
            case 11: goto L8;
            case 12: goto L6;
            default: goto L4;
        };
    L4:
        return null;
    L6:
        return "share_user_card";
    L8:
        return "merge_forward";
    L10:
        return "share_group";
    L12:
        return "red_packet";
    L14:
        return "location";
    L16:
        return "audio";
    L18:
        return "sticker";
    L20:
        return "file";
    L22:
        return "media";
    L24:
        return "image";
    L26:
        return "post";
    L28:
        return "text";
    }
}
