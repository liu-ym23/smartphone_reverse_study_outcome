package h7b;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.bundle.ChatType;
import com.ss.android.lark.chat.base.view.vo.message.ImageContentVO;
import com.ss.android.lark.chat.component.ChatInitErrorComponent$showOpenChatError$1;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.translate.dialog.MoreTranslateActionDialog;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i {
    public static int a;
    public static int b;
    public static int c;
    public static int d;
    public static boolean e;

    public interface a {
        void a(String r1);

        void b(MoreTranslateActionDialog.MoreActionType r1);
    }

    public interface b {
        void onCancel();

        void onConfirm();
    }

    public static void d(Context r3, final b r4) {
        com.larksuite.component.ui.dialog.d r0 = new com.larksuite.component.ui.dialog.d(r3);
        r0.c.message(2131890839);
        r0.a(2131378550, 2131891544, new h7b.a(r4));
        r0.a(2131378551, 2131891628, new h7b.b(r4));
        r0.i();
    }

    public static void a(ChatType r3, boolean r4, ErrorResult r5) {
        int r0 = r5.getErrorCode();
        if (r0 == 4051) goto L9;
        switch(r0) {
            case 1: goto L9;
            case 2: goto L9;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L10;
        };
    L6:
        r0 = 4;
        goto L10
    L7:
        r0 = 3;
        goto L10
    L8:
        r0 = 2;
    L10:
        Log.d("ActionUtils", "perfOpenChatFailed:" + r3 + "/" + r0);
        x1b.c r1 = ChatCoreModule.a().getPerfEnterChatMonitor();
        if (r3 == null) goto L13;
        String r6 = r3.value;
    L14:
        r1.e(r6, r4, new ErrorResult(r0, r5.getDisplayMsg()));
        return;
    L13:
        r6 = BuildConfig.FLAVOR;
    L9:
        r0 = 1;
        goto L10
    }

    public static void b(Context r2, String r3, String r4) {
        com.larksuite.component.ui.dialog.d r0 = new com.larksuite.component.ui.dialog.d(r2);
        r0.c.titleLineCount(2);
        r0.c.titleBold(true);
        r0.k(r3);
        r0.h(r4);
        r0.a(2131378551, 2131890808, null);
        r0.i();
    }

    public static void c(Context r6, ErrorResult r7, ChatInitErrorComponent$showOpenChatError$1.a r8) {
        String r0 = r7.getDisplayMsg();
        int r1 = r7.getErrorCode();
        if (r1 != 1) goto L5;
        LKUIToast.show(r6, 2131891567);
        return;
    L5:
        if (r1 != 2) goto L7;
        LKUIToast.show(r6, 2131892100);
        return;
    L7:
        if (r1 == 3) goto L29;
        if (r1 == 4) goto L22;
        if (r1 == 8) goto L22;
        if (r1 != 4051) goto L15;
        pkb.b.a(r7.getDisplayMsg(), r8);
        return;
    L15:
        if (r1 != 6002) goto L17;
        String r9 = r7.getDisplayMsg();
        com.larksuite.component.ui.dialog.d r10 = new com.larksuite.component.ui.dialog.d(r6);
        r10.k(y9c.d.i(r6, 2131890782));
        r10.c.titleBold(true);
        r10.c.titleLineCount(2);
        r10.h(r9);
        r10.b(2131378551, y9c.d.i(r6, 2131891809), null);
        r10.i();
        return;
    L17:
        if (TextUtils.isEmpty(r7.getDisplayMsg()) == true) goto L35;
        LKUIToast.show(r6, r7.getDisplayMsg());
        return;
    L35:
        return;
    L22:
        if (TextUtils.isEmpty(r0) == true) goto L24;
    L27:
        pkb.b.a(r0, r8);
        return;
    L24:
        if (r7.getErrorCode() != 4) goto L26;
        r0 = UIUtils.getString(r6, 2131891449);
        goto L27
    L26:
        r0 = UIUtils.getString(r6, 2131890698);
        goto L27
    L29:
        if (TextUtils.isEmpty(r0) == false) goto L31;
        r0 = UIHelper.getString(2131891567);
    L31:
        pkb.b.a(r0, r8);
    }

    public static void e(FragmentActivity r5, ImageView r6, ImageContentVO r7) {
        if (r7 == null) goto L12;
        Image r1 = (Image) r7.k.getValue();
        if (r1 != null) goto L7;
    L11:
        Log.w("ActionUtils", "thumbnail or urls is null, image key is " + ((String) r7.h.getValue()));
    L13:
        r1 = null;
    L14:
        a = y9c.d.a(8);
        b = y9c.d.a(8);
        c = y9c.d.a(40);
        d = y9c.d.a(40);
        if (r1 != null) goto L17;
        Log.w("ActionUtils", "thumbnail == null");
        IRequestCreator r8 = ImageLoader.with(r5).load(2131233569);
    L21:
        r8.downloadOnly(new f(r5, r6));
        return;
    L17:
        if (r1.getKey() == null) goto L19;
        r8 = ImageLoader.with(r5).load(new EncryptImage(r1.getKey(), r1.getFsUnit(), r1.getCrypto())).dontAnimate(false).placeholder(2131233569).error(2131233587);
        goto L21
    L19:
        Log.w("ActionUtils", "thumbnail.getKey == null");
        r8 = ImageLoader.with(r5).load(2131233587);
        goto L21
    L7:
        if (r1.getKey() != null) goto L14;
        if (CollectionUtils.isNotEmpty(r1.getUrls()) == false) goto L11;
    L12:
        Log.w("ActionUtils", "ImageContent is null");
        goto L13
    }
}
