package rs8;

import android.view.View;
import com.larus.bmhome.view.actionbar.ActionStyle;
import com.larus.bmhome.view.actionbar.MessageActionBarAlign;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface g {
    String a();

    MessageActionBarAlign b();

    Function1<View, Unit> c();

    String d();

    CharSequence getDescription();

    int getId();

    ActionStyle getStyle();
}
