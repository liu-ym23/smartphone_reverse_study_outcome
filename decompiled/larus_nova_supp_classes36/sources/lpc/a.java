package lpc;

import com.ss.android.lark.chat.base.view.vo.message.FileContentVO;
import com.ss.android.lark.chat.base.view.vo.message.ImageContentVO;
import com.ss.android.lark.chat.base.view.vo.message.MediaContentVO;
import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.ss.android.lark.chat.base.view.vo.message.StickerContentVO;
import com.ss.android.lark.chat.base.view.vo.message.b;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import kotlin.jvm.JvmStatic;
import y6b.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {

    /* JADX INFO: renamed from: lpc.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0295a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Message.Type.values().length];
            r0[Message.Type.POST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[Message.Type.IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[Message.Type.MEDIA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[Message.Type.FILE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[Message.Type.FOLDER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[Message.Type.STICKER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[Message.Type.CARD.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            a = r0;
        }
    }

    static {
    }

    @JvmStatic
    public static final ResourceCleanScene a(Message r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        Message.Type r1 = r3.getType();
        if (r1 != null) goto L8;
        int r2 = -1;
    L9:
        switch(r2) {
            case 1: goto L18;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            default: goto L25;
        };
    L25:
        return null;
    L19:
        return r3.getContent().firstResourceScene();
    L20:
        return r3.getContent().currentResourceScene();
    L21:
        return r3.getContent().currentResourceScene();
    L22:
        return r3.getContent().currentResourceScene();
    L23:
        return r3.getContent().currentResourceScene();
    L24:
        return r3.getContent().currentResourceScene();
    L18:
        return r3.getContent().firstResourceScene();
    L8:
        r2 = C0295a.a[r1.ordinal()];
        goto L9
    }

    @JvmStatic
    public static final ResourceCleanScene b(y6b.a<?> r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        FileContentVO r3 = r2.b();
        if ((r3 instanceof FileContentVO) == false) goto L9;
        return ((v5b.a) r3).a.currentResourceScene();
    L9:
        if ((r3 instanceof com.ss.android.lark.chat.base.view.vo.message.a) == false) goto L12;
        return ((v5b.a) ((com.ss.android.lark.chat.base.view.vo.message.a) r3)).a.currentResourceScene();
    L12:
        if ((r3 instanceof ImageContentVO) == false) goto L15;
        return ((v5b.a) ((ImageContentVO) r3)).a.currentResourceScene();
    L15:
        if ((r3 instanceof MediaContentVO) == false) goto L18;
        return ((v5b.a) ((MediaContentVO) r3)).a.currentResourceScene();
    L18:
        if ((r3 instanceof StickerContentVO) == false) goto L21;
        return ((v5b.a) ((StickerContentVO) r3)).a.currentResourceScene();
    L21:
        if ((r3 instanceof PostContentVO) == false) goto L24;
        return ((v5b.a) ((PostContentVO) r3)).a.firstResourceScene();
    L24:
        if ((r3 instanceof b) == true) goto L26;
        return null;
    L26:
        return ((b) r3).b();
    }

    @JvmStatic
    public static final boolean c(Message r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        Message.Type r1 = r3.getType();
        if (r1 != null) goto L8;
        int r2 = -1;
    L9:
        switch(r2) {
            case 1: goto L18;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            default: goto L25;
        };
    L25:
        return false;
    L19:
        return r3.getContent().resourceIsCleaned();
    L20:
        return r3.getContent().resourceIsCleaned();
    L21:
        return r3.getContent().resourceIsCleaned();
    L22:
        return r3.getContent().resourceIsCleaned();
    L23:
        return r3.getContent().resourceIsCleaned();
    L24:
        return r3.getContent().resourceIsCleaned();
    L18:
        return r3.getContent().resourceIsCleaned();
    L8:
        r2 = C0295a.a[r1.ordinal()];
        goto L9
    }

    @JvmStatic
    public static final boolean d(c<?> r1) {
        if (r1 == null) goto L4;
        v5b.a r2 = r1.o;
    L6:
        if ((r2 instanceof PostContentVO) == false) goto L9;
        return ((v5b.a) ((PostContentVO) r2)).a.resourceIsCleaned();
    L9:
        if ((r2 instanceof ImageContentVO) == false) goto L12;
        return ((v5b.a) ((ImageContentVO) r2)).a.resourceIsCleaned();
    L12:
        if ((r2 instanceof MediaContentVO) == false) goto L15;
        return ((v5b.a) ((MediaContentVO) r2)).a.resourceIsCleaned();
    L15:
        if ((r2 instanceof FileContentVO) == false) goto L18;
        return ((v5b.a) ((FileContentVO) r2)).a.resourceIsCleaned();
    L18:
        if ((r2 instanceof StickerContentVO) == false) goto L21;
        return ((v5b.a) ((StickerContentVO) r2)).a.resourceIsCleaned();
    L21:
        if ((r2 instanceof com.ss.android.lark.chat.base.view.vo.message.a) == false) goto L24;
        return ((v5b.a) ((com.ss.android.lark.chat.base.view.vo.message.a) r2)).a.resourceIsCleaned();
    L24:
        if ((r2 instanceof b) == true) goto L34;
        return false;
    L34:
        return ((b) r2).a();
    L4:
        r2 = null;
        goto L6
    }
}
