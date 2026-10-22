package c;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.zte.miboard.cards.R;

/* JADX INFO: loaded from: classes.dex */
public class e extends n implements View.OnClickListener {
    public e() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        r5.getId();
    }

    @Override // c.n, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        setContentView(R.layout.express_download_jd);
        ((Button) findViewById(R.id.express_download_jd_button)).setOnClickListener(new ar.a(this, 1));
    }
}
