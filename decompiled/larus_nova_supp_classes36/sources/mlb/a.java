package mlb;

import android.app.Activity;
import android.graphics.Bitmap;
import com.ss.android.lark.imageqrcode.QRCodeResultInfo;
import dxa.g;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface a {
    g decodeQRCode(String r1);

    ArrayList<QRCodeResultInfo> decodeQRCode(Bitmap r1);

    void openResultPage(Activity r1, String r2);
}
